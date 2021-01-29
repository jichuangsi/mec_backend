package com.jichuangsi.mes.service;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jichuangsi.mes.constant.ResultCode;
import com.jichuangsi.mes.entity.*;
import com.jichuangsi.mes.exception.PassportException;
import com.jichuangsi.mes.mapper.IMesMapper;
import com.jichuangsi.mes.mapper.INewProductionMapper;
import com.jichuangsi.mes.mapper.IProductionMapper;
import com.jichuangsi.mes.model.PackingVo;
import com.jichuangsi.mes.model.SelectModel;
import com.jichuangsi.mes.repository.InventoryStatusRepository;
import com.jichuangsi.mes.repository.TPackingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackingService {

    @Resource
    private IMesMapper iMesMapper;
    @Resource
    private IProductionMapper iProductionMapper;
    @Resource
    private INewProductionMapper iNewProductionMapper;
    @Resource
    private TPackingRepository tPackingRepository;
    @Resource
    private InventoryStatusRepository inventoryStatusRepository;
    /**
     * 包装管理- 保存操作-新增/编辑
     * @param tPacking
     * @throws PassportException
     */
    @Transactional(rollbackFor = Exception.class)//回滚标志
    public  void savePicking(TPacking tPacking)throws PassportException {

        if(StringUtils.isEmpty(tPacking.getStock()) || StringUtils.isEmpty(tPacking.getCartonsNumber())|| StringUtils.isEmpty(tPacking.getProductids())|| StringUtils.isEmpty(tPacking.getProductTime())|| StringUtils.isEmpty(tPacking.getQualityTime())){

            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        String strNumber = "100000"+(tPackingRepository.count()+1);

//        库存id转 List<Integer>
        List<Integer> listInt = Arrays.stream(tPacking.getProductids().split(","))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        tPacking.setPPPId(inventoryStatusRepository.findByid(listInt.get(0)).getPppId());//pppid
        tPacking.setPackingName(strNumber);//包装编号
        tPacking.setCreateTime(new Date());

        tPackingRepository.save(tPacking);

        iMesMapper.updateinventoryStatusPickingNumberByIds(listInt,strNumber);//通过ids把包装编号存进去

    }


    /**
     * 包装管理-查询
     * @param
     * @throws PassportException
     */
    public PageInfo getAllPicking(SelectModel smodel)throws PassportException{
        PageInfo page=new PageInfo();


        List<PackingVo> packingVoList = iNewProductionMapper.findAllPicking(smodel.getFindName(),(smodel.getPageNum()-1)*smodel.getPageSize(),smodel.getPageSize());

        for (PackingVo pickvo: packingVoList) {
            List<Integer> listInt = Arrays.stream(pickvo.getProductids().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

            pickvo.setProductModel(inventoryStatusRepository.findByid(listInt.get(0)).getStockModel());
        }

        page.setList(packingVoList);
        page.setTotal(iNewProductionMapper.countByAllPicking(smodel.getFindName()));

        page.setPageSize(smodel.getPageSize());
        page.setPageNum(smodel.getPageNum());

        return page;
    }


    /**
     * 包装管理-根据id查询详情
     * @param
     * @throws PassportException
     */
    public JSONObject getPickingById(SelectModel smodel)throws PassportException{
        JSONObject jsonObject=new JSONObject();

        if(StringUtils.isEmpty(smodel.getFindById())){
            throw new PassportException(ResultCode.PARAM_MISS_MSG);
        }

        TPacking tPacking = tPackingRepository.findByid(smodel.getFindById());
        jsonObject.put("pickingInfo",tPacking);

        //库存id转 List<Integer>
        List<Integer> listInt = Arrays.stream(tPacking.getProductids().split(","))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        jsonObject.put("pickingDetail",iNewProductionMapper.findDetailsByPackingId(tPacking.getPPPId()%10,listInt));

        return jsonObject;
    }


}
