package com.jichuangsi.mes.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.jichuangsi.mes.config.Md5Util;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.controller.FileController;
import com.jichuangsi.mes.entity.FileTable;
import com.jichuangsi.mes.entity.SNotice;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.mapper.IMesMapper;
import com.jichuangsi.mes.model.*;
import com.jichuangsi.mes.repository.FileTableRepository;
import com.jichuangsi.mes.repository.SNoticeRepository;
import com.jichuangsi.mes.utill.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class FileService {


    @Resource
    private IMesMapper mesMapper;


    @Resource
    private FileTableRepository fileTableRepository;
    @Resource
    private SNoticeRepository sNoticeRepository;

    @Value("${file.uploadFolder}")
    private String uploadPath;
    @Value("${file.imagePath}")
    private String imagePath;
    @Value("${file.uri}")
    private String uri;

    private static final Logger log = LoggerFactory.getLogger(FileController.class);
    /**
     * 文件管理-上传文件
     * @param
     * @throws PassportException
     */
    public JSONObject upload(MultipartFile file,SelectModel selectModel)throws IOException,PassportException {
        JSONObject jsonObject = new JSONObject();
        try {
            if (file.isEmpty()) {
                throw new PassportException(ResultCode.FILE_IS_NULL);
            }
            // 获取大小
            long size = file.getSize();
            log.info("文件大小： " + size);
            // 判断上传文件大小
            if (!FileUtils.checkFileSize(file.getSize(),100,"M")) {
                log.error("上传文件规定小于100MB");
                throw new PassportException(ResultCode.PWD_LIMIT);
            }
            // 获取文件名
            String fileName = UUID.randomUUID()+file.getOriginalFilename();
            log.info("上传的文件名为：" + fileName);
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            log.info("文件的后缀名为：" + suffixName);
            // 设置文件存储路径
            if(selectModel.getFindModelName().equals("FILE")){
                // 获取文件名
                fileName = "file"+fileName;
            }else if(selectModel.getFindModelName().equals("NOTICE")){
                // 获取文件名
                fileName = "notice"+fileName;
            }

            File dest = new File(uploadPath+imagePath+fileName);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入

            jsonObject.put("path",uri+fileName);
            jsonObject.put("fileName",fileName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 下载
     *
     * @throws IOException
     */
    public String downloadFile(SelectModel selectModel) throws PassportException {
        // 设置文件存储路径
        String path = "";
        if(selectModel.getFindModelName().equals("FILE")){
            FileTable fileTable = fileTableRepository.findByid(selectModel.getFindById());

            if (StringUtils.isEmpty(fileTable)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

            if(!StringUtils.isEmpty(fileTable.getFilePassword())){//判断一下之前有没有存进去密码。如果有则需要先输入密码才能回填
                if(!StringUtils.isEmpty(selectModel.getFindName()) &&  !Md5Util.encodeByMd5(selectModel.getFindName()).equals(fileTable.getFilePassword())){
                    throw new PassportException(ResultCode.PWD_NOTEXIST_MSG);
                }
            }

            path = fileTable.getFileRoute();
        }else if(selectModel.getFindModelName().equals("NOTICE")){
            SNotice sNotice = sNoticeRepository.findByid(selectModel.getFindById());
            path = sNotice.getNoticeRoute();
        }

        return  path;
    }

    /**
     * 下载
     *
     * @param response
     * @throws IOException
     */
//    public OutputStream downloadFile(HttpServletResponse response,SelectModel selectModel) throws IOException {
//        // 设置文件存储路径
//        String path = "";
//        String fileName  ="";
//        if(selectModel.getFindModelName().equals("FILE")){
//            path = "D:/file/";
//            FileTable fileTable = fileTableRepository.findByid(selectModel.getFindById());
//            fileName = fileTable.getFileName();
//        }else if(selectModel.getFindModelName().equals("NOTICE")){
//            path = "D:/notice/";
//            SNotice sNotice = sNoticeRepository.findByid(selectModel.getFindById());
//            fileName = sNotice.getNoticeRoute();
//        }
//        byte[] buffer = new byte[1024];
//        FileInputStream fis = null;
//        BufferedInputStream bis = null;
//        try {
//            File tempFile =new File( fileName.trim());
//
//            File file = new File(path, tempFile.getName());
//            response.setContentType("application/x-download");
//            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
//            fis = new FileInputStream(file);
//            bis = new BufferedInputStream(fis);
//            OutputStream os = response.getOutputStream();
//            int i = bis.read(buffer);
//            while (i != -1) {
//                os.write(buffer, 0, i);
//                i = bis.read(buffer);
//            }
//        }catch(FileNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("The file not found!");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally{
//            if (bis != null) {
//                try {
//                    bis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (fis != null) {
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return  null;
//    }


    /**
     * 文件管理-查询
     * @param
     * @throws PassportException
     */
    public PageInfo getAllFile(SelectModel smodel)throws PassportException{
        int total=0;
        PageInfo page=new PageInfo();

        List<fileTableVo> listfile = mesMapper.findAllFile(smodel.getFindName(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());
        for (fileTableVo modes: listfile) {
            modes.setIsEncryption(modes.getFilePassword() == null ? 0:1);
            modes.setIsEncryptionstr(modes.getFilePassword() == null ? "未加密":"已加密");
        }
        page.setList(listfile);
        page.setTotal(mesMapper.countByFile(smodel.getFindName()));

        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }

    /**
     * 文件管理- 新增/编辑
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void saveFile(UserInfoForToken userInfoForToken,FileTable fileTable)throws PassportException {
        if (StringUtil.isEmpty(fileTable.getFileName())||StringUtil.isEmpty(fileTable.getFileRoute())||StringUtil.isEmpty(fileTable.getFilePassword())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        if(fileTable.getFilePassword().length() < 5){
            throw new PassportException(ResultCode.PWD_LIMIT);
        }

        if(StringUtils.isEmpty(fileTable.getId()) || fileTable.getId() == 0){
            long t4=System.currentTimeMillis();
            fileTable.setCreateTime(t4);
        }

        fileTable.setStaffId(Integer.valueOf(userInfoForToken.getUserId()));
        fileTable.setFilePassword(Md5Util.encodeByMd5(fileTable.getFilePassword()));
        fileTable.setDeleteNo(0);
        fileTableRepository.save(fileTable);
    }


    /**
     * 文件管理-根据Id查询文件信息
     *
     * 判断密码是否正确。如果正确才根据Id查询数据(超级管理员可以不用输入密码直接修改)
     * @param
     * @throws PassportException
     */
    public JSONObject getFileById(SelectModel smodel, HttpSession session)throws PassportException{
        JSONObject jsonObject=new JSONObject();

//        if((Integer)session.getAttribute("userId") != 1){
//
//        }
        if(StringUtils.isEmpty(smodel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        FileTable fileTable = fileTableRepository.findByid(smodel.getFindById());

        if (StringUtils.isEmpty(fileTable)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        if(!StringUtils.isEmpty(fileTable.getFilePassword())){//判断一下之前有没有存进去密码。如果有则需要先输入密码才能回填
            if(!Md5Util.encodeByMd5(smodel.getFindName()).equals(fileTable.getFilePassword())){
                throw new PassportException(ResultCode.PWD_NOTEXIST_MSG);
            }
        }
        jsonObject.put("fileTable",fileTable);
        return jsonObject;
    }

    /**
     * 文件管理-修改状态 （delete_no状态）
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateFileByid(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) ||StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        FileTable fileTable = fileTableRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(fileTable)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        fileTable.setDeleteNo(fileTable.getDeleteNo() == 0 ? 1 :0);
        fileTableRepository.save(fileTable);

    }

    /**
     * 文件管理-查询
     * @param
     * @throws PassportException
     */
    public PageInfo getAllNotice(SelectModel smodel)throws PassportException{
        int total=0;
        PageInfo page=new PageInfo();

        List<NoticeVo> list = mesMapper.findAllNotice(smodel.getFindName(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());

        page.setList(list);
        page.setTotal(mesMapper.countByNotice(smodel.getFindName()));

        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());
        return page;
    }

    /**
     * 系统公告- 新增/编辑
     * @param
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void saveSysAnnouncement(UserInfoForToken userInfoForToken, SNotice sNotice)throws PassportException {
        if (StringUtil.isEmpty(sNotice.getNoticeName())||StringUtil.isEmpty(sNotice.getNoticeRoute())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        if(StringUtils.isEmpty(sNotice.getId()) || sNotice.getId() == 0){
            long t4=System.currentTimeMillis();
            sNotice.setCreateTime(t4);
        }

        sNotice.setStaffId(Integer.valueOf(userInfoForToken.getUserId()));
        sNotice.setIsshow(0);
        sNotice.setDeleteNo(0);
        sNoticeRepository.save(sNotice);
    }


    /**
     * 系统公告-根据Id查询系统公告
     * @param
     * @throws PassportException
     */
    public JSONObject getNoticeById(SelectModel smodel)throws PassportException{
        JSONObject jsonObject=new JSONObject();

        if(StringUtils.isEmpty(smodel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        SNotice sNotice = sNoticeRepository.findByid(smodel.getFindById());

        if (StringUtils.isEmpty(sNotice)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        jsonObject.put("sNotice",sNotice);
        return jsonObject;
    }

    /**
     * 系统公告-修改状态(isshow or delete_no)
     * @param
     * @param model
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public void updateNoticeByid(UpdateModel model)throws PassportException {
        if(StringUtils.isEmpty(model.getUpdateID()) ||StringUtils.isEmpty(model.getUpdateType())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        SNotice sNotice = sNoticeRepository.findByid(model.getUpdateID());

        if (StringUtils.isEmpty(sNotice)){ throw new PassportException(ResultCode.ACCOUNT_NOTEXIST_MSG);}

        if(model.getUpdateType().equals("D")){

            sNotice.setDeleteNo(sNotice.getDeleteNo() == 0 ? 1 :0);

        }else if(model.getUpdateType().equals("S")){
            sNotice.setIsshow(sNotice.getIsshow() == 0 ? 1 :0);
        }
        sNoticeRepository.save(sNotice);

    }

}
