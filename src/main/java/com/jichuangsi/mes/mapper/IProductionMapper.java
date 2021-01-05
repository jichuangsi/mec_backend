package com.jichuangsi.mes.mapper;

import com.jichuangsi.mes.entity.GXScheduling;
import com.jichuangsi.mes.entity.PPPProducts0;
import com.jichuangsi.mes.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

@Mapper
public interface IProductionMapper {
//    不关联销售订单的产物明细
    @Select(value = "<script>SELECT ppp.id as id,tp.product_model as productModel,tp.product_name as productName,tp.product_number as productNumber, tpr.um_start as standards,sd.`name` as ppUnit,ppp.quantum as quantum\n" +
            "FROM pp_product ppp \n" +
            "LEFT JOIN t_prostandard tpr ON tpr.id = ppp.product_detail_id \n" +
            "LEFT JOIN t_product tp ON tp.id = tpr.product_id \n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = tp.product_unit_id\n" +
            "WHERE ppp.pp_id = #{deId}" +
            "</script>")
    List<PPProductVo> findNoSaleMeltingInfoById(@Param("deId")Integer deId);

//    关联销售订单的产物明细
    @Select(value = "<script>SELECT ppp.id as id,tp.product_model as productModel,tp.product_name as productName,tp.product_number as productNumber, tpr.um_start as standards,sd.`name` as ppUnit,ppp.quantum as quantum,sc.customer_name as customerName\n" +
            "FROM pp_product ppp \n" +
            "LEFT JOIN t_saleorderdetail tsd ON tsd.id = ppp.product_detail_id\n" +
            "LEFT JOIN t_saleorder ts ON ts.id = tsd.saleorder_id\n" +
            "LEFT JOIN t_prostandard tpr ON tpr.id = tsd.product_id\n" +
            "LEFT JOIN t_product tp ON tp.id = tpr.product_id \n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = tp.product_unit_id \n" +
            "LEFT JOIN s_customer sc ON sc.id = ts.customer_id\n" +
            "WHERE ppp.pp_id = #{deId}" +
            "</script>")
    List<PPProductVo> findSaleMeltingInfoById(@Param("deId")Integer deId);

    @Select(value = "<script>SELECT raw.ratiostart as ratiostart,\n" +
            "raw.ratioend as ratioend,\n" +
            "sd.`name` as stockName\n" +
            "FROM rawmaterial_ratio raw\n" +
            "LEFT JOIN t_product tp ON tp.id = raw.product_id\n" +
            "LEFT JOIN t_prostandard tr ON tr.product_id = tp.id\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = raw.stock_id\n" +
            "WHERE tr.id = #{deId}" +
            "</script>")
    List<RawMaterialRatioVo> findRawMaterialRatioById(@Param("deId")Integer deId);

    //    关联销售订单的基本信息
    @Select(value = "<script>SELECT ppp.id as id,pp.pp_number as ppNumber," +
            "pp.create_time as createTime,pp.finished_time as finishedTime,\n" +
            "sc.customer_name as customerName,\n" +
            "tp.product_model as productModel,tp.product_name as productName,\n" +
            "tp.product_number as productNumber,\n" +
            "ppp.quantum as quantum,ppp.length as length,(ppp.quantum * ppp.length) as planNum,0 as finishNum,\n" +
            "xz.`name` as bobbinName,sd.`name` as beginName,md.`name` as endName,\n" +
            "tpr.um_start as umStart,tpr.mil_start as milStart,\n" +
            "tpr.el_start as elStart,tpr.el_end as elEnd,tpr.bl_start as blStart,tpr.bl_eend as blEend\n" +
            "FROM pp_product ppp\n" +
            "LEFT JOIN product_plan pp ON pp.id = ppp.pp_id \n" +
            "LEFT JOIN t_saleorderdetail ts ON ts.id = ppp.product_detail_id \n" +
            "LEFT JOIN t_saleorder tsa ON tsa.id = ts.saleorder_id \n" +
            "LEFT JOIN t_prostandard tpr ON tpr.id = ts.product_id \n" +
            "LEFT JOIN t_product tp ON tp.id = tpr.product_id \n" +
            "LEFT JOIN s_dictionarier xz ON xz.id = tp.bobbin_id \n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = tp.begin_id \n" +
            "LEFT JOIN s_dictionarier md ON sd.id = tp.end_id \n" +
            "LEFT JOIN s_customer sc ON sc.id = tsa.customer_id\n" +
            "WHERE ppp.id = #{deId}" +
            "</script>")
    PPProductionVo findMeltingBasicInfoById(@Param("deId")Integer deId);

