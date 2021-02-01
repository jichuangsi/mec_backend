package com.jichuangsi.mes.advice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jichuangsi.mes.common.IPConfig;
import com.jichuangsi.mes.entity.SStaff;
import com.jichuangsi.mes.entity.SSystemlog;
import com.jichuangsi.mes.model.UserInfoForToken;
import com.jichuangsi.mes.repository.UserRepository;
import com.jichuangsi.mes.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 切面处理类，操作日志异常日志记录处理
 *
 * @author
 * @date 2019/03/21
 */
@Aspect
@Component
public class OperLogAspect {
    /**
     * 操作版本号
     * <p>
     * 项目启动时从命令行传入，例如：java -jar xxx.war --version=201902
     * </p>
     */
    /*@Value("${version}")
    private String operVer;*/

   @Resource//@Autowired
    private LogService logService;
    @Autowired
    private Algorithm tokenAlgorithm;
    @Value("${custom.token.userClaim}")
    private String userClaim;
    @Resource
    private UserRepository userRepository;
    private Map<String,String> requestTimes=new WeakHashMap<>();

    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.jichuangsi.mes.advice.OperLog)")
    public void operLogPoinCut() {
    }

    /**
     * 扫描所有controller包下操作
     */
    @Pointcut("execution(* com.jichuangsi.mes.controller..*.*(..))")
    public void cut() {
    }

    /**
     * 设置操作异常切入点记录异常日志 扫描所有controller包下操作
     */
    @Pointcut("execution(* com.jichuangsi.mes.controller..*.*(..))")
    public void operExceptionLogPoinCut() {
    }

    /**
     * 正常返回通知，拦截用户操作日志，连接点正常执行完成后执行， 如果连接点抛出异常，则不会执行
     *
     * @param joinPoint 切入点
     * @param keys      返回结果
     */
    @AfterReturning(value = "operLogPoinCut()", returning = "keys")
    public void saveOperLog(JoinPoint joinPoint, Object keys) {
        long startTime=Long.valueOf(requestTimes.get("startTime"));
        long endTime= System.currentTimeMillis() - startTime;
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);

        SSystemlog operlog = new SSystemlog();
        try {
            //operlog.setOperId(UuidUtil.get32UUID()); // 主键ID
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            // 获取操作
            OperLog opLog = method.getAnnotation(OperLog.class);
            if (opLog != null) {
                String operModul = opLog.operModul();
                String operType = opLog.operType();
                String operDesc = opLog.operDesc();
                operlog.setOperModel(operModul); // 操作模块
                operlog.setLogType(Integer.valueOf(operType)); // 操作类型
                operlog.setOperates(operDesc); // 操作描述
            }
            // 获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();
            // 获取请求的方法名
            String methodName = method.getName();
            methodName = className + "." + methodName;
            //重点 这里就是获取@RequestBody参数的关键  调试的情况下 可以看到o变量已经获取到了请求的参数
            Object[] o = joinPoint.getArgs();
            //String a=Arrays.toString(o);
            joinPoint.getArgs();
            Object[] arguments = new Object[o.length];
            System.out.println("================:"+o);
            for (int i = 0; i < o.length; i++) {
                if (o[i] instanceof ServletRequest || o[i] instanceof ServletResponse || o[i] instanceof MultipartFile) {
                    //ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
                    //ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
                    continue;
                }
                arguments[i] = o[i];
            }
            String paramter = "";
            if (arguments != null) {
                try {
                    paramter = JSONObject.toJSONString(arguments);
                } catch (Exception e) {
                    paramter = arguments.toString();
                }
            }
            //System.out.println("================:"+paramter.toString());
            //String jsonString2 = JSON.toJSONString(o);
            //String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames(); // 参数名
            //operlog.setOperMethod(methodName); // 请求方法
           /*Map<String, String> rtnMap=null;
            if(request.getMethod().equals("GET")){
                // 请求的参数
                rtnMap = converMap(request.getParameterMap());
            }else {
                String data=this.getPostData(request);
            }*/
            // 将参数所在的数组转换成json
            //String params = JSON.toJSONString(rtnMap);
            //operlog.setRequestParam(params); // 请求参数paramter.toString()
            operlog.setRequestParam(paramter.toString()); // 请求参数
            //operlog.setOperRespParam(JSON.toJSONString(keys)); // 返回结果
            String accessToken=request.getHeader("accessToken");
            if(StringUtils.isEmpty(accessToken)){
                JSONArray jsonArray = JSON.parseArray(paramter.toString());

                for(Object o2 : jsonArray){
                    JSONObject jsonObject = (JSONObject) o2;
                    if(jsonObject!=null){
                        Object account=jsonObject.get("account");
                        //System.out.println(jsonObject.get("account"));
                        if(account!=null){
                            SStaff staff=userRepository.findByStaffNum(account.toString());
                            if(staff!=null){
                                operlog.setStaffId(Integer.valueOf(staff.getId())); // 请求用户ID
                                operlog.setUserName(staff.getStaffName());
                            }else {
                                operlog.setStaffId(0); // 请求用户ID
                                operlog.setUserName("暂无此用户："+account.toString());
                            }
                        }
                    }
                }
            }else{
//                final JWTVerifier verifier=JWT.require(tokenAlgorithm).build();
//                verifier.verify(accessToken);
                DecodedJWT jwt=JWT.decode(accessToken);
                String userId=jwt.getClaim(userClaim).asString();
                UserInfoForToken userInfo=JSONObject.parseObject(userId,UserInfoForToken.class);
                operlog.setStaffId(Integer.valueOf(userInfo.getUserId())); // 请求用户ID
                operlog.setUserName(userInfo.getUserName());
            }
            //operlog.setStaffId(Integer.valueOf(rtnMap.get("account"))); // 请求用户ID
            //operlog.setOperUserName(UserShiroUtil.getCurrentUserName()); // 请求用户名称
            operlog.setOperaterIp(IPConfig.getIp(request)); // 请求IP
            operlog.setRequestURL(request.getRequestURI()); // 请求URI
            operlog.setCreateTime(new Date().getTime()); // 创建时间
            operlog.setRequestMode(request.getMethod());
            operlog.setRequestTime(String.valueOf(endTime));
            operlog.setDeleteNo(0);
            operlog.setUserAgent(request.getHeader("User-Agent"));
            if(keys!=null){
                JSONObject json=(JSONObject) JSONObject.toJSON(keys);
                operlog.setResultSet(o.toString());
                Object c=json.get("code");
                if(c!=null){
                    if(c.toString().equals("0010")){
                        operlog.setLoginState(1);
                    }else {
                        operlog.setLoginState(2);
                        if(json.get("msg")!=null){
                            operlog.setFailMessage(json.get("msg").toString());
                        }
                    }
                }
            }
            //operlog.setOperVer(operVer); // 操作版本
            logService.addLog2(operlog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Around("cut()")
    public Object timeAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime;
        long endTime;
        Object obj;
        // 获取开始时间
        startTime = System.currentTimeMillis();
        requestTimes.remove("startTime");
        requestTimes.put("startTime",String.valueOf(startTime));
        // 获取返回结果集
        obj = joinPoint.proceed(joinPoint.getArgs());
        // 获取方法执行时间
        endTime= System.currentTimeMillis() - startTime;
        String classAndMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        //logger.info("执行 " + classAndMethod + " 耗时为：" + endTime+ "ms");
        return obj;
    }

    /**
     * 异常返回通知，用于拦截异常日志信息 连接点抛出异常后执行
     *
     * @param joinPoint 切入点
     * @param e         异常信息
     */
    @AfterThrowing(pointcut = "operExceptionLogPoinCut()", throwing = "e")
    public void saveExceptionLog(JoinPoint joinPoint, Throwable e) {
        long startTime=Long.valueOf(requestTimes.get("startTime"));
        long endTime= System.currentTimeMillis() - startTime;
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);

        //ExceptionLog excepLog = new ExceptionLog();
        SSystemlog excepLog = new SSystemlog();
        try {
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            //excepLog.setExcId(UuidUtil.get32UUID());
            // 获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();
            // 获取请求的方法名
            String methodName = method.getName();
            methodName = className + "." + methodName;
            Object[] o = joinPoint.getArgs();
            joinPoint.getArgs();
            Object[] arguments = new Object[o.length];
            System.out.println("================:"+o);
            for (int i = 0; i < o.length; i++) {
                if (o[i] instanceof ServletRequest || o[i] instanceof ServletResponse || o[i] instanceof MultipartFile) {
                    continue;
                }
                arguments[i] = o[i];
            }
            String paramter = "";
            if (arguments != null) {
                try {
                    paramter = JSONObject.toJSONString(arguments);
                } catch (Exception ex) {
                    paramter = arguments.toString();
                }
            }
            excepLog.setRequestParam(paramter.toString()); // 请求参数
            //operlog.setOperRespParam(JSON.toJSONString(keys)); // 返回结果
            String accessToken=request.getHeader("accessToken");
            if(StringUtils.isEmpty(accessToken)){
                JSONArray jsonArray = JSON.parseArray(paramter.toString());

                for(Object o2 : jsonArray){
                    JSONObject jsonObject = (JSONObject) o2;
                    if(jsonObject!=null){
                        Object account=jsonObject.get("account");
                        //System.out.println(jsonObject.get("account"));
                        if(account!=null){
                            SStaff staff=userRepository.findByStaffNum(account.toString());
                            excepLog.setStaffId(Integer.valueOf(staff.getId())); // 请求用户ID
                            excepLog.setUserName(staff.getStaffName());
                        }
                    }
                }
            }else{
//                final JWTVerifier verifier=JWT.require(tokenAlgorithm).build();
//                verifier.verify(accessToken);
                DecodedJWT jwt=JWT.decode(accessToken);
                String userId=jwt.getClaim(userClaim).asString();
                UserInfoForToken userInfo=JSONObject.parseObject(userId,UserInfoForToken.class);
                excepLog.setStaffId(Integer.valueOf(userInfo.getUserId())); // 请求用户ID
                excepLog.setUserName(userInfo.getUserName());
            }
            excepLog.setExceptionName(e.getClass().getName()); // 异常名称
            excepLog.setExceptionMessage(stackTraceToString(e.getClass().getName(), e.getMessage(), e.getStackTrace())); // 异常信息
            excepLog.setRequestURL(request.getRequestURI()); // 操作URI
            excepLog.setOperaterIp(IPConfig.getIp(request)); // 操作员IP
            excepLog.setRequestMode(request.getMethod());
            excepLog.setRequestTime(String.valueOf(endTime));
            excepLog.setDeleteNo(0);
            excepLog.setUserAgent(request.getHeader("User-Agent"));
            excepLog.setCreateTime(new Date().getTime()); // 创建时间
            excepLog.setLoginState(2);
            //excepLog.setOperVer(operVer); // 操作版本号
            //excepLog.setOperCreateTime(new Date()); // 发生异常时间
            excepLog.setLogType(3); // 操作类型
            logService.addLog2(excepLog);

        } catch (Exception e2) {
            e2.printStackTrace();
        }

    }

    /**
     * 转换request 请求参数
     *
     * @param paramMap request获取的参数数组
     */
    public Map<String, String> converMap(Map<String, String[]> paramMap) {
        Map<String, String> rtnMap = new HashMap<String, String>();
        for (String key : paramMap.keySet()) {
            rtnMap.put(key, paramMap.get(key)[0]);
        }
        return rtnMap;
    }

    /**
     * 转换异常信息为字符串
     *
     * @param exceptionName    异常名称
     * @param exceptionMessage 异常信息
     * @param elements         堆栈信息
     */
    public String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
        StringBuffer strbuff = new StringBuffer();
        for (StackTraceElement stet : elements) {
            strbuff.append(stet + "\n");
        }
        String message = exceptionName + ":" + exceptionMessage + "\n\t" + strbuff.toString();
        return message;
    }

    private String getPostData(HttpServletRequest req) throws IOException {
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String body = IOUtils.read(reader);*/
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Object myParam = JSON.parseObject(body);
        return body;
        /*BufferedReader bufferReaderBody = null;

        try {

            bufferReaderBody = new BufferedReader(req.getReader());
            String postData = bufferReaderBody.readLine();

            return postData;
        } catch (IOException e) {

            throw e;

        } finally {

            if (bufferReaderBody != null) {
                bufferReaderBody.close();
            }
        }*/
    }
}
