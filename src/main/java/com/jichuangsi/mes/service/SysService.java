package com.jichuangsi.mes.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.entity.*;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.mapper.IMesMapper;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.repository.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SysService {

    @Resource
    private DepartmentReposi deRepository;
    @Resource
    private MesPostRepository mesPostRepository;
    @Resource
    private TTeamRepository tteamPostRepository;
    @Resource
    private SRoleRepository sroleRepository;

    @Resource
    private UserRepository userRepository;
    @Resource
    private WorkshopRepository workshopRepository;
    @Resource
    private CustomerDetailRepository clientDetailRepository;
    @Resource
    private SCustomerRepository clientRepository;
    @Resource
    private SDictionarierRepository sdictionarierRepository;
    @Resource
    private SDictionarierdetailRepository sdictionarierdetailRepository;
    @Resource
    private complaintRepository clientcomplaintRepository;
    @Resource
    private RolePowerRepository rolePowerRepository;

    @Resource
    private LogService logService;


    @Resource
    private IMesMapper mesMapper;
    @Value("${file.uploadFolder}")
    private String uploadPath;
    @Value("${file.imagePath}")
    private String imagePath;
    @Value("${file.uri}")
    private String uri;

    /**
     * 系统管理-查询(员工管理，部门管理，职称管理，班组管理，角色管理)
     * @param
     * @throws PassportException
     */
    public PageInfo getAllSysByName(SelectModel smodel,HttpServletRequest request,InputStream inputStream)throws PassportException{
        int total=0;
        PageInfo page=new PageInfo();

        switch (smodel.getFindModelName()){
            case "staff"://员工管理-查询员工
                List<UserInfoModel> listUser = mesMapper.findAllUser(smodel.getFindName(),smodel.getFindIdOne(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());
                page.setList(listUser);
                page.setTotal(mesMapper.countByUser(smodel.getFindName(),smodel.getFindIdOne()));

                break;
            case "department"://部门管理-查询部门
                List<UserInfoModel> departmentInfos = mesMapper.findByDepartment(smodel.getFindName(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());
                total=deRepository.countById(smodel.getFindName());

                page.setList(departmentInfos);
                page.setTotal(total);
                break;
            case "mesPost"://职称管理-查询职称
                List<MesPost> mesPosts= mesPostRepository.findAllByPage(smodel.getFindName(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());
                total=mesPostRepository.countById(smodel.getFindName());

                page.setList(mesPosts);
                page.setTotal(total);
                break;
            case "tTeam"://班组管理-查询班组
                List<TTeamModel> listTeam = mesMapper.findByTteam(smodel.getFindName(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());

                total=tteamPostRepository.countById(smodel.getFindName());

                page.setList(listTeam);
                page.setTotal(total);
                break;
            case "sRole"://角色管理-查询角色
                List<SRole> srole= sroleRepository.findAllByPage(smodel.getFindName(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());
                total=sroleRepository.countById(smodel.getFindName());

                page.setList(srole);
                page.setTotal(total);
                break;
            default:

        }
        logService.addLog(1,"查询",request,inputStream);//新增一条日志
        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }

    /**
     * 员工管理-用户修改状态 （state或者delete_no状态）
     * @param
     * @param model
     * @throws PassportException
     */
    public void updateSysStateById(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) ||StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        String updatetype = model.getUpdateType();
        boolean updateTypeId = updatetype.equals("S") ? true :false;
        switch (model.getFindModelName()){
            case "staff"://员工管理-修改员工
                SStaff staff = userRepository.findByid(model.getUpdateID());

                if (StringUtils.isEmpty(staff)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}


                if(updateTypeId){//如果是修改state
                    staff.setState(staff.getState() == 0 ? 1 : 0);

                }else{
                    staff.setDeleteNo(staff.getDeleteNo() == 0 ? 1 :0);
                }
                userRepository.save(staff);

                break;
            case "department"://部门管理-修改部门
                Department department =deRepository.findByid(model.getUpdateID());
                if(StringUtils.isEmpty(department)){throw new PassportException(ResultCode.DATA_NOEXIST_MSG);}

                if(updateTypeId){//如果是修改state
                    department.setState(department.getState() == 0 ? 1 : 0);

                }else{
                    department.setDeleteNo(department.getDeleteNo() == 0 ? 1 :0);
                }
                deRepository.save(department);

                break;
            case "mesPost"://职称管理-修改职称
                MesPost mesPost = mesPostRepository.findByid(model.getUpdateID());

                if(StringUtils.isEmpty(mesPost)){throw new PassportException(ResultCode.DATA_NOEXIST_MSG);}

                if(updateTypeId){//如果是修改state
                    mesPost.setPostState(mesPost.getPostState()== 0 ? 1 : 0);

                }else{
                    mesPost.setDeleteNo(mesPost.getDeleteNo() == 0 ? 1 :0);
                }
                mesPostRepository.save(mesPost);

                break;
            case "tTeam"://班组管理-修改班组
                TTeam tTeam = tteamPostRepository.findByid(model.getUpdateID());
                if(StringUtils.isEmpty(tTeam)){throw new PassportException(ResultCode.DATA_NOEXIST_MSG);}

                if(updateTypeId){//如果是修改state
                    tTeam.setState(tTeam.getState() == 0 ? 1 : 0);

                }else{
                    tTeam.setDeleteNo(tTeam.getDeleteNo() == 0 ? 1 :0);
                }
                tteamPostRepository.save(tTeam);
                break;
            case "sRole"://角色管理-修改角色
                SRole sRole = sroleRepository.findByid(model.getUpdateID());

                if(StringUtils.isEmpty(sRole)){throw new PassportException(ResultCode.DATA_NOEXIST_MSG);}

                if(updateTypeId){//如果是修改state
                    sRole.setState(sRole.getState() == 0 ? 1 : 0);

                }else{
                    sRole.setDeleteNo(sRole.getDeleteNo() == 0 ? 1 :0);
                }
                sroleRepository.save(sRole);

                break;
            default:

        }

    }

    /**
     * 员工管理--新增/编辑页面获取的下拉框
     * @param
     * @throws PassportException
     */
    public JSONObject getStaffBasicInfo(SelectModel smodel)throws PassportException{
        JSONObject job = new JSONObject();
        //smodel.getFindIdOne 等于0的时候，查询全部下拉框。如果大于0的时候。只查询部门ID
        if(!StringUtils.isEmpty(smodel) && smodel.getFindIdOne() > 0){

            List<MapVo> de = mesMapper.findDeAllXiaLa();//部门
            job.put("bumen",de);//部门
            return job;
        }else{
            List<MapVo> mespost = mesMapper.findMespostAllXiaLa();;//职称
            List<MapVo> de = mesMapper.findDeAllXiaLa();//部门
            List<MapVo> js = mesMapper.findRoleAllXiaLa();//角色
            List<MapVo> ws = mesMapper.findworkshopAllXiaLa();//厂房

            Integer staffcount = userRepository.countByid()+1;
            String strnum = "YG000"+staffcount;

            job.put("StaffNum",strnum);//员工编号
            job.put("mespost",mespost);//职称
            job.put("bumen",de);//部门
            job.put("juese",js);//角色
            job.put("cangfang",ws);//厂房

            return job;
        }

    }

    /**
     * 部门管理/班组管理--下拉框
     * @param
     * @throws PassportException
     */
    public JSONObject getBasicInfo()throws PassportException{
        JSONObject job = new JSONObject();
        List<MapVo> liststaff = mesMapper.findStaffAllXiaLa();

        job.put("staffList",liststaff);//员工下拉框

        return job;
    }

    /**
     * 员工管理-根据员工ID查询单条信息
     * @param
     * @throws PassportException
     */
    public SStaff getInfoById(UserInfoForToken userInfo)throws PassportException{
        SStaff staff = userRepository.findByid(Integer.valueOf(userInfo.getUserId()));
        if(staff==null){
            throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);
        }

        return staff;
    }

    /**
     * 部门管理-新增部门
     * @param
     * @throws PassportException
     */
    public void addDepartment(Department adddepartment,HttpServletRequest request,InputStream inputStream)throws PassportException {
        if (StringUtil.isEmpty(adddepartment.getDepartmentName()) || StringUtils.isEmpty(adddepartment.getStaffId())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        adddepartment.setDeleteNo(0);
        deRepository.save(adddepartment);

        logService.addLog(1,"新增",request,inputStream);//新增一条日志
    }

    /**
     * 职称管理-新增职称
     * @param
     * @throws PassportException
     */
    public void addMesPost(MesPost mesPost,HttpServletRequest request,InputStream inputStream)throws PassportException {
        if (StringUtil.isEmpty(mesPost.getPostName()) || StringUtils.isEmpty(mesPost.getPostLevel())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        mesPost.setDeleteNo(0);
        mesPostRepository.save(mesPost);

        logService.addLog(1,"新增",request,inputStream);//新增一条日志
    }

    /**
     * 班组管理-新增班组
     * @param
     * @throws PassportException
     */
    public void addTeam(TTeam tteam)throws PassportException {
        if (StringUtil.isEmpty(tteam.getTeamName()) || StringUtils.isEmpty(tteam.getStaffId())|| StringUtils.isEmpty(tteam.getFrequency())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        tteam.setDeleteNo(0);
        tteamPostRepository.save(tteam);
    }

    /**
     * 角色管理-新增角色
     * @param
     * @throws PassportException
     */
    public void addRole(SRole sRole)throws PassportException {
        if (StringUtil.isEmpty(sRole.getRoleName())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        sRole.setDeleteNo(0);
        sroleRepository.save(sRole);
    }

    /**
     * 厂房管理- 本地上传厂房照片
     * @param
     * @param file
     * @return
     * @throws IOException
     */
    public String localUploadPic(MultipartFile file) throws IOException,PassportException {
        //获取文件名
        String fileName = file.getOriginalFilename();
        if(StringUtil.isEmpty(fileName)){
            fileName = "123";
        }
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        double fileSize = (double) file.getSize()/1024/1024;//MB
        if(fileSize>2){
            throw new PassportException("图片过大！");
        }

        fileName =UUID.randomUUID()+suffixName;//重新生成文件名
        File file1=new File(uploadPath+imagePath+fileName);
        if (!file1.exists()){
            //创建文件夹
            file1.getParentFile().mkdir();
        }
        file.transferTo(file1);
        String url = uri+fileName;
        return  url;
    }

    /**
     * 厂房管理-新增厂房
     * @param ws
     * @throws IOException
     * @throws PassportException
     */
    public void addWorkShop(Workshop ws) throws IOException,PassportException {
        if(StringUtil.isEmpty(ws.getWorkshopImg()) || StringUtil.isEmpty(ws.getWorkshopName())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);

        }
        workshopRepository.save(ws);
    }


//    =======================客户管理start===================================

    /**
     * 客户管理-新增/编辑(客户/供应商)
     * @param
     * @throws PassportException
     */
    public void saveCustomer(ClientModel client,HttpSession session)throws PassportException {
        SCustomer sc =client.getSclient();
        if (StringUtil.isEmpty(sc.getCustomerNumber()) || StringUtils.isEmpty(sc.getCustomerName())|| StringUtils.isEmpty(sc.getClientNo())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        if(!StringUtils.isEmpty(sc) && !StringUtils.isEmpty(sc.getId()) && sc.getId() > 0){//是修改还是新增。在于Id值，存在Id值则修改
            clientRepository.save(sc);

            if(!StringUtils.isEmpty(client.getCustomerDetails())){
                clientDetailRepository.saveAll(client.getCustomerDetails());
            }
        }else{
            Integer sessionstaffId =(Integer) session.getAttribute("userId");//获取session中的用户ID
            sc.setDeleteNo(0);
            sc.setStaffId(sessionstaffId == null ? 1 : sessionstaffId);
            clientRepository.save(sc);
            Integer cliid = sc.getId();
            if(sc.getClientNo() == 1){
                for (int i = 0; i < client.getCustomerDetails().size(); i++) {
                    CustomerDetail cd = client.getCustomerDetails().get(i);
                    cd.setCustomerId(cliid);
                    cd.setDeleteNo(0);
                }
                clientDetailRepository.saveAll(client.getCustomerDetails());
            }
        }
    }

    /**
     * 客户管理-修改客户/供应商状态 （state或者delete_no状态）
     * @param
     * @param model
     * @throws PassportException
     */
    public void updateCustomerById(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) ||StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        String updatetype = model.getUpdateType();
        boolean updateTypeId = updatetype.equals("S") ? true :false;
        SCustomer sCustomer = clientRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(sCustomer)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}


        if(updateTypeId){//如果是修改state
            sCustomer.setState(sCustomer.getState() == 0 ? 1 : 0);

        }else{
            sCustomer.setDeleteNo(sCustomer.getDeleteNo() == 0 ? 1 :0);
        }
        clientRepository.save(sCustomer);

    }

    /**
     * 客户管理-查询客户/供应商
     * @param
     * @throws PassportException
     */
    public PageInfo findCustomer(Integer clientNo,SelectModel smodel)throws PassportException {
        PageInfo page=new PageInfo();

        List<SCustomerModel> listclient =mesMapper.findAllByCustomer(clientNo,smodel.getFindName(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize()); //clientRepository.findAllByPage(clientNo,smodel.getFindName(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());
        int total=clientRepository.countById(clientNo,smodel.getFindName());

        page.setList(listclient);
        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        page.setTotal(total);
        return page;

    }

    /**
     * 根据客户id查询客户信息
     * @param
     * @throws PassportException
     */
    public JSONObject getClientInfoById(Integer clientId)throws PassportException{
        JSONObject object = new JSONObject();
        SCustomer client = clientRepository.findByid(clientId);
        if(client==null){
            throw new PassportException(ResultCode.EXPREES_NOEXIST_CLIENT);
        }
        object.put("SCustomer",client);
        if(!StringUtils.isEmpty(client.getClientNo()) &&  client.getClientNo() == 1){
            List<CustomerDetail> listdetail = clientDetailRepository.findAllByCustomerId(clientId);
            object.put("listdetail",listdetail);
        }
        return object;
    }

    /**
     * 客户投诉管理--客户/供应商下拉框
     * @param
     * @throws PassportException
     */
    public JSONObject findClientAllXiaLa(Integer clientNo)throws PassportException{
        JSONObject job = new JSONObject();
        List<MapVo> listClient = mesMapper.findClientAllXiaLa(clientNo);

        job.put("listClient",listClient);//客户/供应商下拉框

        return job;
    }

    /**
     * 客户投诉管理-新增/编辑
     * @param
     * @throws PassportException
     */
    public void saveComplaint(complaint clienttousu,HttpSession session)throws PassportException {
        if (StringUtil.isEmpty(clienttousu.getComplaintContent()) || StringUtils.isEmpty(clienttousu.getComplaintTitle())|| clienttousu.getCustomerId() <=0 ){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        //如果存在Id且Id大于0 则说明是修改。否则就是新增
        if(StringUtils.isEmpty(clienttousu.getId())){
            Integer sessionstaffId =(Integer) session.getAttribute("userId");//获取session中的用户ID
            clienttousu.setDeleteNo(0);
            clienttousu.setStaff_id(sessionstaffId == null ? 1 : sessionstaffId);

            clientcomplaintRepository.save(clienttousu);
        }else{
            complaint com = clientcomplaintRepository.findByid(clienttousu.getId());
            com.setCustomerId(clienttousu.getCustomerId());
            com.setComplaintContent(clienttousu.getComplaintContent());
            com.setComplaintTitle(clienttousu.getComplaintTitle());
            clientcomplaintRepository.save(com);
        }
    }

    /**
     * 客户投诉管理-修改状态 （state或者delete_no状态）
     * @param
     * @param model
     * @throws PassportException
     */
    public void updateComplaintById(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) ||StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        complaint complaint = clientcomplaintRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(complaint)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}
        complaint.setDeleteNo(complaint.getDeleteNo() == 0 ? 1 :0);
        clientcomplaintRepository.save(complaint);

    }

    /**
     * 客户投诉管理-查询
     * @param
     * @throws PassportException
     */
    public PageInfo findComplaint(SelectModel smodel)throws PassportException {
        int total=0;
        PageInfo page=new PageInfo();

        //如果findId不为空。证明查询的是单条。//否则就是查询全部
        List<ComplaintModel> listComplaint = mesMapper.findUserComplaint(smodel.getFindName(),smodel.getFindById(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());
        page.setList(listComplaint);

        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        page.setTotal(mesMapper.countByComplaint(smodel.getFindName(),smodel.getFindIdOne(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize()));
        return page;
    }

    /**
     * 客户投诉管理-根据Id查询单条数据
     * @param
     * @throws PassportException
     */
    public ComplaintModel findUserComplaintById(SelectModel smodel)throws PassportException {
        if(StringUtils.isEmpty(smodel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        ComplaintModel model = mesMapper.findUserComplaintById(smodel.getFindById());

        return model;
    }



//    =======================客户管理end===================================

    /**
     * 字典管理-查询
     * @param
     * @throws PassportException
     */
    public JSONObject findDictionary(SelectModel smodel)throws PassportException {
        JSONObject jsonObject = new JSONObject();

        List<SDictionarier> list = sdictionarierRepository.findByDictFIDAndDeleteNoAndState(0,0,0);
        jsonObject.put("LData",list.size() == 0? "":list) ;//左边数据
        jsonObject.put("RData",list.size() == 0 ? "": mesMapper.findDictionaryByFId(smodel.getFindName(),list.get(0).getId()));//右边数据

        return jsonObject;
    }
    /**
     * 字典管理-根据父类id查询子类
     * @param
     * @throws PassportException
     */
    public JSONObject findDictionaryByFid(SelectModel smodel)throws PassportException {
        JSONObject jsonObject = new JSONObject();

        if(StringUtils.isEmpty(smodel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }
        jsonObject.put("RData",mesMapper.findDictionaryByFId(smodel.getFindName(),smodel.getFindById()));//右边数据

        return jsonObject;
    }


    /**
     * 字典管理-新增字典明细
     * @param
     * @throws PassportException
     */
    public void saveDictionary(SDictionarier sDictionarier,HttpSession session)throws PassportException {
        if (StringUtil.isEmpty(sDictionarier.getName()) ){//|| StringUtils.isEmpty(session.getAttribute("userId"))
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        if(sdictionarierRepository.countByNameAndDictFID(sDictionarier.getName(),sDictionarier.getDictFID()) > 0 ){
            throw new PassportException(ResultCode.DICTIONARY_ISEXIST_MSG);
        }
        sDictionarier.setDeleteNo(0);
        sDictionarier.setCreateTime(new Date());
        sDictionarier.setStaffId(1);//暂定
        sdictionarierRepository.save(sDictionarier);

    }

    /**
     * 设备管理-根据Id修改设备状态 （state ‘S’或deleteno 'D'）
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void  updateStateById(UpdateModel updateModel)throws PassportException{
        SDictionarier sDictionarier = sdictionarierRepository.findByid(updateModel.getUpdateID());
        if(StringUtils.isEmpty(sDictionarier)){
            throw new PassportException(ResultCode.DATA_NOEXIST_MSG);
        }
        if(updateModel.getUpdateType().equals("S")){
            sDictionarier.setState(sDictionarier.getState() == 0?1:0);
        }else if(updateModel.getUpdateType().equals("D")){
            sDictionarier.setDeleteNo(sDictionarier.getDeleteNo() == 0?1:0);
        }
        sdictionarierRepository.save(sDictionarier);
    }


}