    //    不关联销售订单的基本信息
    @Select(value = "<script>SELECT ppp.id as id,pp.pp_number as ppNumber," +
            "pp.create_time as createTime,pp.finished_time as finishedTime,\n" +
            "tp.product_model as productModel,tp.product_name as productName,\n" +
            "tp.product_number as productNumber,\n" +
            "ppp.quantum as quantum,ppp.length as length,(ppp.quantum * ppp.length) as planNum,0 as finishNum,\n" +
            "xz.`name` as bobbinName,sd.`name` as beginName,md.`name` as endName,\n" +
            "tpr.um_start as umStart,tpr.mil_start as milStart,\n" +
            "tpr.el_start as elStart,tpr.el_end as elEnd,tpr.bl_start as blStart,tpr.bl_eend as blEend\n" +
            "FROM pp_product ppp\n" +
            "LEFT JOIN product_plan pp ON pp.id = ppp.pp_id \n" +
            "LEFT JOIN t_prostandard tpr ON tpr.id = ppp.product_detail_id \n" +
            "LEFT JOIN t_product tp ON tp.id = tpr.product_id \n" +
            "LEFT JOIN s_dictionarier xz ON xz.id = tp.bobbin_id \n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = tp.begin_id \n" +
            "LEFT JOIN s_dictionarier md ON sd.id = tp.end_id\n" +
            "WHERE ppp.id = #{deId}" +
            "</script>")
    PPProductionVo findMeltingBasicInfoByNoSaleId(@Param("deId")Integer deId);


    //熔炼-设备信息（根据设备id显示设备信息）
    @Select(value = "<script>SELECT ps.tteam_id as tteamId,ps.frequency as frequency,sf.staff_name as staffName," +
            "sf.staff_num as staffNumber,tt.team_name as tteamName,sf.id as staffId,\n" +
            "(CASE WHEN ps.frequency = 1 THEN \"白班\"\n" +
            "WHEN ps.frequency = 2 THEN \"夜班\" END)as frequencystr\n" +
            "FROM pp_scheduling ps\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = ps.gx_id\n" +
            "LEFT JOIN t_team tt ON tt.id = ps.tteam_id\n" +
            "LEFT JOIN s_staff sf ON sf.id = #{staffId}\n" +
            "WHERE pp_id = #{ppId} AND gx_id =#{gxId} </script>")
    GXScheduling findGXSchedulingByPPIdAndGXIdAndSfId(@Param("ppId")Integer ppId,@Param("gxId")Integer gxId,@Param("staffId")Integer staffId);

    //熔炼-设备信息（根据设备id显示设备信息）
    @Select(value = "<script>SELECT te.id as id,te.equipment_number as equipmentNumber,te.state as state,\n" +
            "ttq.create_time as checkTime,ttq.staff_name as checkStaffName,ttq.staff_id,0 as runNumber,sd.`name` as equipmentType\n" +
            "FROM t_equipment te\n" +
            "LEFT JOIN (\n" +
            "SELECT tq.equipment_id, tq.staff_id,tq.create_time,sf.staff_name FROM t_equipmentcheckrecord tq  \n" +
            "LEFT JOIN s_staff sf ON sf.id = tq.staff_id\n" +
            "WHERE tq.equipment_id = #{deId}\n" +
            " ORDER BY tq.create_time DESC LIMIT 1\n" +
            ") as ttq ON ttq.equipment_id = te.id\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = te.equipment_type_id\n" +
            "WHERE te.id = #{deId} </script>")
    EquipmentVo findEquipmentByEquipmentId(@Param("deId")Integer deId);


