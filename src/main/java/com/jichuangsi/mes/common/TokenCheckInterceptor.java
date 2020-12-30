//package com.jichuangsi.mes.common;
//
//import com.alibaba.fastjson.JSONObject;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.jichuangsi.mes.model.ResponseModel;
//import com.jichuangsi.mes.service.UserService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.NamedThreadLocal;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StreamUtils;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.SimpleDateFormat;
//
//@Component
//public class TokenCheckInterceptor implements HandlerInterceptor {
//    private Logger logger = LoggerFactory.getLogger(getClass());
//    @Value("${custom.token.ingoreTokenUrls}")
//    private String[] ingoreTokenUrls;
//    @Value("${custom.token.cache.expireAfterAccessWithMinutes}")
//    private long expireAfterAccessWithMinutes;
//    @Value("${custom.token.userClaim}")
//    private String userClaim;
//    @Autowired
//    private Algorithm tokenAlgorithm;
//    @Resource
//    private UserService userService;
//
//    private static final ThreadLocal<Long> startTimeThreadLocal =
//            new NamedThreadLocal<Long>("ThreadLocal StartTime");
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        final String url=request.getRequestURI();//地址
//        long begin_nao_time = System.nanoTime();
//        //获取请求参数
//        String queryString = request.getQueryString();
//        logger.info("请求参数:{}", queryString);
//
//        //获取请求body
//        byte[] bodyBytes = StreamUtils.copyToByteArray(request.getInputStream());
//        String body = new String(bodyBytes, request.getCharacterEncoding());
//
//        logger.info("请求体：{}", body.toString());
//        System.out.print("1111========="+begin_nao_time+"dizhi"+request.getRequestURI());
//
//        long beginTime = System.currentTimeMillis();//1、开始时间
//        startTimeThreadLocal.set(beginTime);        //线程绑定变量（该数据只有当前请求的线程可见）
//        logger.debug("开始计时: {}  URI: {}", new SimpleDateFormat("hh:mm:ss.SSS")
//                .format(beginTime), request.getRequestURI());
//        return true;
////        if(null!=ingoreTokenUrls && ingoreTokenUrls.length>0){
////            for (String ingoreUrl : ingoreTokenUrls) {
////                if (ingoreUrl.equals(url) || url.startsWith(ingoreUrl)) {// 对免检查token的url放行
////                    return true;
////                }
////            }
////        }
////        try {
////            String accessToken=request.getHeader("accessToken");
////            Enumeration<String> headers=request.getHeaderNames();
////            String m =request.getMethod();
////            if (request.getMethod().equals("OPTIONS")) {
////                return true;
////            }
////            if(!StringUtils.isEmpty(accessToken)){
////                final JWTVerifier verifier=JWT.require(tokenAlgorithm).build();
////                verifier.verify(accessToken);
////                DecodedJWT jwt=JWT.decode(accessToken);
////                String userId=jwt.getClaim(userClaim).asString();
////                UserInfoForToken userInfo=JSONObject.parseObject(userId,UserInfoForToken.class);
////                if (userInfo.getRoleId().equalsIgnoreCase("123456")){
////                    return true;
////                }
////                if (!userService.getUrlMethodByRole(userInfo,url)){
////                    returnJson(response,request,ResultCode.TOKEN_CHECK_ERR,ResultCode.NO_ACCESS);
////                }else {
////                    return true;
////                }
////            }else {
////                returnJson(response,request,ResultCode.TOKEN_MISS,ResultCode.TOKEN_MISS_MSG);
////            }
////        }catch (JWTVerificationException e){
////            logger.error("token检验不通过：" + e.getMessage());
////            returnJson(response,request,ResultCode.TOKEN_CHECK_ERR,ResultCode.TOKEN_CHECK_ERR_MSG);
////            //return false;
////        }catch (PassportException e) {
////            e.printStackTrace();
////            logger.error(e.getMessage());
////            returnJson(response,request,ResultCode.SYS_ERROR,e.getMessage());
////            //return false;
////        }catch (Exception e) {
////            e.printStackTrace();
////            logger.error(e.getMessage());
////            returnJson(response,request,ResultCode.SYS_ERROR,ResultCode.SYS_ERROR_MSG);
////            //return false;
////        }
////        return false;
//    }
//
//    @Override
//    public void  afterCompletion(HttpServletRequest request, HttpServletResponse response,
//                                 Object handler, Exception ex)throws Exception{
//        long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）
//        long endTime = System.nanoTime();
//        logger.debug("计时结束：{}  耗时：{}  URI: {}  最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
//                endTime, endTime- beginTime,
//                request.getRequestURI(), Runtime.getRuntime().maxMemory()/1024/1024, Runtime.getRuntime().totalMemory()/1024/1024, Runtime.getRuntime().freeMemory()/1024/1024,
//                (Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024);
//
//    }
//
//    private void returnJson(HttpServletResponse response, HttpServletRequest request, String code, String msg){
//        System.out.print("我来了我是returnJsonreturnJson");
//        PrintWriter writer=null;
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
//        String origin = request.getHeader("Origin");
//        response.setHeader("Access-Control-Allow-Origin", "*");//设置允许哪些域名应用进行ajax访问
//        response.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
//        response.setHeader("Access-Control-Expose-Headers", "Content-Type,Content-Disposition");
//        try {
//            writer=response.getWriter();
//            writer.print(JSONObject.toJSONString(new ResponseModel(code, msg)));
//        }catch (IOException e){
//            logger.error("拦截器输出流异常",e.getMessage());
//        }finally {
//            if(writer != null){
//                writer.close();
//            }
//        }
//    }
//}
