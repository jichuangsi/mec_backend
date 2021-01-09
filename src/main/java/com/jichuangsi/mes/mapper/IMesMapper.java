package com.jichuangsi.mes.mapper;

import com.jichuangsi.mes.entity.Equipment;
import com.jichuangsi.mes.entity.EquipmentItems;
import com.jichuangsi.mes.entity.GXScheduling;
import com.jichuangsi.mes.entity.Matters;
import com.jichuangsi.mes.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

@Mapper
public interface IMesMapper {

    @Select(value = "<script>SELECT sf.id as id, sf.staff_num as staffNum, sf.staff_name as staffName," +
            "sf.workshop_id as workshopId,ws.workshop_name as workshopName," +
            "sf.remark as remark,sf.state as state," +
            "de.department_name AS departmentName,mp.post_name as postName,\n" +
            "(SELECT GROUP_CONCAT(s_role.role_name)  FROM s_role INNER JOIN s_staffrole onesf ON s_role.id = onesf.role_id where onesf.staff_id = sf.id)as roleName\n" +
            "FROM s_staff sf\n" +
            "INNER JOIN department de ON sf.department_id = de.id\n" +
            "INNER JOIN mes_post mp on sf.post_id = mp.id\n" +
            "INNER JOIN workshop ws on sf.workshop_id = ws.id\n" +
            "WHERE sf.delete_no = 0" +
            "<if test='name != null'>AND sf.`staff_name` LIKE CONCAT('%', #{name},'%')</if>"+
            "<if test='deId != null'>AND sf.department_id=#{deId}</if>" +
            "ORDER BY sf.id DESC\n " +
            "LIMIT #{pageNum},#{pageSize}</script>")
    List<UserInfoModel> findAllUser(@Param("name")String name,@Param("deId")Integer deId,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    @Select(value = "<script>SELECT count(1)" +
            "FROM s_staff sf\n" +
            "INNER JOIN department de ON sf.department_id = de.id\n" +
            "INNER JOIN mes_post mp on sf.post_id = mp.id\n" +
            "INNER JOIN workshop ws on sf.workshop_id = ws.id\n" +
            "WHERE sf.delete_no = 0" +
            "<if test='name != null'>AND sf.`staff_name` LIKE CONCAT('%', #{name},'%')</if>"+
            "<if test='deId != null'>AND sf.department_id=#{deId}</if>" +
            "</script>")
    Integer countByUser(@Param("name")String name,@Param("deId")Integer deId);

    @Select(value = "<script>SELECT sf.id as id, sf.staff_num as staffNum, sf.staff_name as staffName,\n" +
            "sf.staff_age as staffAge,sf.post_id as postId,\n" +
            "sf.gender as gender,sf.phone as phone,sf.e_mail as eMail,sf.idcard as idcard,\n" +
            "sf.staff_address as staffAddress,sf.department_id as departmentId,sf.workshop_id as workshopId,\n" +
            "sf.state as state,\n" +
            " (SELECT GROUP_CONCAT(s_role.id) FROM s_role \n" +
            "INNER JOIN s_staffrole onesf ON s_role.id = onesf.role_id \n" +
            "where onesf.staff_id = sf.id)as roleId \n" +
            "FROM s_staff sf \n" +
            "INNER JOIN department de ON sf.department_id = de.id \n" +
            "INNER JOIN mes_post mp on sf.post_id = mp.id \n" +
            "INNER JOIN workshop ws on sf.workshop_id = ws.id \n" +
            "WHERE sf.delete_no = 0 \n" +
            "AND sf.id = #{deId}</script>")
    UserInfoModel findUserById(@Param("deId")Integer deId);

//    查询职称下拉框
    @Select(value = "<script>SELECT id as MapKey,post_name as MapValue FROM mes_post WHERE delete_no = 0 and post_state = 0</script>")
    List<MapVo> findMespostAllXiaLa();

//    查询部门下拉框
    @Select(value = "<script>SELECT id as MapKey,department_name as MapValue FROM department WHERE delete_no = 0 and state = 0</script>")
    List<MapVo> findDeAllXiaLa();

//    查询厂房下拉框
    @Select(value = "<script>SELECT id as MapKey,workshop_name as MapValue FROM workshop</script>")
    List<MapVo> findworkshopAllXiaLa();

//    查询角色下拉框
    @Select(value = "<script>SELECT id as MapKey,role_name as MapValue FROM s_role WHERE delete_no = 0 and state = 0</script>")
    List<MapVo> findRoleAllXiaLa();

    //    查询用户下拉框
    @Select(value = "<script>SELECT sf.id as MapKey,sf.staff_name as MapValue,sf.staff_num as MapValue2 ,mp.post_name as Mapliandong FROM s_staff sf INNER JOIN mes_post mp ON mp.id = sf.post_id WHERE sf.delete_no = 0 and sf.state = 0</script>")
    List<MapVo> findStaffAllXiaLa();

//    查询客户/供应商下拉框
    @Select(value = "<script>SELECT id as MapKey,CONCAT_WS(' --  ',customer_name,customer_number) as MapValue FROM s_customer " +
            "WHERE delete_no = 0 and state = 0 and client_no = #{clientNo} </script>")
    List<MapVo> findClientAllXiaLa(Integer clientNo);

//    查询仓库下拉框
    @Select(value = "<script>SELECT id as MapKey,warehouse_number as MapValue,warehousen_name as MapValue2  FROM t_warehouse WHERE delete_no = 0 and state = 0 </script>")
    List<MapVo> findAllWarehouseByXiaLa();

    //    查询线轴下拉框
    @Select(value = "<script>SELECT id as MapKey,bobbin_number as MapValue,bobbin_name as MapValue2\n" +
            "FROM t_bobbin WHERE delete_no = 0 and state = 0 </script>")
    List<MapVo> findAllBobbinByXiaLa();

    //    查询设备下拉框
    @Select(value = "<script>SELECT id as MapKey,equipment_number as MapValue,equipment_name as MapValue2  FROM t_equipment WHERE delete_no = 0 and state = 0 </script>")
    List<MapVo> findAllEquipmentByXiaLa();

    //    查询检查报告模板下拉框
    @Select(value = "<script>SELECT id as MapKey,number as MapValue,`name` as MapValue2 FROM templates WHERE type = #{type} AND delete_no = 0 AND closed = 0 </script>")
    List<MapVo> findAllTemplatesXiaLa(@Param("type")Integer type);

    @Select(value = "<script>SELECT cm.id as id,cm.delete_no as deleteNo, cm.complaint_content as complaintContent,cm.complaint_title as complaintTitle,cm.create_time as createTime,\n" +
            "cm.customer_id as customerId,cm.remark as remark,cm.staff_id as staffId,sf.staff_name as staffName,sc.customer_name as customerName\n" +
            "FROM complaint cm\n" +
            "LEFT JOIN s_staff sf ON cm.staff_id = sf.id\n" +
            "LEFT JOIN s_customer sc ON cm.customer_id = sc.id\n" +
            "WHERE cm.delete_no = 0\n" +
            "<if test='name != null' >AND cm.complaint_content LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='cmid != null and cmid > 0'>AND cm.id = #{cmid}</if>\n" +
            "ORDER BY cm.id DESC\n"+
            "<if test='pageNum != null and pageSize != null || pageNum != 0 and pageSize != 0'>LIMIT #{pageNum},#{pageSize}</if> </script>")
    List<ComplaintModel> findUserComplaint(@Param("name")String name,@Param("cmid")Integer cmid,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    @Select(value = "<script>SELECT cm.id as id,cm.delete_no as deleteNo, cm.complaint_content as complaintContent,cm.complaint_title as complaintTitle,cm.create_time as createTime,\n" +
            "cm.customer_id as customerId,cm.remark as remark,cm.staff_id as staffId,sf.staff_name as staffName,sc.customer_name as customerName\n" +
            "FROM complaint cm\n" +
            "LEFT JOIN s_staff sf ON cm.staff_id = sf.id\n" +
            "LEFT JOIN s_customer sc ON cm.customer_id = sc.id\n" +
            "WHERE cm.delete_no = 0  AND cm.id = #{cmid}" +
            "</script>")
    ComplaintModel findUserComplaintById(@Param("cmid")Integer cmid);

    @Select(value = "<script>SELECT count(1)" +
            "FROM complaint cm\n" +
            "LEFT JOIN s_staff sf ON cm.staff_id = sf.id\n" +
            "LEFT JOIN s_customer sc ON cm.customer_id = sc.id\n" +
            "WHERE cm.delete_no = 0" +
            "<if test='name != null'>AND cm.complaint_content LIKE CONCAT('%', #{name},'%')</if>"+
            "<if test='cmid != null and cmid > 0'>AND cm.id = #{cmid}</if>"+
            "</script>")
    Integer countByComplaint(@Param("name")String name,@Param("cmid")Integer cmid,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    //根据字典父id查询明细
    @Select(value = "<script>SELECT sd.id as id,sd.create_time as createTime," +
            "sd.`name` as dictname,sd.state as state,sd.delete_no as deleteNo,\n" +
            "sf.staff_name as staffName,sd1.`name` as dictFname\n" +
            "FROM s_dictionarier sd\n" +
            "LEFT JOIN s_staff sf ON sf.id = sd.staff_id \n" +
            "INNER JOIN s_dictionarier sd1 ON sd1.id = sd.dictfid\n" +
            "WHERE sd.delete_no = 0 AND sd.dictfid = #{deId}\n" +
            "<if test='name != null'>AND sd.name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "ORDER BY sd.id DESC\n" +
            "</script>")
    List<DictionaryModel> findDictionaryByFId(@Param("name")String name, @Param("deId")Integer deId);

    //部门管理-查询
    @Select(value = "<script>SELECT de.id as id,de.department_name as departmentName,\n" +
            "sf.staff_name as staffName,\n" +
            "de.department_remark as departmentRemark,de.remark as remark,\n" +
            "de.state as state,de.delete_no as deleteNo\n" +
            "FROM department de\n" +
            "INNER JOIN s_staff sf ON sf.id = de.staff_id\n" +
            "WHERE de.delete_no = 0\n" +
            "<if test='name != null'>AND de.department_name LIKE CONCAT('%', #{name},'%')</if>"+
            "<if test='pageNum != null and pageSize != null'>LIMIT #{pageNum},#{pageSize}</if></script>")
    List<UserInfoModel> findByDepartment(@Param("name")String name,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    //班组管理-查询
    @Select(value = "<script>SELECT tt.id as id,tt.team_name as teamName,\n" +
            "tt.remark as remark,tt.staff_id as  staffId,\n" +
            "sf.staff_name as staffName,tt.frequency as frequency,\n" +
            "tt.state as state,tt.delete_no as deleteNo\n" +
            "FROM t_team tt\n" +
            "INNER JOIN s_staff sf ON sf.id = tt.staff_id\n" +
            "WHERE tt.delete_no = 0\n" +
            "<if test='name != null'>AND tt.team_name LIKE CONCAT('%', #{name},'%')</if>"+
            "<if test='pageNum != 0 and pageSize != 0'>LIMIT #{pageNum},#{pageSize}</if></script>")
    List<TTeamModel> findByTteam(@Param("name")String name,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

//    查询客户/供应商
    @Select(value = "<script>SELECT sc.id as id, sc.customer_name as customerName,\n" +
            "sc.customer_number as customerNumber,\n" +
            "sc.contacts_man as contactsMan,\n" +
            "sc.contacts_phone as contactsPhone,\n" +
            "sf.staff_name as staffName,\n" +
            "sc.remark as remark,\n" +
            "sc.state as state,\n" +
            "sc.delete_no as deleteNo\n" +
            " FROM s_customer sc\n" +
            "INNER JOIN s_staff sf ON sf.id = sc.staff_id\n" +
            "WHERE sc.delete_no = 0 and sc.client_no = #{clientNo} \n" +
            "<if test='deName != null'>AND sc.customer_number LIKE CONCAT('%', #{deName},'%')</if> \n" +
            "ORDER BY sc.id DESC\n"+
            "LIMIT #{pageNum},#{pageSize} </script>")
    List<SCustomerModel> findAllByCustomer(@Param("clientNo")Integer clientNo, @Param("deName")String deName, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    //查询产品
    @Select(value = "<script>SELECT tp.id as id,tp.product_name as productName,\n" +
            "tp.product_number as productNumber,\n" +
            "tp.product_model as productModel,\n" +
            "sd.`name` as productLine,\n" +
            "tp.product_remark as productRemark,\n" +
            "tp.state as state,\n" +
            "tp.delete_no as deleteNo\n" +
            "FROM t_product tp\n" +
            "LEFT JOIN s_dictionarier sd ON tp.product_line_id = sd.id\n" +
            "WHERE tp.delete_no = 0"+
            "<if test='name != null'>AND tp.product_number LIKE CONCAT('%', #{name},'%')</if>"+
            "<if test='deId != null'>AND tp.product_line_id=#{deId}</if>" +
            "<if test='pageNum != null and pageSize != null'>LIMIT #{pageNum},#{pageSize}</if></script>")
    List<TProductModel> findAllProduct(@Param("name")String name,@Param("deId")Integer deId,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    //根据Id查询单条产品
    @Select(value = "<script>SELECT tp.id as id,tp.product_name as productName,\n" +
            "tp.product_number as productNumber,\n" +
            "tp.product_model as productModel,\n" +
            "sd.`name` as productLine,\n" +
            "tp.product_remark as productRemark,\n" +
            "tp.state as state,\n" +
            "tp.delete_no as deleteNo\n" +
            "FROM t_product tp\n" +
            "LEFT JOIN s_dictionarier sd ON tp.product_line_id = sd.id\n" +
            "WHERE tp.delete_no = 0 and tp.id = #{deId}"+
            "</script>")
    TProductModel findAllProductById(@Param("deId")Integer deId);

    //根据Id查询工序损耗比
    @Select(value = "<script>SELECT gx.id as id,gx.delete_no as deleteNo,\n" +
            "gx.gxid as GXid,sd.`name` as Name,gx.product_id as productId,\n" +
            "gx.cpstart as cpstart,gx.cpend as cpend,\n" +
            "gx.fpstart as fpstart,gx.fpend as fpend,\n" +
            "gx.lossstart as lossstart,gx.lossend as lossend\n" +
            "FROM gx_lossbi  gx\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = gx.gxid\n" +
            "WHERE gx.delete_no = 0 AND gx.product_id =  #{deId} "+
            "</script>")
    List<GXLossBiVo> findAllGXLossBiVoById(@Param("deId")Integer deId);

    //根据产品Id查询原料配比表
    @Select(value = "<script>SELECT raw.id as id,\n" +
            "raw.stock_id as GXid,sd.`name` as Name,ratiostart as ratiostart,ratioend as ratioend,\n" +
//            "(case  ratiostart when 0.00000000 then  &lt; else ratiostart end),\n" +
//            "(case  ratioend when 0.00000000 then  &gt; else ratioend end),\n" +
            "raw.delete_no as deleteNo\n" +
            "FROM rawmaterial_ratio raw\n" +
            "INNER JOIN s_dictionarier sd ON sd.id = raw.stock_id \n" +
            "WHERE raw.delete_no = 0 AND raw.product_id =  #{deId} "+
            "</script>")
    List<GXLossBiVo> findAllRawMaterialRatioById(@Param("deId")Integer deId);

    //查询产品统计个数
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM t_product tp\n" +
            "LEFT JOIN s_dictionarier sd ON tp.product_line_id = sd.id\n" +
            "WHERE tp.product_line_id = sd.id and tp.delete_no = 0"+
            "<if test='name != null'>AND tp.product_number LIKE CONCAT('%', #{name},'%')</if>"+
            "<if test='deId != null'>AND tp.product_line_id=#{deId}</if>" +
            "</script>")
    Integer countByProduct(@Param("name")String name,@Param("deId")Integer deId);

    //查询原材料
    @Select(value = "<script>SELECT st.id as id,st.stock_name as stockName,\n" +
            "st.stock_number as stockNumber,st.stock_model as stockModel,\n" +
            "sd.`name` as stockType,sdd.`name` as dictionarier,\n" +
            "st.stock_remarks as stockRemarks,\n" +
            "st.state as state,\n" +
            "st.delete_no as deleteNo\n" +
            "FROM t_stock st\n" +
            "LEFT JOIN s_dictionarier sd ON st.stock_type_id = sd.id\n" +
            "LEFT JOIN s_dictionarier sdd ON st.dictionarier_id = sd.id\n" +
            "WHERE st.delete_no = 0 and st.material_type = #{deTypeid}"+
            "<if test='name != null'>AND st.stock_number LIKE CONCAT('%', #{name},'%')</if>"+
            "<if test='xbTypeId != null'>AND st.stock_type_id = #{xbTypeId}</if>"+
            "<if test='pageNum != null and pageSize != null'>LIMIT #{pageNum},#{pageSize}</if></script>")
    List<StockModel> findAllStock(@Param("name")String name,@Param("xbTypeId")Integer xbTypeId,@Param("deTypeid")Integer deTypeid,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    //根据Id查询原材料
    @Select(value = "<script>SELECT st.id as id,st.stock_name as stockName,\n" +
            "st.stock_number as stockNumber,st.stock_model as stockModel,\n" +
            "sd.`name` as stockType,st.stock_type_id as stockTypeId," +
            "sdd.`name` as dictionarier,st.dictionarier_id as dictionarierId,\n" +
            "st.stock_remarks as stockRemarks,\n" +
            "st.state as state,\n" +
            "st.delete_no as deleteNo\n" +
            "FROM t_stock st\n" +
            "LEFT JOIN s_dictionarier sd ON st.stock_type_id = sd.id\n" +
            "LEFT JOIN s_dictionarier sdd ON st.dictionarier_id = sd.id\n" +
            "WHERE st.delete_no = 0 and st.id = #{deid} and st.material_type = #{deTypeid}"+
            "</script>")
    StockModel findAllStockById(@Param("deid")Integer deid,@Param("deTypeid")Integer deTypeid);

    //查询原材料统计个数
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM t_stock st\n" +
            "LEFT JOIN s_dictionarier sd ON st.stock_type_id = sd.id\n" +
            "LEFT JOIN s_dictionarier sdd ON st.dictionarier_id = sd.id\n" +
            "WHERE st.delete_no = 0 and st.material_type = #{deId}"+
            "<if test='name != null'>AND st.stock_number LIKE CONCAT('%', #{name},'%')</if>"+
            "</script>")
    Integer countByStock(@Param("name")String name,@Param("deId")Integer deId);

    //查询线轴
    @Select(value = "<script>SELECT tb.id as id,\n" +
            "tb.bobbin_name as stockName,\n" +
            "tb.bobbin_model as stockModel,\n" +
            "tb.bobbin_number as stockNumber,\n" +
            "sd.`name` as procedurename,\n" +
            "sdd.`name` as bobbintype,\n" +
            "sdi.`name` as dictionarier,\n" +
            "tb.remark as stockRemarks,\n" +
            "tb.state as state,\n" +
            "tb.delete_no as deleteNo\n" +
            "FROM t_bobbin tb\n" +
            "LEFT JOIN s_dictionarier sd ON tb.procedure_id = sd.id\n" +
            "LEFT JOIN s_dictionarier sdd ON tb.bobbintype_id = sdd.id\n" +
            "LEFT JOIN s_dictionarier sdi ON tb.dictionarier_id = sdi.id\n" +
            "WHERE tb.delete_no = 0"+
            "<if test='name != null'>AND tb.bobbin_model LIKE CONCAT('%', #{name},'%')</if>"+
            "<if test='deId != null'>AND tb.bobbintype_id=#{deId}</if>" +
            "<if test='pageNum != null and pageSize != null'>LIMIT #{pageNum},#{pageSize}</if></script>")
    List<StockModel> findAllbobbin(@Param("name")String name,@Param("deId")Integer deId,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    //根据Id查询单条线轴
//    @Select(value = "<script>SELECT tb.id as id,\n" +
//            "tb.bobbin_name as bobbinName,\n" +
//            "tb.bobbin_model as bobbinModel,\n" +
//            "tb.bobbin_number as bobbinNumber,\n" +
//            "sd.`name` as procedureName,\n" +
//            "sdd.`name` as bobbintype,\n" +
//            "sdi.`name` as dictionarier,\n" +
//            "tb.remark as remark,\n" +
//            "tb.state as state,\n" +
//            "tb.delete_no as deleteNo\n" +
//            "FROM t_bobbin tb\n" +
//            "LEFT JOIN s_dictionarier sd ON tb.procedure_id = sd.id\n" +
//            "LEFT JOIN s_dictionarier sdd ON tb.bobbintype_id = sdd.id\n" +
//            "LEFT JOIN s_dictionarier sdi ON tb.dictionarier_id = sdi.id\n" +
//            "WHERE tb.delete_no = 0 and tb.id =  #{deId}"+
//            "</script>")
//    TBobbinVo findAllbobbinById(@Param("deId")Integer deId);

    //查询线轴统计个数
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM t_bobbin tb\n" +
            "LEFT JOIN s_dictionarier sd ON tb.procedure_id = sd.id\n" +
            "LEFT JOIN s_dictionarier sdd ON tb.bobbintype_id = sdd.id\n" +
            "LEFT JOIN s_dictionarier sdi ON tb.dictionarier_id = sdi.id\n" +
            "WHERE tb.delete_no = 0"+
            "<if test='name != null'>AND tb.bobbin_model LIKE CONCAT('%', #{name},'%')</if>"+
            "<if test='deId != null'>AND tb.bobbintype_id=#{deId}</if>" +
            "</script>")
    Integer countBybobbin(@Param("name")String name,@Param("deId")Integer deId);

    //    查询原材料下拉框
    @Select(value = "<script>SELECT id as MapKey,stock_number as MapValue,stock_name as MapValue2,stock_model as Mapliandong  FROM t_stock WHERE delete_no = 0 and state = 0 </script>")
    List<MapVo> findAllStockByXiaLa();

    //    联动下拉框：根据原材料Id查出原材料规格明细
    @Select(value = "<script>SELECT id as MapKey,standards as MapValue FROM t_standards WHERE delete_no = 0 \n" +
            "<if test='deTypeId != null'>and material_type =#{deTypeId}</if> " +
            "<if test='deId != null'>and material_id =#{deId}</if> " +
            "  </script>")
    List<MapVo> findAllStockDetailByIdXiaLa(@Param("deId")Integer deId,@Param("deTypeId")Integer deTypeId);


    //    查询产品下拉框
    @Select(value = "<script>SELECT tp.id as MapKey,tp.product_number as MapValue,\n" +
            "tp.product_name as MapValue2,tp.product_model as Mapliandong,\n" +
            "sd.`name` as Mapliandong2  \n" +
            "FROM t_product tp\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = tp.product_unit_id\n" +
            "WHERE tp.delete_no = 0 and tp.state = 0 \n" +
            "<if test='name != null'>and tp.product_model LIKE CONCAT('%', #{name},'%')</if> </script>")
    List<MapVo> findAllProductByXiaLa(@Param("name")String name);

    //    联动下拉框：根据产品Id查出产品规格明细
    @Select(value = "<script>SELECT id as MapKey,um_start as MapValue FROM t_prostandard WHERE delete_no = 0 \n" +
            "<if test='deId != null'>and product_id =#{deId}</if> \n" +
            "</script>")
    List<MapVo> findAllProductDetailByIdXiaLa(@Param("deId")Integer deId);

    //查询审核设置
    @Select(value = "<script>SELECT aud.id as id,aud.audit_level as auditLevel,\n" +
            "aud.level_name levelName,aud.remark as remark,\n" +
            "aud.staff_id as staffId,mp.post_name as staffPost,\n" +
            "sf.staff_name as staffName\n" +
            "FROM audit_setting aud\n" +
            "INNER JOIN s_staff sf ON sf.id = aud.staff_id\n" +
            "INNER JOIN mes_post mp ON mp.id =  sf.post_id\n" +
            "WHERE aud.delete_no = 0 AND aud.audit_type = #{name} \n" +
            "ORDER BY aud.id DESC \n"+
            "LIMIT #{pageNum},#{pageSize}  </script>")
    List<AuditModel> findAllAuditSetting(@Param("name")String name,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    //根据Id查询单条审核设置
    @Select(value = "<script>SELECT aud.id as id,aud.audit_level as auditLevel,\n" +
            "aud.level_name levelName,aud.remark as remark,\n" +
            "aud.staff_id as staffId\n" +
            "FROM audit_setting aud\n" +
            "WHERE aud.delete_no = 0 AND aud.id = #{findId} \n" +
            "</script>")
    AuditModel findAllAuditSettingById(@Param("findId")Integer findId);

    //查询审核设置总数
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM audit_setting aud\n" +
            "INNER JOIN s_staff sf ON sf.id = aud.staff_id\n" +
            "INNER JOIN mes_post mp ON mp.id =  sf.post_id\n" +
            "WHERE aud.delete_no = 0 AND aud.audit_type = #{name} \n" +
            "ORDER BY aud.id DESC</script>")
    Integer countByAuditSetting(@Param("name")String name);


    //查询采购订单
    @Select(value = "<script>SELECT tp.id as id,tp.purchase_order as purchaseOrder,\n" +
            "sc.customer_name as customerName,sf.staff_name as staffName,\n" +
            "tp.order_state as orderStateId,\n" +
            "tp.remark as remark,tp.delete_no as deleteNo,\n" +
            "tp.create_time as createTime,\n" +
            "SUM(tpd.stock_unit_price*tpd.stock_amount) as orderSum\n" +
            "FROM t_purchase tp\n" +
            "LEFT JOIN s_customer sc ON sc.id = tp.customer_id\n" +
            "LEFT JOIN s_staff sf ON sf.id = tp.staff_id\n" +
            "LEFT JOIN t_purchasedetail tpd ON tpd.purchase_id = tp.id\n" +
            "WHERE tp.delete_no = 0\n"+
            "<if test='name != null'>AND tp.purchase_order LIKE CONCAT('%', #{name},'%')</if>\n"+
            "GROUP BY tp.id\n" +
            "ORDER BY tp.id DESC\n" +
            "LIMIT #{pageNum},#{pageSize}</script>")
    List<PurchaseModel> findAllPurchase(@Param("name")String name,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    //订单审核(采购管理)-查询
    @Select(value = "<script>SELECT tp.id as id,tp.purchase_order as purchaseOrder,\n" +
            "sc.customer_name as customerName,sf.staff_name as staffName,\n" +
            "tp.order_state as orderStateId,\n" +
            "tp.remark as remark,tp.delete_no as deleteNo,\n" +
            "tp.create_time as createTime,\n" +
            "SUM(tpd.stock_unit_price*tpd.stock_amount) as orderSum\n" +
            "FROM t_purchase tp\n" +
            "LEFT JOIN s_customer sc ON sc.id = tp.customer_id\n" +
            "LEFT JOIN s_staff sf ON sf.id = tp.staff_id\n" +
            "LEFT JOIN t_purchasedetail tpd ON tpd.purchase_id = tp.id\n" +
            "WHERE tp.delete_no = 0 and order_state &lt;= 2\n"+
            "<if test='name != null'>AND tp.purchase_order LIKE CONCAT('%', #{name},'%')</if>\n"+
            "GROUP BY tp.id\n" +
            "Order BY tp.id desc\n" +
            "LIMIT #{pageNum},#{pageSize}</script>")
    List<PurchaseModel> findAllPurchaseOrderAudit(@Param("name")String name,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    //来料检验(采购管理)-查询
    @Select(value = "<script>SELECT tp.id as id,tp.purchase_order as purchaseOrder,\n" +
            "sc.customer_name as customerName,sf.staff_name as staffName,\n" +
            "tp.order_state as orderStateId,\n" +
            "tp.remark as remark,tp.delete_no as deleteNo,\n" +
            "tp.create_time as createTime,\n" +
            "SUM(tpd.stock_unit_price*tpd.stock_amount) as orderSum\n" +
            "FROM t_purchase tp\n" +
            "LEFT JOIN s_customer sc ON sc.id = tp.customer_id\n" +
            "LEFT JOIN s_staff sf ON sf.id = tp.staff_id\n" +
            "LEFT JOIN t_purchasedetail tpd ON tpd.purchase_id = tp.id\n" +
            "WHERE tp.delete_no = 0 and (order_state = 3 or order_state = 4) \n"+//and (order_state = 3 or order_state = 4)
            "<if test='name != null'>AND tp.purchase_order LIKE CONCAT('%', #{name},'%')</if>\n"+
            "GROUP BY tp.id\n" +
            "Order BY tp.id desc\n" +
            "LIMIT #{pageNum},#{pageSize}</script>")
    List<PurchaseModel> findAllPurchaseLLAudit(@Param("name")String name,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    //统计采购订单总数
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM t_purchase tp\n" +
            "WHERE tp.delete_no = 0"+
            "<if test='name != null'>AND tp.purchase_order LIKE CONCAT('%', #{name},'%')</if>"+
            "</script>")
    Integer countByPurchase(@Param("name")String name);

    //统计订单审核(采购管理)总数
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM t_purchase tp\n" +
            "WHERE tp.delete_no = 0"+
            "<if test='name != null'>AND tp.purchase_order LIKE CONCAT('%', #{name},'%')</if>"+
            "</script>")
    Integer countByPurchaseOrderAudit(@Param("name")String name);

    //来料检验(采购管理)总数
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM t_purchase tp\n" +
            "WHERE tp.delete_no = 0"+
            "<if test='name != null'>AND tp.purchase_order LIKE CONCAT('%', #{name},'%')</if>"+
            "</script>")
    Integer countByPurchaseLLAudit(@Param("name")String name);

    //根据采购订单Id查询采购明细
    @Select(value = "<script>SELECT tpd.id as id,tpd.stock_amount as stockAmount,\n" +
            "tpd.stock_unit_price as stockUnitPrice,tpd.remark as remark,\n" +
            "tpd.delete_no as deleteNo,tss.stock_number as stockNumber,\n" +
            "tss.stock_name as stockName,tss.stock_model as stockModel,\n" +
            "ts.standards as standards,tpd.unit_id as unitId,\n" +
            "sd.`name` as unitName,tpd.stock_id as stockId,\n" +
            "(tpd.stock_unit_price * tpd.stock_amount) as stockSum\n" +
            "FROM t_purchasedetail tpd\n" +
            "LEFT JOIN t_standards ts ON ts.id = tpd.stock_id\n" +
            "LEFT JOIN t_stock tss ON tss.id = ts.material_id\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = tpd.unit_id\n"+
            "WHERE tpd.purchase_id = #{fid}\n"+
            "</script>")
    List<TPurchasedetailModel> findAllPurchaseById(@Param("fid")Integer fid);

    @Transactional
    @Modifying
    @Select(value = "<script>INSERT INTO order_auditpocess(audit_level,audit_type,level_name,staff_id,order_id,create_time)\n" +
            "SELECT audit_level,audit_type,level_name,staff_id,#{orderId},#{createtime} FROM audit_setting\n"+
            "WHERE audit_setting.audit_type = #{typeone} or audit_setting.audit_type = #{typetwo}"+
            "</script>")
    void insertOrderPocess(@Param("orderId")Integer orderId, @Param("createtime")long createtime, @Param("typeone")String typeone, @Param("typetwo")String typetwo);

    @Transactional
    @Modifying
    @Select(value = "<script>INSERT INTO pp_order_auditpocess(audit_level,level_name,staff_id,order_id,create_time)\n" +
            "SELECT audit_level,level_name,staff_id,#{orderId},NOW() FROM audit_setting\n"+
            "WHERE audit_setting.audit_type = #{typeone}"+
            "</script>")
    void insertPPOrderPocess(@Param("orderId")Integer orderId,@Param("typeone")String typeone);


    //查询所有销售订单
    @Select(value = "<script>SELECT ts.id as id ,\n" +
            "ts.create_time as createTime,\n" +
            "ts.sale_order as saleOrder,\n" +
            "ts.order_state_id as orderStateId,\n" +
            "sc.customer_name as customer,\n" +
            "ts.receive_address as remark,sf.staff_name as staffName,\n" +
            "SUM(tsdetail.product_price*tsdetail.product_num) as orderSum\n" +
            "FROM t_saleorder ts\n" +
            "LEFT JOIN s_staff sf ON sf.id = ts.staff_id\n" +
            "LEFT JOIN s_customer sc ON sc.id = ts.customer_id\n" +
            "LEFT JOIN t_saleorderdetail tsdetail ON tsdetail.saleorder_id = ts.id\n" +
            "WHERE ts.delete_no = 0 \n"+
            "<if test='name != null'>AND ts.sale_order LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='starttime != null and endtime != null'>AND  ts.create_time BETWEEN #{starttime} AND #{endtime}</if>\n"+
            "GROUP BY ts.id\n" +
            "ORDER BY ts.id DESC\n" +
            "LIMIT #{pageNum},#{pageSize}</script>")
    List<SaleVo> findAllSale(@Param("name")String name,@Param("starttime")String starttime,@Param("endtime")String endtime,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    //统计采购订单总数
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM t_saleorder ts\n" +
            "WHERE ts.delete_no = 0 \n"+
            "<if test='name != null'>AND ts.sale_order LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='starttime != null and endtime != null'>AND ts.create_time BETWEEN #{starttime} AND #{endtime}</if>\n"+
            "</script>")
    Integer countBySale(@Param("name")String name,@Param("starttime")String starttime,@Param("endtime")String endtime);


    //销售订单管理-(销售订单审核)-查询
    @Select(value = "<script>SELECT ts.id as id ,\n" +
            "ts.create_time as createTime,\n" +
            "ts.sale_order as saleOrder,\n" +
            "ts.order_state_id as orderStateId,\n" +
            "sc.customer_name as customer,\n" +
            "ts.remark as remark,sf.staff_name as staffName,\n" +
            "SUM(tsdetail.product_price*tsdetail.product_num) as orderSum\n" +
            "FROM t_saleorder ts\n" +
            "LEFT JOIN s_staff sf ON sf.id = ts.staff_id\n" +
            "LEFT JOIN s_customer sc ON sc.id = ts.customer_id\n" +
            "LEFT JOIN t_saleorderdetail tsdetail ON tsdetail.saleorder_id = ts.id\n" +
            "WHERE ts.delete_no = 0 \n"+
            "<if test='name != null'>AND ts.sale_order LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='starttime != null and endtime != null'>AND  ts.create_time BETWEEN #{starttime} AND #{endtime}</if>\n"+
            "GROUP BY ts.id\n" +
            "ORDER BY ts.id DESC\n" +
            "LIMIT #{pageNum},#{pageSize}</script>")
    List<SaleVo> getAllSaleOrderAudit(@Param("name")String name,@Param("starttime")String starttime,@Param("endtime")String endtime,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);



    //根据销售订单Id查询销售订单
    @Select(value = "<script>SELECT tsde.id as id,tsde.saleorder_id as saleorderId," +
            "tsde.product_id as productdetailId,tpro.product_id as productId, \n" +
            "tp.product_name as productName,tp.product_model as productModel,tp.product_number as productNumber,\n" +
            "tpro.um_start as umStart,tsde.unit_id as unitId,\n" +
            "sd.`name` as unitName,tsde.product_num as productNum,\n" +
            "tsde.product_price as productPrice,(tsde.product_num * tsde.product_price) as productSum,\n" +
            "tsde.remark as remark,tsde.delete_no as deleteNo\n" +
            "FROM t_saleorderdetail tsde\n" +
            "LEFT JOIN t_prostandard tpro ON tpro.id = tsde.product_id \n" +
            "LEFT JOIN t_product tp ON tp.id = tpro.product_id \n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = tp.product_unit_id \n" +
            "WHERE tsde.delete_no = 0 and tsde.saleorder_id = #{deId}\n" +
            "GROUP BY tsde.id</script>")
    List<TSaleorderdetailVo> findSaleDetailById(@Param("deId")Integer deId);



    //根据采购/销售订单Id查询订单审核流程
    @Select(value = "<script>SELECT FROM_UNIXTIME(ap.create_time/1000) as createTime,\n" +
            "ap.audit_setting as auditSetting,ap.remark as remark,sf.staff_name as staffName\n" +
            "FROM audit_pocess ap\n" +
            "LEFT JOIN s_staff sf ON sf.id = ap.audit_staff_id\n" +
            "WHERE ap.audit_order_id = #{deId} AND (ap.audit_type = #{typeOne} or ap.audit_type = #{typeTwo})</script>")
    List<AuditPocessVo> findAuditListById(@Param("deId")Integer deId,@Param("typeOne")String typeOne,@Param("typeTwo")String typeTwo);

    //查询所有仓库信息
    @Select(value = "<script>SELECT tw.id as id,tw.warehouse_number as warehouseNumber,tw.warehousen_name as warehousenName,\n" +
            "sf.staff_name as staffName,tw.remark as remark,tw.state as state,tw.delete_no as deleteNo\n" +
            "FROM t_warehouse tw\n" +
            "INNER JOIN s_staff sf ON sf.id = tw.staff_id\n" +
            "WHERE tw.delete_no = 0 \n"+
            "<if test='name != null'>AND tw.warehousen_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "LIMIT #{pageNum},#{pageSize}</script>")
    List<WarehouseModel> findAllWarehouse(@Param("name")String name,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    @Select(value = "<script>SELECT count(1)\n" +
            "FROM t_warehouse tw\n" +
            "INNER JOIN s_staff sf ON sf.id = tw.staff_id\n" +
            "WHERE tw.delete_no = 0 \n"+
            "<if test='name != null'>AND tw.warehousen_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "</script>")
    Integer countByWarehouse(@Param("name")String name);

    //查询所有文件信息
    @Select(value = "<script>SELECT ft.id as id, FROM_UNIXTIME(ft.create_time/1000) as createTime,\n" +
            "ft.file_name as fileName,sf.staff_name as staffName,\n" +
            "ft.delete_no as deleteNo,ft.file_password as filePassword\n" +
            "FROM file_table ft\n" +
            "LEFT JOIN s_staff sf ON sf.id = ft.staff_id\n" +
            "WHERE ft.delete_no = 0\n"+
            "<if test='name != null'>AND ft.file_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "ORDER BY ft.id DESC LIMIT #{pageNum},#{pageSize}</script>")
    List<fileTableVo> findAllFile(@Param("name")String name,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    //查询文件信息总数
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM file_table ft\n" +
            "LEFT JOIN s_staff sf ON sf.id = ft.staff_id\n" +
            "WHERE ft.delete_no = 0\n"+
            "<if test='name != null'>AND ft.file_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "</script>")
    Integer countByFile(@Param("name")String name);

    //查询所有系统公告
    @Select(value = "<script>SELECT sn.id as id,FROM_UNIXTIME(sn.create_time/1000) as createTime,\n" +
            "sn.notice_name as noticeName,\n" +
            "sn.notice_content as noticeContent,\n" +
            "sf.staff_name as staffName,\n" +
            "sn.isshow as isshow,\n" +
            "sn.delete_no as deleteNo\n" +
            "FROM s_notice sn\n" +
            "LEFT JOIN s_staff sf ON sf.id = sn.staff_id\n" +
            "WHERE sn.delete_no = 0\n"+
            "<if test='name != null'>AND sn.notice_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "LIMIT #{pageNum},#{pageSize}</script>")
    List<NoticeVo> findAllNotice(@Param("name")String name,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    //查询系统公告总数
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM s_notice sn\n" +
            "LEFT JOIN s_staff sf ON sf.id = sn.staff_id\n" +
            "WHERE sn.delete_no = 0\n\n"+
            "<if test='name != null'>AND sn.notice_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "</script>")
    Integer countByNotice(@Param("name")String name);


//    ===========================库存管理=========================================================================

    //    库存管理-原材料/其他-入库查询  asdfasdfsafsafsaf
    @Select(value = "<script>SELECT id as id,stock_name as stockName,stock_number as stockNumber," +
            "stock_model as stockModel,dictionarier_id as dictionarierId\n" +
            "FROM t_stock\n" +
            "WHERE delete_no = 0 AND material_type = #{materialType}\n"+
            "<if test='name != null'>AND stock_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "</script>")
    List<StockModel> findAllWareHouseStock(@Param("name")String name,@Param("materialType")Integer materialType);

    //库存管理-原材料/线轴/其他-入库根据id查询明细
    @Select(value = "<script>SELECT id as updateID,standards as updateRemark\n" +
            "FROM t_standards\n" +
            "WHERE material_id = #{materialId} AND material_type  = #{deId} and delete_no = 0\n" +
            "</script>")
    List<UpdateModel> findByMaterialIdAndMaterialType(@Param("materialId")Integer materialId,@Param("deId")Integer deId);

    //    库存管理-成品-入库查询
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM s_notice sn\n" +
            "LEFT JOIN s_staff sf ON sf.id = sn.staff_id\n" +
            "WHERE sn.delete_no = 0\n\n"+
            "<if test='name != null'>AND sn.notice_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "</script>")
    List<StockModel> findAllWareHouseFinishedproduct(@Param("name")String name);

    //    库存管理-废料-入库查询
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM s_notice sn\n" +
            "LEFT JOIN s_staff sf ON sf.id = sn.staff_id\n" +
            "WHERE sn.delete_no = 0\n\n"+
            "<if test='name != null'>AND sn.notice_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "</script>")
    List<StockModel> findAllWareHouseWaste(@Param("name")String name);

    //    库存管理-线轴-入库查询
    @Select(value = "<script>SELECT id as id,bobbin_name as stockName,bobbin_number as stockNumber," +
            "bobbin_model as stockModel,dictionarier_id as dictionarierId\n" +
            "FROM t_bobbin\n" +
            "WHERE delete_no = 0\n"+
            "<if test='name != null'>AND bobbin_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "</script>")
    List<StockModel> findAllWareHouseBobbin(@Param("name")String name);

    //库存管理-出入库管理-页面查询-原料
    @Select(value = "<script>SELECT ire.id as id,FROM_UNIXTIME(ire.create_time/1000) as createTime, ire.record_type as recordTypeId," +
            "ire.inventory_type as inventType, ire.changequantity AS changequantity,ire.surplusquantity AS surplusquantity, " +
            "tw.warehousen_name as warehousenName,\n" +
            "ire.stock_name as stockName, ire.stock_model as stockModel,ire.stock_number as stockNumber, \n" +
            "ire.standards as standards,sd.`name` as unitName,ire.remark as remark,\n" +
            "(case WHEN ire.record_type =1 then \"出库\" \n" +
            "\tWHEN ire.record_type =2 then \"入库\" \n" +
            "\tWHEN ire.record_type =3 then \"调拨\" \n" +
            "\tWHEN ire.record_type =4 then \"销售\" \n" +
            "\tWHEN ire.record_type =5 then \"采购\" \n" +
            "\tWHEN ire.record_type =7 then \"生产出库\" \n" +
            "\tWHEN ire.record_type =6 then \"盘点\" end) as recordType\n" +
            "FROM inventory_record ire\n" +
            "LEFT JOIN t_warehouse tw ON tw.id = ire.warehouse_id\n" +
            "LEFT JOIN  s_dictionarier sd ON sd.id = ire.unit_id\n" +
            "WHERE  ire.inventory_type =#{modelNameId}   \n"+
            "<if test='name != null'>AND ire.stock_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='deId != null'>AND ire.product_detailid =#{deId} </if>\n"+
            "<if test='warehouseId != 0'>AND ire.warehouse_id =#{warehouseId}</if>\n"+
            "<if test='starttime != null and endtime != null'>AND  FROM_UNIXTIME(ire.create_time/1000) BETWEEN #{starttime} AND #{endtime}</if>\n"+
            "GROUP BY ire.id   ORDER BY ire.id DESC \n" +
            "<if test='pageNum !=null and pageSize != null'>LIMIT #{pageNum},#{pageSize}</if></script>")
    List<InventoryRecordVo> findAllInventoryRecord(@Param("modelNameId")Integer modelNameId,@Param("name")String name,
                                                          @Param("deId")Integer deId,@Param("warehouseId")Integer warehouseId,
                                                          @Param("starttime")String starttime,@Param("endtime")String endtime,
                                                          @Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
//    @Select(value = "<script>SELECT ire.id as id,FROM_UNIXTIME(ire.create_time/1000) as createTime,\n" +
//            "ire.record_type as recordTypeId,ire.inventory_type as inventType,\n" +
//            "ire.changequantity AS changequantity,ire.surplusquantity AS surplusquantity,\n" +
//            "tw.warehousen_name as warehousenName,st.stock_name as stockName,\n" +
//            "st.stock_model as stockModel,st.stock_number as stockNumber,\n" +
//            "stan.standards as standards,sd.`name` as unitName,ire.remark as remark," +
//            "(case WHEN ire.record_type =1 then \"出库\" \n" +
//            "\t\t\t\t\t\tWHEN ire.record_type =2 then \"入库\"\n" +
//            "\t\t\t\t\t\tWHEN ire.record_type =3 then \"调拨\"\n" +
//            "\t\t\t\t\t\tWHEN ire.record_type =4 then \"销售\"\n" +
//            "\t\t\t\t\t\tWHEN ire.record_type =5 then \"采购\"\n" +
//            "\t\t\t\t\t\tWHEN ire.record_type =7 then \"生产出库\"\n" +
//            "\t\t\t\t\t\tWHEN ire.record_type =6 then \"盘点\" end) as recordType\n" +
//            "FROM inventory_record ire\n" +
//            "LEFT JOIN t_warehouse tw ON tw.id = ire.warehouse_id\n" +
//            "LEFT JOIN t_standards stan ON stan.id = ire.product_detailid\n" +
//            "LEFT JOIN  t_stock st ON st.id = stan.material_id\n" +
//            "LEFT JOIN  s_dictionarier sd ON sd.id = st.dictionarier_id\n" +
//            "WHERE  ire.inventory_type =#{modelNameId}   \n"+
//            "<if test='name != null'>AND st.stock_name LIKE CONCAT('%', #{name},'%')</if>\n"+
//            "<if test='deId != null'>AND ire.product_detailid =#{deId} </if>\n"+
//            "<if test='warehouseId != null'>AND ire.warehouse_id =#{warehouseId}</if>\n"+
//            "<if test='starttime != null and endtime != null'>AND  FROM_UNIXTIME(ire.create_time/1000) BETWEEN #{starttime} AND #{endtime}</if>\n"+
//            "GROUP BY ire.id   ORDER BY ire.id DESC \n" +
//            "<if test='pageNum !=null and pageSize != null'>LIMIT #{pageNum},#{pageSize}</if></script>")
//    List<InventoryRecordVo> findAllInventoryRecordByStock(@Param("modelNameId")Integer modelNameId,@Param("name")String name,
//                                                          @Param("deId")Integer deId,@Param("warehouseId")Integer warehouseId,
//                                                          @Param("starttime")String starttime,@Param("endtime")String endtime,
//                                                          @Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);


    //库存管理-出入库管理-页面查询
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM (SELECT count(1) FROM inventory_record ire\n" +
            "LEFT JOIN t_warehouse tw ON tw.id = ire.warehouse_id\n" +
            "LEFT JOIN  s_dictionarier sd ON sd.id = ire.unit_id\n" +
            "WHERE  ire.inventory_type =#{modelNameId} \n"+
            "<if test='name != null'>AND ire.stock_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='starttime != null and endtime != null'>AND  FROM_UNIXTIME(ire.create_time/1000) BETWEEN #{starttime} AND #{endtime}</if>\n"+
            "GROUP BY ire.id)a\n"+
            "</script>")
    Integer countByInventoryRecord(@Param("modelNameId")Integer modelNameId,@Param("name")String name,@Param("starttime")String starttime,@Param("endtime")String endtime);

    //库存管理-出入库管理-页面查询-线轴
    @Select(value = "<script>SELECT ire.id as id,FROM_UNIXTIME(ire.create_time/1000) as createTime,\n" +
            "ire.inventory_type as inventType,\n" +
            "ire.changequantity AS changequantity,ire.surplusquantity AS surplusquantity,\n" +
            "tw.warehousen_name as warehousenName,tb.bobbin_name as stockName,\n" +
            "tb.bobbin_model as stockModel,tb.bobbin_number as stockNumber,\n" +
            "stan.standards as standards,sd.`name` as unitName,ire.remark as remark,\n" +
            "(case WHEN ire.record_type =1 then \"出库\" \n" +
            "\tWHEN ire.record_type =2 then \"入库\" \n" +
            "\tWHEN ire.record_type =3 then \"调拨\" \n" +
            "\tWHEN ire.record_type =4 then \"销售\" \n" +
            "\tWHEN ire.record_type =5 then \"采购\" \n" +
            "\tWHEN ire.record_type =7 then \"生产出库\" \n" +
            "\tWHEN ire.record_type =6 then \"盘点\" end) as recordType\n" +
            "FROM inventory_record ire\n" +
            "LEFT JOIN t_warehouse tw ON tw.id = ire.warehouse_id\n" +
            "LEFT JOIN t_standards stan ON stan.id = ire.product_detailid\n" +
            "LEFT JOIN t_bobbin tb ON tb.id = stan.material_id\n" +
            "LEFT JOIN  s_dictionarier sd ON sd.id = tb.dictionarier_id\n" +
            "WHERE  ire.inventory_type =#{modelNameId}   \n"+
            "<if test='name != null'>AND st.stock_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='deId != null'>AND ire.product_detailid =#{deId} </if>\n"+
            "<if test='warehouseId != 0'>AND ire.warehouse_id =#{warehouseId}</if>\n"+
            "<if test='starttime != null and endtime != null'>AND  FROM_UNIXTIME(ire.create_time/1000) BETWEEN #{starttime} AND #{endtime}</if>\n"+
            "GROUP BY ire.id  ORDER BY ire.id DESC\n" +
            "<if test='pageNum != 0 and pageSize != 0'>LIMIT #{pageNum},#{pageSize}</if></script>")
    List<InventoryRecordVo> findAllInventoryRecordByBobbin(@Param("modelNameId")Integer modelNameId,@Param("name")String name,
                                                          @Param("deId")Integer deId,@Param("warehouseId")Integer warehouseId,
                                                          @Param("starttime")String starttime,@Param("endtime")String endtime,
                                                          @Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

//    //库存管理-出入库管理-页面查询
//    @Select(value = "<script>SELECT count(1)\n" +
//            "FROM (SELECT count(1) FROM inventory_record ire\n" +
//            "LEFT JOIN t_warehouse tw ON tw.id = ire.warehouse_id\n" +
//            "LEFT JOIN t_standards stan ON stan.id = ire.product_detailid\n" +
//            "LEFT JOIN  t_stock st ON st.id = stan.material_id\n" +
//            "LEFT JOIN  s_dictionarier sd ON sd.id = st.dictionarier_id\n" +
//            "WHERE  ire.inventory_type =#{modelNameId} \n"+
//            "<if test='name != null'>AND st.stock_name LIKE CONCAT('%', #{name},'%')</if>\n"+
//            "<if test='starttime != null and endtime != null'>AND  FROM_UNIXTIME(ire.create_time/1000) BETWEEN #{starttime} AND #{endtime}</if>\n"+
//            "GROUP BY ire.id)a\n"+
//            "</script>")
//    Integer countByInventoryRecordByStock(@Param("modelNameId")Integer modelNameId,@Param("name")String name,@Param("starttime")String starttime,@Param("endtime")String endtime);




    //库存管理-出入库管理-调拨/出库数据查询（原料、其他）
    @Select(value = "<script>SELECT ts.material_id as id,st.stock_name as stockName,st.stock_model as stockModel," +
            "st.stock_number as stockNumber,sd.`name` as dictionarier,st.dictionarier_id as dictionarierId\n" +
            "FROM inventory_status\n" +
            "LEFT JOIN t_standards ts ON ts.id = inventory_status.product_id\n" +
            "LEFT JOIN t_stock st ON st.id = ts.material_id\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = st.dictionarier_id\n" +
            "WHERE inventory_status.inventory_type  = #{deId} AND st.material_type = #{materialType}\n" +
            "<if test='name != null'>AND st.stock_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='warehourseId != null and warehourseId != 0'>AND inventory_status.warehouse_id =#{warehourseId} </if>\n"+
            "GROUP BY ts.material_id</script>")
    List<StockModel> findAllInventoryStateByCDData(@Param("name")String name,@Param("deId")Integer deId,@Param("warehourseId")Integer warehourseId,@Param("materialType")Integer materialType);

    //库存管理-出入库管理-调拨/出库数据根据id查询明细
    @Select(value = "<script>SELECT \n" +
            "ts.standards as updateRemark,inventory_status.id as updateID,inventory_status.inventorysum as updateNum\n" +
            "FROM inventory_status\n" +
            "LEFT JOIN t_standards ts ON ts.id = inventory_status.product_id\n" +
            "LEFT JOIN t_stock st ON st.id = ts.material_id\n" +
            "WHERE inventory_status.inventory_type  = #{deId}\n" +
            "<if test='warehourseId != null and warehourseId != 0'>AND inventory_status.warehouse_id =#{warehourseId} </if>\n"+
            "AND ts.material_id = #{materialId}</script>")
    List<UpdateModel> findAllInventoryStateByCDDataId(@Param("deId")Integer deId, @Param("materialId")Integer materialId,@Param("warehourseId")Integer warehourseId);

    //库存管理-出入库管理-调拨/出库数据查询（线轴） AND st.material_type =2
    @Select(value = "<script>SELECT ts.material_id as id,tb.bobbin_name as stockName,\n" +
            "tb.bobbin_model as stockModel,tb.bobbin_number as stockNumber,\n" +
            "sd.`name` as dictionarier,tb.dictionarier_id as dictionarierId \n" +
            "FROM inventory_status \n" +
            "LEFT JOIN t_standards ts ON ts.id = inventory_status.product_id \n" +
            "LEFT JOIN t_bobbin tb ON tb.id = ts.material_id \n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = tb.dictionarier_id\n" +
            "WHERE inventory_status.inventory_type  = 5 \n" +
            "<if test='name != null'>AND tb.bobbin_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='warehourseId != null and warehourseId != 0'>AND inventory_status.warehouse_id =#{warehourseId} </if>\n"+
            "GROUP BY ts.material_id</script>")
    List<StockModel> findAllInventoryStateByBobbin(@Param("name")String name,@Param("warehourseId")Integer warehourseId);

    //库存管理-库存管理-页面查询(所有)
    @Select(value = "<script>SELECT invs.id as id,invs.product_id as productId,invs.inventorysum as inventorysum, \n" +
            "invs.stock_name as stockName,invs.stock_model as stockModel, \n" +
            "invs.stock_number as stockNumber,invs.standards as standards, \n" +
            "sd.`name` as unitName,tw.warehousen_name as warehousenName, \n" +
            "(CASE WHEN invs.inventory_type = 1 THEN \"原料\" \n" +
            "WHEN invs.inventory_type = 2 THEN \"产品\" \n" +
            "WHEN invs.inventory_type = 3 THEN \"半成品\" \n" +
            "WHEN invs.inventory_type = 4 THEN \"废料\" \n" +
            "WHEN invs.inventory_type = 5 THEN \"线轴\" \n" +
            "WHEN invs.inventory_type = 6 THEN \"其他\" END)as inventoryTypestr \n" +
            "FROM inventory_status invs \n" +
            "LEFT JOIN t_warehouse tw ON tw.id = invs.warehouse_id \n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = invs.unit_id\n" +
            "WHERE  invs.inventory_type =#{modelNameId}   \n"+
            "<if test='name != null'>AND invs.stock_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "ORDER BY invs.id DESC LIMIT #{pageNum},#{pageSize}</script>")
    List<InventoryStatusVo> findAllInventoryStates(@Param("modelNameId")Integer modelNameId,@Param("name")String name,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    //库存管理-库存管理-页面查询(所有)
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM inventory_status invs\n" +
            "LEFT JOIN t_warehouse tw ON tw.id = invs.warehouse_id\n" +
            "LEFT JOIN  s_dictionarier sd ON sd.id = invs.unit_id\n" +
            "WHERE  invs.inventory_type =#{modelNameId}   \n"+
            "<if test='name != null'>AND invs.stock_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "</script>")
    Integer countByInventoryStates(@Param("modelNameId")Integer modelNameId,@Param("name")String name);

    //库存管理-库存管理-根据规格id查询原料参数
    @Select(value = "<script>SELECT st.stock_number as stockNumber,\n" +
            "sdd.`name` as stockType, st.stock_name as stockName,\n" +
            "st.stock_remarks as stockRemarks, st.stock_model as stockModel, sd.`name` as dictionarier \n" +
            "FROM t_standards ts\n" +
            "LEFT JOIN t_stock st ON st.id = ts.material_id \n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = st.dictionarier_id \n" +
            "LEFT JOIN s_dictionarier sdd ON sdd.id = st.stock_type_id \n" +
            "WHERE ts.id = #{deId}\n"+
            "</script>")
    StockModel findstockDetailById(@Param("deId")Integer deId);

    //库存管理-库存管理-根据原料规格id查询当前库存  sto.material_type = #{mtype}
    @Select(value = "<script>SELECT ins.id as id, ins.inventorysum as inventorysum," +
            "tw.warehousen_name as warehousenName,sto.stock_number as stockNumber," +
            "ins.warehouse_id AS warehouseId,ins.product_id as productId, " +
            "sdd.`name` as stockType, sto.stock_name as stockName,sto.stock_model as stockModel, \n" +
            "sd.`name` as unitName,st.standards as standards\n" +
            "FROM inventory_status ins\n" +
            "LEFT JOIN t_warehouse tw ON tw.id = ins.warehouse_id\n" +
            "LEFT JOIN t_standards st ON st.id = ins.product_id\n" +
            "LEFT JOIN t_stock sto ON sto.id = st.material_id\n" +
            "LEFT JOIN  s_dictionarier sd ON sd.id = sto.dictionarier_id\n" +
            "LEFT JOIN s_dictionarier sdd ON sdd.id = sto.stock_type_id \n" +
            "WHERE ins.product_id = #{deId} and ins.inventory_type =#{mtype} \n"+
            "<if test='warehouseId != 0'>AND ins.warehouse_id =#{warehouseId} </if>\n"+
            "</script>")
    List<InventoryStatusVo> findByStockInventoryDetailId(@Param("deId")Integer deId,@Param("warehouseId")Integer warehouseId,@Param("mtype")Integer mtype);


    //    库存管理-库存状况：根据规格id跟仓库统计库存总数
    @Select(value = "<script>SELECT SUM(inventory_status.inventorysum)\n" +
                    "FROM inventory_status\n" +
                    "WHERE id != 0\n" +
                    "<if test='deId != null'>AND product_id = #{deId} </if>\n"+
                    "<if test='warehouseId != 0'>AND warehouse_id = #{warehouseId} </if>\n"+
                    "</script>")
    Integer countByInventoryStatusSum(@Param("deId")Integer deId,@Param("warehouseId")Integer warehouseId);

    //库存管理-库存管理-根据原料规格id查询当前库存
    @Select(value = "<script>SELECT ins.id as id, ins.inventorysum as inventorysum,tw.warehousen_name as warehousenName, " +
            "sd.`name` as unitName,st.standards as standards\n" +
            "FROM inventory_status ins\n" +
            "LEFT JOIN t_warehouse tw ON tw.id = ins.warehouse_id\n" +
            "LEFT JOIN t_standards st ON st.id = ins.product_id\n" +
            "LEFT JOIN t_bobbin tb ON tb.id = st.material_id\n" +
            "LEFT JOIN  s_dictionarier sd ON sd.id = tb.dictionarier_id\n" +
            "WHERE ins.product_id = #{deId}\n"+
            "<if test='warehouseId != 0'>AND ins.warehouse_id =#{warehouseId} </if>\n"+
            "</script>")
    List<InventoryStatusVo> findByBobbinInventoryDetailId(@Param("deId")Integer deId,@Param("warehouseId")Integer warehouseId);

    //库存管理-库存管理-根据规格id查询线轴参数
    @Select(value = "<script>SELECT ts.id as id, tb.bobbin_number as stockNumber, \n" +
            "tb.bobbin_name as stockName,tb.remark as stockRemarks, \n" +
            "tb.bobbin_model as stockModel, sd.`name` as dictionarier,sdd.`name` as stockType\n" +
            "FROM t_standards ts \n" +
            "LEFT JOIN t_bobbin tb ON tb.id = ts.material_id \n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = tb.dictionarier_id\n" +
            "LEFT JOIN s_dictionarier sdd ON sdd.id = ts.material_id\n" +
            "WHERE ts.material_type = 2 and ts.id =#{deId} \n"+
            "</script>")
    StockModel findByBobbinDetailId(@Param("deId")Integer deId);


    //查询所有设备信息
    @Select(value = "<script>SELECT te.id as id,te.equipment_name as equipmentName,\n" +
            "te.equipment_model as equipmentModel,te.equipment_number as equipmentNumber,\n" +
            "te.state as state,te.check_no as checkNo\n" +
            "FROM t_equipment te\n" +
            "WHERE te.delete_no = 0 \n"+
            "<if test='name != null'>AND te.equipment_model LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='deId != null and deId != 2'>AND te.check_no = #{deId} </if>\n"+
            "LIMIT #{pageNum},#{pageSize}</script>")
    List<Equipment> findAllEquipment(@Param("name")String name, @Param("deId")Integer deId, @Param("pageNum")int pageNum, @Param("pageSize")int pageSize);

    //统计所有设备信息
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM t_equipment te\n" +
            "WHERE te.delete_no = 0 \n"+
            "<if test='name != null'>AND te.equipment_model LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='deId != null and deId != 2'>AND te.check_no = #{deId} </if>\n"+
            "</script>")
    Integer countByEquipment(@Param("name")String name, @Param("deId")Integer deId);

    //设备检修-根据设备id查询当前检修数据
    @Select(value = "<script>SELECT te.id as id,te.equipment_name as equipmentName,te.equipment_number as equipmentNumber,\n" +
            "te.state as state,\n" +
            "(SELECT count(1) FROM t_equipmentcheckrecord \n" +
            "WHERE check_year = #{checkYear} and check_month= #{checkMonth} \n" +
            "and check_day =#{checkDay} and equipment_id = #{deId}) AS checkNo\n" +
            "FROM t_equipment te \n" +
            "WHERE te.id = #{deId} and te.delete_no = 0\n"+
            "</script>")
    EquipmentVo findEquipmentVoById(@Param("deId")Integer deId, @Param("checkYear")Integer checkYear,@Param("checkMonth")Integer checkMonth,@Param("checkDay")Integer checkDay);

    //设备检修-根据设备id查询当前检修数据
    @Select(value = "<script>SELECT te.user_time\n" +
            "FROM t_equipmentcheckdetailrecord ted\n" +
            "INNER JOIN t_equipmentcheckrecord te ON te.id = ted.equipment_check_record_id\n" +
            "WHERE te.equipment_id = #{deId} AND ted.overhaul_state = #{state} " +
            "<if test='checkYear != null and checkMonth != null'>AND te.check_year = #{checkYear} AND te.check_month = #{checkMonth} </if>\n"+
            "GROUP BY te.id\n"+
            "</script>")
    List<Integer> sumEquipmentUserTimeByEqId(@Param("deId")Integer deId,@Param("state")Integer state, @Param("checkYear")Integer checkYear,@Param("checkMonth")Integer checkMonth);


    //把设备检修项目记录下来
    @Transactional
    @Modifying
    @Select(value = "<script>INSERT INTO t_equipmentoverhaul(equipment_item_id,equipment_id,equipment_time) \n" +
            "SELECT id,#{orderId},#{createtime} FROM t_equipmentitems\n" +
            "WHERE t_equipmentitems.equipment_id = #{orderId}" +
            "</script>")
    void insertEquipmentOverhaul(@Param("orderId")Integer orderId, @Param("createtime")String createtime);

    //根据设备id跟时间查询当月的检项
    @Select(value = "<script>SELECT te.equipment_item_id as id,teq.equipment_items as equipmentItems \n" +
            "FROM t_equipmentoverhaul te\n" +
            "LEFT JOIN t_equipmentitems teq ON teq.id = te.equipment_item_id\n" +
            "WHERE te.equipment_id = #{equipmentId} and te.equipment_time = #{createtime}\n"+
            "</script>")
    List<EquipmentItems> findEquipmentoverhaulByEquipmentIdAndTime(@Param("equipmentId")Integer equipmentId, @Param("createtime")String createtime);

    //设备管理：查询该设备所有日期
    @Select(value = "<script>SELECT SUM(te.user_time) as userTime,GROUP_CONCAT(ed.overhaul_state) as overhaulState,\n" +
            "ed.equipment_overhaul_id as equipmentOverhaulId,te.check_year as checkYear," +
            "te.check_month as checkMonth,te.check_day as checkDay,\n" +
            "(CASE SUM(te.frequency) \n" +
            "    WHEN 1 THEN \"B\"\n" +
            "\t\tWHEN 2 THEN \"Y\"\n" +
            "\t\tWHEN 3 THEN \"BY\"\n" +
            "END) as frequencystr,sf.staff_name as staffName\n" +
            "FROM t_equipmentcheckrecord te\n" +
            "LEFT JOIN t_equipmentcheckdetailrecord ed ON ed.equipment_check_record_id = te.id\n" +
            "LEFT JOIN s_staff sf ON sf.id = te.staff_id\n" +
            "WHERE te.check_year = #{checkYear} AND te.check_month = #{checkMonth}\n" +
            "AND te.equipment_id = #{equipmentId}\n" +
            "GROUP BY ed.equipment_overhaul_id\n"+
            "</script>")
    List<EquipmentRecordVo> findCheckRecordByEquipmentIdAndTime(@Param("equipmentId")Integer equipmentId, @Param("checkYear")Integer checkYear, @Param("checkMonth")Integer checkMonth);

    //查询所有历史报修
    @Select(value = "<script>SELECT tr.id as id,tr.create_time as createTime,tr.repair_report_number as repairReportNumber," +
            "tr.delete_no as deleteNo,\n" +
            "te.equipment_name as equipmentName,te.equipment_number as equipmentNumber,te.equipment_model as equipmentModel,\n" +
            "(case WHEN tr.state =0 then \"待处理\" \n" +
            "\t\t\t\t\t\tWHEN tr.state =1 then \"待维修\"\n" +
            "\t\t\t\t\t\tWHEN tr.state =2 then \"待检验\"\n" +
            "\t\t\t\t\t\tWHEN tr.state =3 then \"已完成\" end) as stateName\n" +
            "FROM t_repairreport tr\n" +
            "INNER JOIN t_equipment te ON te.id = tr.equipment_id\n" +
            "WHERE tr.delete_no = 0 and tr.equipment_id = #{equipmentId}  \n"+
            "<if test='name != null'>AND tr.repair_report_number LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='deId != null and deId != 4'>AND tr.state = #{deId} </if>\n"+
            "LIMIT #{pageNum},#{pageSize}</script>")
    List<EquipmentVo> getAllRepairReport(@Param("name")String name, @Param("deId")Integer deId,@Param("equipmentId")Integer equipmentId, @Param("pageNum")int pageNum, @Param("pageSize")int pageSize);

    //查询所有历史报修总数
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM t_repairreport tr\n" +
            "INNER JOIN t_equipment te ON te.id = tr.equipment_id\n" +
            "WHERE tr.delete_no = 0 and tr.equipment_id = #{equipmentId}  \n"+
            "<if test='name != null'>AND tr.repair_report_number LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='deId != null and deId != 4'>AND tr.state = #{deId} </if>\n"+
            "</script>")
    Integer countByRepairReport(@Param("name")String name, @Param("deId")Integer deId,@Param("equipmentId")Integer equipmentId);

    //根据id查询历史报修
    @Select(value = "<script>SELECT  tr.id as id, tr.create_time as createTime,tr.repair_report_number as repairReportNumber," +
            "tr.state as state,tr.delete_no as deleteNo,\n" +
            "te.equipment_name as equipmentName,te.equipment_number as equipmentNumber,te.equipment_model as equipmentModel\n" +
            "FROM t_repairreport tr\n" +
            "INNER JOIN t_equipment te ON te.id = tr.equipment_id\n" +
            "WHERE tr.delete_no = 0 and tr.id = #{deId}  \n"+
            "</script>")
    EquipmentVo getRepairReportById(@Param("deId")Integer deId);

    //根据是否为成套模具-查询所有模具
    @Select(value = "<script>SELECT tm.id,tm.mould_name as mouldName,\n" +
            "tm.mould_model as mouldModel,tm.mould_number as mouldNumber,\n" +
            "sd.`name` as linetypeName,sdd.`name` as modelusedName,\n" +
            "tm.wiredraw_remark as wiredrawRemark,tm.warn_racc as warnRacc,\n" +
            "tm.wiredraw_sum as wiredrawSum,tm.scrap_no as scrapNo,\n" +
            "(case WHEN tm.scrap_no =0 then \"正常\" \n" +
            "\t\t\t\t\t\tWHEN tm.scrap_no =1 then \"报废\" end) as stateName\n" +
            "FROM t_mould tm\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = tm.linetype_id\n" +
            "LEFT JOIN s_dictionarier sdd ON sdd.id = tm.modelused_id\n" +
            "WHERE tm.delete_no = 0 and tm.cuffingmould_nno = #{cuffingmouldno} \n" +
            "<if test='name != null'>AND tm.mould_model LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='deId != null and deId != 0'>AND tm.linetype_id = #{deId} </if>\n"+
            "<if test='stateId != null and stateId != 2'>AND tm.scrap_no = #{stateId} </if>\n"+
            "order by tm.id desc  LIMIT #{pageNum},#{pageSize}</script>")
    List<TMouldVo> findAllTMouldByCuffingMouldNno(@Param("cuffingmouldno")Integer cuffingmouldno,@Param("name")String name, @Param("deId")Integer deId,@Param("stateId")Integer stateId, @Param("pageNum")int pageNum, @Param("pageSize")int pageSize);

    //根据是否为成套模具-统计所有模具数量
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM t_mould tm\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = tm.linetype_id\n" +
            "LEFT JOIN s_dictionarier sdd ON sdd.id = tm.modelused_id\n" +
            "WHERE tm.delete_no = 0 and tm.cuffingmould_nno = #{cuffingmouldno}\n" +
            "<if test='name != null'>AND tm.mould_model LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='deId != null and deId != 0'>AND tm.linetype_id = #{deId} </if>\n"+
            "<if test='stateId != null and stateId != 2'>AND tm.scrap_no = #{stateId} </if>\n"+
            "</script>")
    Integer countByTMouldByCuffingMouldNno(@Param("cuffingmouldno")Integer cuffingmouldno,@Param("name")String name, @Param("deId")Integer deId,@Param("stateId")Integer stateId);

    //成套模具维护-根据id查询模具明细信息
    @Select(value = "<script>SELECT tm.id,tm.mould_name as mouldName,\n" +
            "tm.mould_model as mouldModel,tm.mould_number as mouldNumber,\n" +
            "sd.`name` as linetypeName,sdd.`name` as modelusedName,\n" +
            "tm.wiredraw_remark as wiredrawRemark,tm.warn_racc as warnRacc,\n" +
            "tm.wiredraw_sum as wiredrawSum,tm.scrap_no as scrapNo,\n" +
            "tm.wiredraw_up as wiredrawUp,tm.wiredraw_down as wiredrawDown,\n" +
            "tm.wiredrawg_up as wiredrawgUp,tm.wiredrawg_pip as wiredrawgPip,tm.wiredrawg_down as wiredrawgDown," +
            "IFNULL(tf.measureddiam_um,0) as measureddiamUm\n" +
            "FROM t_mould tm\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = tm.linetype_id\n" +
            "LEFT JOIN s_dictionarier sdd ON sdd.id = tm.modelused_id\n" +
            "LEFT JOIN (\n" +
            "   SELECT mould_id, measureddiam_um FROM t_finishedproducecheck  ORDER BY id DESC\t\n" +
            ")as tf ON  tf.mould_id =  tm.id\n" +
            "WHERE tm.delete_no = 0 and tm.id = #{deId}\n" +
            "GROUP BY tm.id \n" +
            "</script>")
    TMouldVo findTMouldById(@Param("deId")Integer deId);

    //成套模具维护-新增-根据id查询模具明细信息
    @Select(value = "<script>SELECT mould_id, 0 as entranceNo,0 as deformationNo,\n" +
            "0 as rsmNo,0 as exportNo,\"\" as remark,0 as deleteNo,\n" +
            "id as mouldDetailId,sonmould_model as sonmouldModel,\n" +
            "sonmould_spa_num as sonmouldSpaNum\n" +
            "FROM t_moulddetail\n" +
            "WHERE mould_id = #{deId} \n" +
            "</script>")
    List<CuffingcheckVo> findCuffindCheckDetailByMouldId(@Param("deId")Integer deId);

    //成套模具维护-新增操作-根据模具检查id查询模具数据
    @Select(value = "<script>SELECT id as mouldid,CONCAT_WS(',',mould_number,mould_name) as mouldName,mould_model as mouldModel,\n" +
            "\"\" as remark,0 as judgeresult\n" +
            "FROM t_mould \n" +
            "WHERE id = #{deId} \n" +
            "</script>")
    CuffingcheckVo findCuffindCheckByMouldId(@Param("deId")Integer deId);

    //成套模具维护-查看-根据id查询模具明细信息
    @Select(value = "<script>SELECT cd.id as id," +
//            "(case WHEN cd.entrance_no =0 then \"√\" \n" +
//            "\t\t\t\t\t\tWHEN cd.entrance_no =1 then \"X\" end) as entranceNos,\n" +
//            "(case WHEN cd.deformation_no =0 then \"√\" \n" +
//            "\t\t\t\t\t\tWHEN cd.deformation_no =1 then \"X\" end) as deformationNos,\n" +
//            "(case WHEN cd.rsm_no =0 then \"√\" \n" +
//            "\t\t\t\t\t\tWHEN cd.rsm_no =1 then \"X\" end) as rsmNos,\n" +
//            "(case WHEN cd.export_no =0 then \"√\" \n" +
//            "\t\t\t\t\t\tWHEN cd.export_no =1 then \"X\" end) as exportNos,\n" +
            "cd.entrance_no as entranceNo,cd.deformation_no as deformationNo,\n" +
            "cd.rsm_no as rsmNo,cd.export_no as exportNo," +
            "cd.remark as remark,cd.delete_no as deleteNo,\n" +
            "md.id as mouldDetailId,md.sonmould_model as sonmouldModel,md.sonmould_spa_num as sonmouldSpaNum\n" +
            "FROM t_cuffingcheckdetail cd\n" +
            "LEFT JOIN t_moulddetail md ON md.id = cd.mould_detail_id\n" +
            "WHERE cd.cuffing_check_id =  #{deId} \n" +
            "</script>")
    List<CuffingcheckVo> findCuffindCheckDetailByTcId(@Param("deId")Integer deId);

    //成套模具维护-查看-根据模具检查id查询模具数据
    @Select(value = "<script>SELECT  tc.id as id,tc.remark as remark,tc.judgeresult as judgeresult, " +
            "tm.id as mouldid,tm.mould_name as mouldName,tm.mould_model as mouldModel\n" +
            "FROM t_cuffingcheck tc \n" +
            "LEFT JOIN t_mould tm ON tm.id = tc.mouldid\n" +
            "WHERE tc.id =  #{deId} \n" +
            "</script>")
    CuffingcheckVo findCuffindCheckByTcId(@Param("deId")Integer deId);

    //成套模具维护-根据模具id查询模具历史检查数据
    @Select(value = "<script>SELECT cc.id as id,cc.create_time as createTime,sf.staff_name as staffName,\n" +
            "cc.remark as remark,\n" +
            "(case WHEN cc.judgeresult =0 then \"合格\"\n" +
            "WHEN cc.judgeresult =1 then \"不合格\" end) as judgeresult\n" +
            "FROM t_cuffingcheck cc\n" +
            "LEFT JOIN s_staff sf ON sf.id = cc.staffid\n" +
            "WHERE cc.mouldid =  #{deId} and cc.deleteno = 0 \n" +
            "</script>")
    List<CuffingcheckVo> findCuffindHistoryCheckByMouldId(@Param("deId")Integer deId);

    //成品模具维护-根据模具id查询模具历史检查数据
    @Select(value = "<script>SELECT tf.id as id,tf.create_time as createTime,tf.measureddiam_um as measureddiamUm,\n" +
            "tf.remark as remark,tf.delete_no as deleteNo,sf.staff_name as staffName\n" +
            "FROM t_finishedproducecheck tf\n" +
            "LEFT JOIN s_staff sf ON sf.id = tf.staff_id\n" +
            "WHERE tf.mould_id =  #{deId} and tf.delete_no = 0 \n" +
            "</script>")
    List<TFinishedproducecheckVo> findFinishedproducecheckByMouldId(@Param("deId")Integer deId);


    //    套模方案-根据模具类型跟设备类型查询模具数据
    @Select(value = "<script>SELECT tm.id as id,tm.mould_name as mouldName,tm.mould_model as mouldModel,\n" +
            "tm.mould_number as mouldNumber,tm.wiredraw_remark as wiredrawRemark,\n" +
            "tf.measureddiam_um as measureddiamUm\n" +
            "FROM t_mould tm\n" +
            "INNER JOIN t_equipment te ON  te.id =  tm.modelused_id\n" +
            "LEFT JOIN (\n" +
            "   SELECT mould_id, measureddiam_um FROM t_finishedproducecheck  ORDER BY id DESC\t\n" +
            ")as tf ON  tf.mould_id =  tm.id\n" +
            "WHERE tm.delete_no = 0 and te.equipment_type_id = #{deId} and tm.cuffingmould_nno = #{cuffingmouldnno}   \n" +
            "<if test='name != null'>AND tm.mould_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "GROUP BY tm.id\n" +
            "</script>")
    List<TMouldVo> findTMouldByequipmentTypeIdAndcuffingmouldNo(@Param("name")String name,@Param("deId")Integer deId, @Param("cuffingmouldnno")Integer cuffingmouldnno);


    //查询所有套模
    @Select(value = "<script>SELECT ts.id as id,ts.constitute_name as constituteName," +
            "ts.constitute_number as constituteNumber,ts.scope_application as scopeApplication,\n" +
            "sf.staff_name as staffName,sd.`name` as lineType,ts.scrap_no as stateNo,\n" +
            "(case WHEN ts.scrap_no =0 then \"正常\" \n" +
            "\t\t\t\t\t\tWHEN ts.scrap_no =1 then \"报废\" end) as scrapNo\n" +
            "FROM t_suit ts\n" +
            "LEFT JOIN s_staff sf ON sf.id = ts.staff_id\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = ts.line_type_id\n" +
            "WHERE ts.delete_no = 0  \n" +
            "<if test='name != null'>AND ts.constitute_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='deId != null and deId != 0'>AND ts.line_type_id = #{deId} </if>\n"+
            "<if test='stateId != null and stateId != 2'>AND ts.scrap_no = #{stateId} </if>\n"+
            "order by ts.id desc\n" +
            "LIMIT #{pageNum},#{pageSize}</script>")
    List<TSuitVo> findAllTSuit(@Param("name")String name, @Param("deId")Integer deId, @Param("stateId")Integer stateId, @Param("pageNum")int pageNum, @Param("pageSize")int pageSize);


    //查询所有套模-总数
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM t_suit ts\n" +
            "LEFT JOIN s_staff sf ON sf.id = ts.staff_id\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = ts.line_type_id\n" +
            "WHERE ts.delete_no = 0  \n" +
            "<if test='name != null'>AND ts.constitute_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='deId != null and deId != 0'>AND ts.line_type_id = #{deId} </if>\n"+
            "<if test='stateId != null and stateId != 2'>AND ts.scrap_no = #{stateId} </if>\n"+
            "</script>")
    Integer countByTSuit(@Param("name")String name, @Param("deId")Integer deId, @Param("stateId")Integer stateId);


    //根据套模id查询套模明细
    @Select(value = "<script>SELECT ts.id as id,ts.mould_type as mouldType,ts.mould_detail_id as mouldDetailId," +
            "tm.mould_model as mouldModel,tm.mould_number as mouldNumber,ts.composite_type_id as compositeTypeId,\n" +
            "(CASE WHEN ts.mould_type = 0 THEN \"不使用模具\"\n" +
            "WHEN ts.mould_type = 1 THEN \"成品模具\"\n" +
            "WHEN ts.mould_type = 2 THEN \"成套模具\" END)as mouldTypes,\n" +
            "(CASE WHEN ts.composite_type_id = 1 THEN \"粗拉\"\n" +
            "WHEN ts.composite_type_id = 2 THEN \"中拉\"\n" +
            "WHEN ts.composite_type_id = 3 THEN \"细拉\"\n" +
            "WHEN ts.composite_type_id = 4 THEN \"超细拉\" END)as compositeType\n" +
            "FROM t_suitdetail ts\n" +
            "LEFT JOIN t_mould tm ON tm.id = ts.mould_id\n" +
            "WHERE ts.delete_no = 0 and ts.suit_id = #{deId} \n" +
            "</script>")
    List<TSuitdetailVo> findTSuitDetailById(@Param("deId")Integer deId);

    //根据子模具ids查询子模具名称
    @Select(value = "<script>SELECT GROUP_CONCAT(sonmould_model)\n" +
            "FROM t_moulddetail \n" +
            "WHERE FIND_IN_SET(id,#{deIds}) \n" +
            "</script>")
    String findTmodelDetailByIds(@Param("deIds")String deId);

    //    查询套模下拉框
    @Select(value = "<script>SELECT id as MapKey,constitute_number as MapValue,constitute_name as MapValue2  FROM t_suit WHERE delete_no = 0 and scrap_no = 0 </script>")
    List<MapVo> findAllSuitByXiaLa();

    //    查询班组下拉框
    @Select(value = "<script>SELECT id as MapKey,team_name as MapValue FROM t_team WHERE delete_no = 0 and state = 0 </script>")
    List<MapVo> findAllTTeamByXiaLa();


    //计划单-关联销售订单-查询所有销售订单
    @Select(value = "<script>SELECT ts.id as MapKey,ts.sale_order as MapValue,\n" +
            "sc.customer_name as MapValue2\n" +
            "FROM t_saleorder ts\n" +
            "LEFT JOIN s_customer sc ON sc.id = ts.customer_id\n" +
            "WHERE ts.delete_no = 0 and ts.order_state_id = 3 \n" +
            "<if test='name != null'>and ts.sale_order LIKE CONCAT('%', #{name},'%')</if>\n" +
            "ORDER BY ts.id DESC"+
            "</script>")
    List<MapVo> findAllSaleByPP(@Param("name")String name);


    //查询生产计划单
    @Select(value = "<script>SELECT pp.id as id,pp.pp_name as ppName,pp.relation_no as relationNo,\n" +
            "pp.pp_number as ppNumber,pp.create_time as createTime,pp.finished_time as finishedTime,\n" +
            "IFNULL(ts.sale_order,\"无\") as SaleOrder,\n" +
            "(CASE WHEN pp.pp_plan_state = 0 THEN \"未提交\"\n" +
            "WHEN pp.pp_plan_state = 1 THEN \"未审核\"\n" +
            "WHEN pp.pp_plan_state = 2 THEN \"审核中\"\n" +
            "WHEN pp.pp_plan_state = 3 THEN \"已通过\" END)as ppstate\n" +
            "FROM product_plan pp\n" +
            "LEFT JOIN t_saleorder ts ON ts.id = pp.sale_id\n" +
            "WHERE pp.delete_no = 0\n"+
            "<if test='name != null'>AND pp.pp_number LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='beginfindDate != null and endfindDate != null'>AND pp.create_time BETWEEN #{beginfindDate} AND #{endfindDate}</if>\n"+
            "ORDER BY pp.id DESC\n" +
            "LIMIT #{pageNum},#{pageSize}</script>")
    List<PPVo> findAllProductPlan(@Param("name")String name,@Param("beginfindDate")String beginfindDate,@Param("endfindDate")String endfindDate,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);


    //查询生产计划单-总数
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM product_plan pp\n" +
            "LEFT JOIN t_saleorder ts ON ts.id = pp.sale_id\n" +
            "WHERE pp.delete_no = 0\n"+
            "<if test='name != null'>AND pp.pp_number LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='beginfindDate != null and endfindDate != null'>AND pp.create_time BETWEEN #{beginfindDate} AND #{endfindDate}</if>\n"+
            "ORDER BY pp.id DESC\n" +
            "</script>")
    Integer countByAllProductPlan(@Param("name")String name,@Param("beginfindDate")String beginfindDate,@Param("endfindDate")String endfindDate);


    //生产计划单-根据生产计划单Id查询销售订单明细信息
    @Select(value = "<script>SELECT ts.id as id,ts.sale_order as saleOrder,ts.order_state_id as orderStateId,\n" +
            "ts.finished_time as finishedTime,ts.create_time as createTime,ts.customer_id as customerId,\n" +
            "sd.`name` as payType,sc.customer_name as customer,sc.customer_number as customerNumber,\n" +
            "sc.contacts_phone as contactsPhone,sc.contacts_man as contactsMan,sc.contacts_post as contactsPost\n" +
            "FROM t_saleorder ts\n" +
            "LEFT JOIN s_customer sc ON sc.id = ts.customer_id\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = ts.pay_type\n" +
            "WHERE ts.id =#{deId} </script>")
    SaleVo findSaleDetailByPPId(@Param("deId")Integer deId);

    //生产计划单-根据生产计划单Id查询工序排班
    @Select(value = "<script>SELECT pp.id as id,pp.gx_id as gxId,  sd.`name` as gxName," +
            "tt.team_name as tteamName,pp.tteam_id as tteamId, pp.frequency as frequency,\n" +
            "(CASE WHEN pp.frequency = 1 THEN \"白班\"\n" +
            "WHEN pp.frequency = 2 THEN \"夜班\" END)as frequencystr\n" +
            "FROM pp_scheduling pp\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = pp.gx_id\n" +
            "LEFT JOIN t_team tt ON tt.id = pp.tteam_id\n" +
            "WHERE pp.pp_id =#{deId} </script>")
    List<GXScheduling> findPPGXSchedulingByPPId(@Param("deId")Integer deId);

    //生产计划单-根据生产计划单Id查询生产产物-不关联销售订单
    @Select(value = "<script>SELECT pp.id,pp.length as length," +
            "pp.quantum as quantum,(pp.length*pp.quantum) as sumMI,\n" +
            "pr.um_start as standards,tp.product_model as productModel,pp.product_detail_id as productDetailId," +
            "tp.product_name as productName,tp.product_number as productNumber\n" +
            "FROM pp_product pp\n" +
            "LEFT JOIN t_prostandard pr ON pr.id = pp.product_detail_id\n" +
            "INNER JOIN t_product tp ON tp.id = pr.product_id\n" +
            "WHERE pp.pp_id =#{deId} </script>")
    List<PPProductVo> findNOSalePProductByPPId(@Param("deId")Integer deId);

    //生产计划单-根据生产计划单Id查询生产产物-关联销售订单
    @Select(value = "<script>SELECT pp.id,pp.length as length," +
            "pp.quantum as quantum,(pp.length*pp.quantum) as sumMI,\n" +
            "pr.um_start as standards,tp.product_model as productModel,pp.product_detail_id as productDetailId," +
            "tp.product_name as productName,tp.product_number as productNumber\n" +
            "FROM pp_product pp\n" +
            "LEFT JOIN t_saleorderdetail sd ON sd.id = pp.product_detail_id\n" +
            "LEFT JOIN t_prostandard pr ON pr.id = sd.product_id\n" +
            "LEFT JOIN t_product tp ON tp.id = pr.product_id\n" +
            "WHERE pp.pp_id =#{deId} </script>")
    List<PPProductVo> findSalePProductByPPId(@Param("deId")Integer deId);


    //生产计划单-根据生产计划单Id查询订单审核流程
    @Select(value = "<script>SELECT ap.create_time as createTime,\n" +
            "ap.audit_setting as auditSetting,ap.remark as remark,sf.staff_name as staffName\n" +
            "FROM pp_audit_pocess ap\n" +
            "LEFT JOIN s_staff sf ON sf.id = ap.staff_id\n" +
            "WHERE ap.audit_order_id = #{deId} </script>")
    List<AuditPocessVo> findPPAuditListById(@Param("deId")Integer deId);

    //    查询待办事项
    @Select(value = "<script>SELECT id as id,matter_news as matterNews," +
            "create_time as createTime,type as type,order_id as orderId \n" +
            "FROM matters \n" +
            "WHERE staff_id = #{staffId} and finished_no = #{finishedNo}  " +
            "<if test='readNo != null'>AND read_no = #{readNo}</if>\n"+
            "<if test='name != null'>AND matter_news LIKE CONCAT('%', #{name},'%')</if>\n"+
            "ORDER BY id DESC\n" +
            "<if test='pageNum != null and pageSize != null'> LIMIT #{pageNum},#{pageSize}</if></script>")
    List<Matters> findAllMatters(@Param("name")String name, @Param("staffId")Integer staffId, @Param("finishedNo")Integer finishedNo, @Param("readNo")Integer readNo, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    //    查询待办事项-总数
    @Select(value = "<script>SELECT count(1) \n" +
            "FROM matters \n" +
            "WHERE staff_id = #{staffId} and finished_no = #{finishedNo}  " +
            "<if test='readNo != null'>AND read_no = #{readNo}</if>\n"+
            "<if test='name != null'>AND matter_news LIKE CONCAT('%', #{name},'%')</if>\n"+
            "</script>")
    Integer countByAllMatters(@Param("name")String name, @Param("staffId")Integer staffId, @Param("finishedNo")Integer finishedNo, @Param("readNo")Integer readNo);

}