    //查询生产表
    @Select(value = "<script>SELECT ppp.id as id,ppp.create_time as createTime,\n" +
            "pp.pp_number as ppNumber, ppp.production_number as productionNumber,\n" +
            "ppp.gx_name as GXName,tt.team_name as teamName,\n" +
            "(CASE WHEN ppp.state = 0 THEN \"未完成\"\n" +
            "ELSE \"已完成\" END) as statestr,\n" +
            "(CASE WHEN ppp.frequency = 1 THEN \"白班\"\n" +
            "WHEN ppp.frequency = 2 THEN \"夜班\" END) as frequencystr," +
            "ppp.delete_no as deleteNo\n" +
            "FROM pp_production ppp\n" +
            "LEFT JOIN pp_product pr ON pr.id = ppp.pproduct_id\n" +
            "LEFT JOIN product_plan pp ON pp.id = pr.pp_id\n" +
//            "LEFT JOIN s_dictionarier sd ON sd.id = ppp.gxid\n" +
            "LEFT JOIN t_team tt ON tt.id = ppp.team_id\n" +
            "WHERE ppp.delete_no = 0 and ppp.gxid = #{deId}\n"+
            "<if test='deIdnew != 0'>or ppp.gxid = #{deIdnew}</if>\n"+
            "<if test='name != null'>AND pp.pp_number LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='pname != null'>AND ppp.production_number LIKE CONCAT('%', #{pname},'%')</if>\n"+
            "<if test='beginfindDate != null and endfindDate != null'>AND ppp.create_time BETWEEN #{beginfindDate} AND #{endfindDate}</if>\n"+
            "ORDER BY ppp.id DESC\n" +
            "LIMIT #{pageNum},#{pageSize}</script>")
    List<PPPVo> findAllPPProduction(@Param("deId")Integer deId,@Param("deIdnew")Integer deIdnew,@Param("name")String name,@Param("pname")String pname,@Param("beginfindDate")String beginfindDate,@Param("endfindDate")String endfindDate,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    //查询生产表-统计数量
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM pp_production ppp\n" +
            "LEFT JOIN pp_product pr ON pr.id = ppp.pproduct_id\n" +
            "LEFT JOIN product_plan pp ON pp.id = pr.pp_id\n" +
            "LEFT JOIN t_team tt ON tt.id = ppp.team_id\n" +
            "WHERE ppp.delete_no = 0 and ppp.gxid = #{deId}\n"+
            "<if test='deIdnew != 0'>or ppp.gxid = #{deIdnew}</if>\n"+
            "<if test='name != null'>AND pp.pp_number LIKE CONCAT('%', #{name},'%')</if>\n"+
            "<if test='pname != null'>AND ppp.production_number LIKE CONCAT('%', #{pname},'%')</if>\n"+
            "<if test='beginfindDate != null and endfindDate != null'>AND ppp.create_time BETWEEN #{beginfindDate} AND #{endfindDate}</if>\n"+
            "ORDER BY ppp.id DESC\n" +
            "</script>")
    Integer countByPPProduction(@Param("deId")Integer deId,@Param("deIdnew")Integer deIdnew,@Param("name")String name,@Param("pname")String pname,@Param("beginfindDate")String beginfindDate,@Param("endfindDate")String endfindDate);

    //熔炼-回填-查询要生产的原材料
    @Select(value = "<script>SELECT ps.id as id,ps.pppid as PPPId,ps.inventory_status_id as inventoryStatusId,\n" +
            "ps.quantity_choose as quantityChoose,ps.total_net as totalNet,sd.`name` as unitName,\n" +
            "st.standards as standards,ts.stock_name as stockName,ts.stock_model as stockModel,ts.stock_number as stockNumber\n" +
            "FROM production_stock ps\n" +
            "LEFT JOIN inventory_status ns ON ns.id = ps.inventory_status_id\n" +
            "LEFT JOIN t_standards st ON st.id = ns.product_id\n" +
            "LEFT JOIN t_stock ts ON ts.id = st.material_id\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id =ts.dictionarier_id\n" +
            "WHERE ps.delete_no = 0 AND ps.pppid = #{deId}" +
            "</script>")
    List<ProductionStockVo> findSmeltingStocksByPPPId(@Param("deId")Integer deId);


    //工序-回填-查询产物(上班/本班)  sd.`name` as gxName,
    @Select(value = "<script>SELECT pp.id as id,pp.gx_id as gxId,\n" +
            "pp.create_time as createTime,pp.bobbin_detail_id as bobbinDetailId,tb.bobbin_name as bobbinName,ts.standards as standards,\n" +
            "pp.wire_diameter_um as wireDiameterUm,pp.lengthm as lengthM," +
            "pp.gross_weight as grossWeight,pp.net_weightg as netWeightg,\n" +
            "pp.wastageg as wastageg,pp.lossg as lossg," +
            "pp.slip as Slip,pp.traction_speed as tractionSpeed," +
            "pp.take_up_speed as takeUpSpeed,pp.numbers as numbers,\n" +
            "pp.surface as surface,pp.paying_off as payingOff," +
            "pp.total_length as totalLength,\n" +
            "pp.net_weightg_sum as netWeightgSum,pp.delete_no as deleteNo,\n" +
            "pw.straight_line as straightLine\n" +
            "FROM ppp_products#{id} pp\n" +
            "LEFT JOIN ppp_winding_info pw ON pw.ppppid = pp.id\n" +
//            "LEFT JOIN s_dictionarier sd ON sd.id = pp.gx_id\n" +
            "LEFT JOIN t_standards ts ON ts.id = pp.bobbin_detail_id\n" +
            "LEFT JOIN t_bobbin tb ON tb.id = ts.material_id\n" +
            "WHERE pp.pppid = #{deId} AND pp.delete_no = 0 " +
            "</script>")
    List<ProductsVo> findProductsVoByPPPId(@Param("deId")Integer deId,@Param("id")Integer id);


    //绕线-回填-查询产物(上班/本班)  sd.`name` as gxName,
    @Select(value = "<script>SELECT pp.id as id,pp.gx_id as gxId, pp.create_time as createTime,\n" +
            "pp.bobbin_detail_id as bobbinDetailId,tb.bobbin_name as bobbinName,\n" +
            "ts.standards as standards, pp.wire_diameter_um as wireDiameterUm,\n" +
            "pp.lengthm as lengthM,pp.gross_weight as grossWeight,\n" +
            "pp.net_weightg as netWeightg,\n" +
            "pp.numbers as numbers,\n" +
            "pp.total_length as totalLength, \n" +
            "pp.net_weightg_sum as netWeightgSum,pp.delete_no as deleteNo, \n" +
            "pw.straight_line as straightLine,pw.surface as surface,\n" +
            "pw.setting_out as payingOff,pw.flat_cable as flatCable\n" +
            "FROM ppp_products#{id} pp\n" +
            "LEFT JOIN ppp_winding_info pw ON pw.ppppid = pp.fid\n" +
            "LEFT JOIN t_standards ts ON ts.id = pp.bobbin_detail_id\n" +
            "LEFT JOIN t_bobbin tb ON tb.id = ts.material_id\n" +
            "WHERE pp.pppid = #{deId} AND pp.delete_no = 0 " +
            "</script>")
    List<ProductsVo> findProductsVoByPPPId2(@Param("deId")Integer deId,@Param("id")Integer id);

    //绕线-回填-根据产物查询产物(上班/本班)  sd.`name` as gxName,
    @Select(value = "<script>SELECT pp.id as id,pp.gx_id as gxId, pp.create_time as createTime,\n" +
            "pp.bobbin_detail_id as bobbinDetailId,tb.bobbin_name as bobbinName,\n" +
            "ts.standards as standards, pp.wire_diameter_um as wireDiameterUm,\n" +
            "pp.lengthm as lengthM,pp.gross_weight as grossWeight,\n" +
            "pp.net_weightg as netWeightg,\n" +
            "pp.numbers as numbers,\n" +
            "pp.total_length as totalLength, \n" +
            "pp.net_weightg_sum as netWeightgSum,pp.delete_no as deleteNo, \n" +
            "pw.straight_line as straightLine,pw.surface as surface,\n" +
            "pw.setting_out as payingOff,pw.flat_cable as flatCable\n" +
            "FROM ppp_products#{id} pp\n" +
            "LEFT JOIN ppp_winding_info pw ON pw.ppppid = pp.fid\n" +
            "LEFT JOIN t_standards ts ON ts.id = pp.bobbin_detail_id\n" +
            "LEFT JOIN t_bobbin tb ON tb.id = ts.material_id\n" +
            "WHERE pp.id = #{deId} AND pp.delete_no = 0 " +
            "</script>")
    ProductsVo findProductsVoById(@Param("deId")Integer deId,@Param("id")Integer id);


    //工序-新增产物成功后查询自增的id
    @Select(value = "<script>SELECT id as id,net_weightg as netWeightg,wastageg as wastageg\n" +
            "FROM ppp_products#{id} pp\n" +
            "WHERE pp.pppid = #{deId} AND pp.delete_no = 0 " +
            "</script>")
    List<PPPProducts0> findProductsIdByPPPId(@Param("deId")Integer deId,@Param("id")Integer id);

    @Transactional
    @Modifying
    @Select(value = "<script>INSERT INTO ppp_products#{id}(pppid,slip,bobbin_detail_id,create_time,delete_no,gross_weight,gx_id,lengthm,lossg,net_weightg,net_weightg_sum," +
            "paying_off,straight_line,surface,take_up_speed,total_length,traction_speed,wastageg,wire_diameter_um,numbers,flat_cable,tension,oddmentsG,state,fid) values \n" +
            "<foreach collection='list' item='item' separator=','>"+
//            "(<if test=\"item.id != null\">#{item.id},</if>"+
            " (<if test=\"item.PPPId != null\">#{item.PPPId},</if>"+
            " #{item.Slip},"+
            " #{item.bobbinDetailId},"+
            " NOW(),"+
            " 0,"+
            " #{item.grossWeight},"+
            " #{item.gxId},"+
            " #{item.lengthM},"+
            " #{item.lossg},"+
            " #{item.netWeightg},"+
            " #{item.netWeightgSum},"+
            " #{item.payingOff},"+
            " #{item.straightLine},"+
            " #{item.surface},"+
            " #{item.takeUpSpeed},"+
            " #{item.totalLength},"+
            " #{item.tractionSpeed},"+
            " #{item.wastageg},"+
            " #{item.wireDiameterUm}," +

            " #{item.numbers},"+
            " #{item.flatCable},"+
            " #{item.tension},"+
            " #{item.oddmentsG},"+
            " #{item.state},"+
            " #{item.Fid}"+
            ")"+
            "</foreach>" +
            "ON DUPLICATE KEY UPDATE\n" +
            "id = values(id),pppid = values(pppid),slip = values(slip),bobbin_detail_id = values(bobbin_detail_id)," +
            "create_time = NOW(),delete_no = 0," +
            "gross_weight = values(gross_weight),gx_id = values(gx_id),lengthm = values(lengthm),lossg = values(lossg)," +
            "net_weightg = values(net_weightg),net_weightg_sum = values(net_weightg_sum)," +
            "paying_off = values(paying_off),straight_line = values(straight_line),surface = values(surface),take_up_speed = values(take_up_speed)," +
            "total_length = values(total_length),traction_speed = values(traction_speed),wastageg = values(wastageg),wire_diameter_um = values(wire_diameter_um)," +
            "numbers = values(numbers),flat_cable = values(flat_cable),tension = values(tension),oddmentsg = values(oddmentsg),state = values(state),fid = values(fid)" +
            "</script>")
    void insertPPPProducts(@Param("list")List<PPPProducts0> pppProducts0List,@Param("id")Integer id);

    //更改产物list状态
    @Transactional
    @Modifying
    @Select(value = "<script>" +
            "UPDATE ppp_products#{id} SET delete_no = 1 AND pppid = #{deId}"+
            "</script>")
    void UpdatePPPProductsByPPPId(@Param("id")Integer id,@Param("deId")Integer deId);

    //退火-同批次生产-根据生产批次跟工序 查询生产表
    @Select(value = "<script>SELECT ppp.id as id,ppp.create_time as createTime,  ppp.gx_name as GXName," +
            "tt.team_name as teamName, (CASE WHEN ppp.frequency = 1 THEN \"白班\" WHEN ppp.frequency = 2 THEN \"夜班\" END) as frequencystr \n" +
            "FROM pp_production ppp \n" +
            "LEFT JOIN pp_product pr ON pr.id = ppp.pproduct_id \n" +
            "LEFT JOIN product_plan pp ON pp.id = pr.pp_id \n" +
            "LEFT JOIN t_team tt ON tt.id = ppp.team_id \n" +
            "WHERE ppp.delete_no = 0 and ppp.state != 0 and ppp.gxid = #{deId}  \n" +
            "AND ppp.production_number = #{name}\n" +
            "ORDER BY ppp.id DESC </script>")
    List<PPPVo> findAllPPProductionByProductionNumber(@Param("deId")Integer deId,@Param("name")String name);


    //查询-根据产物id查询详情
    @Select(value = "<script>" +
            "SELECT pp.id as id,pp.pppid as PPPId,pp.slip as Slip,pp.create_time as createTime," +
            "ts.standards,tb.bobbin_name,pp.wire_diameter_um as wireDiameterUm, " +
            "pp.lengthm as lengthM,pp.gross_weight as grossWeight,pp.net_weightg as netWeightg," +
            "pp.surface as surface,pp.paying_off as payingOff,pp.straight_line as straightLine," +
            "pp.numbers as numbers\n" +
            "FROM  ppp_products#{id} pp\n" +
            "LEFT JOIN t_standards ts ON ts.id = pp.bobbin_detail_id\n" +
            "LEFT JOIN t_bobbin tb ON tb.id = ts.material_id\n" +
            "WHERE pp.id = #{deId}"+
            "</script>")
    ProductsVo findBypppProducts(@Param("id")Integer id,@Param("deId")Integer deId);

    //绕线/改绕工序-回填-查询产物(上班/本班)  sd.`name` as gxName,
    @Select(value = "<script>SELECT pp.id as id,pp.gx_id as gxId,\n" +
            "pp.create_time as createTime,pp.bobbin_detail_id as bobbinDetailId,tb.bobbin_name as bobbinName,ts.standards as standards,\n" +
            "pp.wire_diameter_um as wireDiameterUm,pp.lengthm as lengthM," +
            "pp.gross_weight as grossWeight,pp.net_weightg as netWeightg,\n" +
            "pp.wastageg as wastageg,pp.lossg as lossg," +
            "pp.slip as Slip,pp.traction_speed as tractionSpeed," +
            "pp.take_up_speed as takeUpSpeed,pp.numbers as numbers,\n" +
            "pp.surface as surface,pp.paying_off as payingOff," +
            "pp.total_length as totalLength,\n" +
            "pp.net_weightg_sum as netWeightgSum,pp.delete_no as deleteNo,pw.straight_line as straightLine\n" +
            "FROM ppp_products#{id} pp\n" +
            "LEFT JOIN ppp_winding_info pw ON pw.ppppid = pp.id\n" +
            "LEFT JOIN t_standards ts ON ts.id = pp.bobbin_detail_id\n" +
            "LEFT JOIN t_bobbin tb ON tb.id = ts.material_id\n" +
            "WHERE pp.fid = #{deId} AND pp.delete_no = 0 " +
            "</script>")
    List<ProductsVo> findPWindingProductsVoByPPPPId(@Param("deId")Integer deId,@Param("id")Integer id);

    // 新增产物：查询 关联销售订单的基本信息
    @Select(value = "<script>SELECT tp.product_model as stockModel,tp.product_name as stockName,\n" +
            "tp.product_number as stockNumber,tp.product_unit_id as unitId, tpr.um_start as standards\n" +
            "FROM pp_product ppp\n" +
            "LEFT JOIN product_plan pp ON pp.id = ppp.pp_id \n" +
            "LEFT JOIN t_saleorderdetail ts ON ts.id = ppp.product_detail_id \n" +
            "LEFT JOIN t_saleorder tsa ON tsa.id = ts.saleorder_id \n" +
            "LEFT JOIN t_prostandard tpr ON tpr.id = ts.product_id \n" +
            "LEFT JOIN t_product tp ON tp.id = tpr.product_id\n" +
            "WHERE ppp.id = #{deId}" +
            "</script>")
    UpdateModel findBasicInfoById(@Param("deId")Integer deId);

    //     新增产物：查询不关联销售订单的基本信息
    @Select(value = "<script>SELECT tp.product_model as stockModel,tp.product_name as stockName,\n" +
            "tp.product_number as stockNumber,tp.product_unit_id as unitId, tpr.um_start as standards\n" +
            "FROM pp_product ppp\n" +
            "LEFT JOIN product_plan pp ON pp.id = ppp.pp_id \n" +
            "LEFT JOIN t_prostandard tpr ON tpr.id = ppp.product_detail_id \n" +
            "LEFT JOIN t_product tp ON tp.id = tpr.product_id\n" +
            "WHERE ppp.id = #{deId}" +
            "</script>")
    UpdateModel findBasicInfoByNoSaleId(@Param("deId")Integer deId);

    //修改产物list状态-state
    @Transactional
    @Modifying
    @Select(value = "<script>" +
            "UPDATE ppp_products#{id} SET state = 1 , delete_no = 1  WHERE fid = #{deId} AND pppid = #{pppid} "+
            "</script>")
    void UpdatePPPProductsDetailByfid(@Param("id")Integer id,@Param("deId")Integer deId,@Param("pppid")Integer pppid);


    //    改绕--查询改绕的信息
    @Select(value = "<script>SELECT ins.ppp_id as id,ins.stock_model as productModel, ppp.production_number as ppNumber\n" +
            "FROM inventory_status ins\n" +
            "LEFT JOIN pp_production ppp ON ppp.id = ins.ppp_id\n" +
            "WHERE inventory_type =2\n" +
            "GROUP BY ppp_id</script>")
    List<PPProductionVo> findAllFinished();





//    ===========生产数据===============
    //    生产数据--批号回溯-根据生产批号查询生产工序
    @Select(value = "<script>SELECT id as MapKey,gx_name as MapValue," +
            "(CASE gxid\n" +
            "\tWHEN 38 THEN 1\n" +
            "\tWHEN 39 THEN 2\n" +
            "\tWHEN 40 THEN 3\n" +
            "\tWHEN 41 THEN 4\n" +
            "\tWHEN 42 THEN 5\n" +
            "\tWHEN 43 THEN 6\n" +
            "\tWHEN 90 THEN 7\n" +
            "\tWHEN 68 THEN 8\n" +
            "\tWHEN 70 THEN 9\n" +
            "END) as MapValue2 \n" +
            "FROM pp_production\n" +
            "WHERE pp_production.production_number = #{name}</script>")
    List<MapVo> findAllProductionInfoByNumber(@Param("name")String name);



}
