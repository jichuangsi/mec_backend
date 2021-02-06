package com.jichuangsi.mes.mapper;

import com.jichuangsi.mes.entity.GXScheduling;
import com.jichuangsi.mes.entity.PPPProducts0;
import com.jichuangsi.mes.entity.ProductionDiaryReport;
import com.jichuangsi.mes.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Mapper
public interface IProductionMapper {

    //    根据工序查询对应线轴下拉框
    @Select(value = "<script>SELECT id as MapKey,bobbin_number as MapValue,bobbin_name as MapValue2\n" +
            "FROM t_bobbin WHERE delete_no = 0 and state = 0 and procedure_id LIKE CONCAT('%', #{gxId},'%') </script>")
    List<MapVo> findXiaLaBobbinBygxId(@Param("gxId")Integer gxId);

    //    查询设备下拉框(因为设备是多选，所以用了根据工序id模糊查询设备)
    @Select(value = "<script>SELECT id as MapKey,equipment_number as MapValue,equipment_name as MapValue2  FROM t_equipment " +
            "WHERE delete_no = 0 and state = 0 and equipment_type_id LIKE CONCAT('%', #{gxId},'%') </script>")
    List<MapVo> findXiaLaEquipmentBygxId(@Param("gxId")Integer gxId);

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

//    不关联销售订单时的原料配比信息
    @Select(value = "<script>SELECT raw.ratiostart as ratiostart,\n" +
            "raw.ratioend as ratioend,\n" +
            "sd.`name` as stockName\n" +
            "FROM rawmaterial_ratio raw\n" +
            "LEFT JOIN t_product tp ON tp.id = raw.product_id\n" +
            "LEFT JOIN t_prostandard tr ON tr.product_id = tp.id\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = raw.stock_id\n" +
            "WHERE tr.id = #{deId}" +
            "</script>")
    List<RawMaterialRatioVo> findRawMaterialRatioByNoSaleId(@Param("deId")Integer deId);

    //    关联销售订单时的原料配比信息
    @Select(value = "<script>SELECT raw.ratiostart as ratiostart, raw.ratioend as ratioend, sd.`name` as stockName \n" +
            "FROM t_saleorderdetail ts \n" +
            "LEFT JOIN rawmaterial_ratio raw ON raw.product_id = ts.product_id\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = raw.stock_id\n" +
            "WHERE ts.id = #{deId}" +
            "</script>")
    List<RawMaterialRatioVo> findRawMaterialRatioBySaleId(@Param("deId")Integer deId);

    //    关联销售订单的基本信息
    @Select(value = "<script>SELECT ppp.id as id,pp.pp_number as ppNumber," +
            "pp.create_time as createTime,pp.finished_time as finishedTime,\n" +
            "sc.customer_name as customerName,\n" +
            "tp.product_model as productModel,tp.product_name as productName,\n" +
            "tp.product_number as productNumber,\n" +
            "ppp.quantum as quantum,ppp.length as length,(ppp.quantum * ppp.length) as planNum,0 as finishNum,\n" +
            "xz.`name` as bobbinName,sd.`name` as beginName,md.`name` as endName,dw.`name` as productUnit,\n" +
            "tpr.um_start as umStart,tpr.mil_start as milStart,\n" +
            "tpr.el_start as elStart,tpr.el_end as elEnd,tpr.bl_start as blStart,tpr.bl_eend as blEend\n" +
            "FROM pp_product ppp\n" +
            "LEFT JOIN product_plan pp ON pp.id = ppp.pp_id \n" +
            "LEFT JOIN t_saleorderdetail ts ON ts.id = ppp.product_detail_id \n" +
            "LEFT JOIN t_saleorder tsa ON tsa.id = ts.saleorder_id \n" +
            "LEFT JOIN t_prostandard tpr ON tpr.id = ts.product_id \n" +
            "LEFT JOIN t_product tp ON tp.id = tpr.product_id \n" +
            "LEFT JOIN s_dictionarier dw ON dw.id = tp.product_unit_id \n" +
            "LEFT JOIN s_dictionarier xz ON xz.id = tp.bobbin_id \n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = tp.begin_id \n" +
            "LEFT JOIN s_dictionarier md ON md.id = tp.end_id \n" +
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
            "xz.`name` as bobbinName,sd.`name` as beginName,md.`name` as endName,dw.`name` as productUnit,\n" +
            "tpr.um_start as umStart,tpr.mil_start as milStart,\n" +
            "tpr.el_start as elStart,tpr.el_end as elEnd,tpr.bl_start as blStart,tpr.bl_eend as blEend\n" +
            "FROM pp_product ppp\n" +
            "LEFT JOIN product_plan pp ON pp.id = ppp.pp_id \n" +
            "LEFT JOIN t_prostandard tpr ON tpr.id = ppp.product_detail_id \n" +
            "LEFT JOIN t_product tp ON tp.id = tpr.product_id \n" +
            "LEFT JOIN s_dictionarier dw ON dw.id = tp.product_unit_id \n" +
            "LEFT JOIN s_dictionarier xz ON xz.id = tp.bobbin_id \n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = tp.begin_id \n" +
            "LEFT JOIN s_dictionarier md ON md.id = tp.end_id\n" +
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
//            "LEFT JOIN s_dictionarier sd ON sd.id = ppp.gxid\n" +   and ppp.state != -1
            "LEFT JOIN t_team tt ON tt.id = ppp.team_id\n" +
            "WHERE ppp.delete_no = 0  and ppp.gxid = #{deId}\n"+
            "<if test='deIdnew != 0'> or  ppp.delete_no = 0 and ppp.gxid = #{deIdnew}</if>\n"+
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


    //工序-回填-根据该生产id查询上班有联系绑定的产物
    @Select(value = "<script>SELECT pp.id as id,pp.gx_id as gxId,\n" +
            "pp.create_time as createTime,pp.bobbin_detail_id as bobbinDetailId,tb.bobbin_name as bobbinName,ts.standards as standards,\n" +
            "pp.wire_diameter_um as wireDiameterUm,pp.lengthm as lengthM," +
            "pp.gross_weight as grossWeight,pp.net_weightg as netWeightg,\n" +
            "pp.wastageg as wastageg,pp.lossg as lossg," +
            "pp.slip as Slip,pp.traction_speed as tractionSpeed," +
            "pp.take_up_speed as takeUpSpeed,pp.numbers as numbers,\n" +
            "pp.surface as surface,pp.paying_off as payingOff," +
            "pp.total_length as totalLength,\n" +
            "pp.axle_number as axleNumber,pp.axleload_weight as axleloadWeight,\n" +
            "pp.net_weightg_sum as netWeightgSum,pp.delete_no as deleteNo," +
            "pp.straight_line as straightLine,\n" +

            "pw.bobbin_color as bobbinColor\n" +
            "FROM ppp_products#{id} pp\n" +
            "LEFT JOIN ppp_winding_info pw ON pw.ppppid = pp.fid\n" +
            "LEFT JOIN t_standards ts ON ts.id = pp.bobbin_detail_id\n" +
            "LEFT JOIN t_bobbin tb ON tb.id = ts.material_id\n" +
            "WHERE pp.pppid = #{deId} and  pp.lppid = #{dId} AND pp.delete_no = 0 " +
            "</script>")
    List<ProductsVo> findProductsVoByLPPId(@Param("deId")Integer deId,@Param("dId")Integer dId,@Param("id")Integer id);

    //工序-回填-查询产物(上班/本班)  sd.`name` as gxName,
    @Select(value = "<script>SELECT pp.id as id,pp.gx_id as gxId,\n" +
            "pp.create_time as createTime,pp.bobbin_detail_id as bobbinDetailId,tb.bobbin_name as bobbinName,ts.standards as standards,\n" +
            "pp.wire_diameter_um as wireDiameterUm,pp.lengthm as lengthM," +
            "pp.gross_weight as grossWeight,pp.net_weightg as netWeightg,\n" +
            "pp.wastageg as wastageg,pp.lossg as lossg," +
            "pp.slip as Slip,pp.traction_speed as tractionSpeed," +
            "pp.take_up_speed as takeUpSpeed,pp.numbers as numbers,\n" +
            "pp.surface as surface,pp.paying_off as payingOff," +
            "pp.total_length as totalLength," +
            "pp.axle_number as axleNumber,pp.axleload_weight as axleloadWeight,\n" +
            "pp.net_weightg_sum as netWeightgSum,pp.delete_no as deleteNo," +
            "pp.straight_line as straightLine\n" +
//            "pw.straight_line as straightLine\n" +
            "FROM ppp_products#{id} pp\n" +
//            "LEFT JOIN ppp_winding_info pw ON pw.ppppid = pp.id\n" +
//            "LEFT JOIN s_dictionarier sd ON sd.id = pp.gx_id\n" +
            "LEFT JOIN t_standards ts ON ts.id = pp.bobbin_detail_id\n" +
            "LEFT JOIN t_bobbin tb ON tb.id = ts.material_id\n" +
            "WHERE pp.pppid = #{deId} AND pp.delete_no = 0 \n" +
            "<if test='state == 1'>AND pp.state = 0</if>\n" +
            "</script>")
    List<ProductsVo> findProductsVoByPPPId(@Param("deId")Integer deId,@Param("id")Integer id,@Param("state")Integer state);

    //绕线-回填-查询产物(上班/本班)  sd.`name` as gxName,
    @Select(value = "<script>SELECT pp.id as id,pp.gx_id as gxId, pp.create_time as createTime,\n" +
            "pp.bobbin_detail_id as bobbinDetailId,tb.bobbin_name as bobbinName,\n" +
            "ts.standards as standards, pp.wire_diameter_um as wireDiameterUm,\n" +
            "pp.lengthm as lengthM,pp.gross_weight as grossWeight,\n" +
            "pp.net_weightg as netWeightg,\n" +
            "pp.numbers as numbers,\n" +
            "pp.total_length as totalLength, \n" +
            "pp.net_weightg_sum as netWeightgSum,pp.delete_no as deleteNo, \n" +
//            "pw.straight_line as straightLine,pw.surface as surface,\n" +
            "pp.axle_number as axleNumber,pp.axleload_weight as axleloadWeight,\n" +
//            "pw.setting_out as payingOff,pw.flat_cable as flatCable,\n" +

            "pw.bobbin_color as bobbinColor\n" +
            "FROM ppp_products#{id} pp\n" +
            "LEFT JOIN ppp_winding_info pw ON pw.ppppid = pp.fid\n" +
            "LEFT JOIN t_standards ts ON ts.id = pp.bobbin_detail_id\n" +
            "LEFT JOIN t_bobbin tb ON tb.id = ts.material_id\n" +
            "WHERE pp.pppid = #{deId} AND pw.pppid = #{deId} AND pp.delete_no = 0 \n" +
            "GROUP BY pp.id" +
            "</script>")
    List<ProductsVo> findProductsVoByPPPId2(@Param("deId")Integer deId,@Param("id")Integer id);

    //绕线-回填-根据产物查询产物(上班/本班)  sd.`name` as gxName,
    @Select(value = "<script>SELECT pp.id as id,pp.gx_id as gxId, pp.create_time as createTime,\n" +
            "pp.bobbin_detail_id as bobbinDetailId,tb.bobbin_name as bobbinName,\n" +
            "ts.standards as standards, pp.wire_diameter_um as wireDiameterUm,\n" +
            "pp.lengthm as lengthM,pp.gross_weight as grossWeight,\n" +
            "pp.net_weightg as netWeightg,\n" +
            "pp.axle_number as axleNumber,pp.axleload_weight as axleloadWeight,\n" +
            "pp.numbers as numbers,\n" +
            "pp.total_length as totalLength, \n" +
            "pp.net_weightg_sum as netWeightgSum,pp.delete_no as deleteNo, \n" +
//            "pw.straight_line as straightLine,pw.surface as surface,\n" +
//            "pw.setting_out as payingOff,pw.flat_cable as flatCable\n" +
            "FROM ppp_products#{id} pp\n" +
            "LEFT JOIN ppp_winding_info pw ON pw.ppppid = pp.fid\n" +
            "LEFT JOIN t_standards ts ON ts.id = pp.bobbin_detail_id\n" +
            "LEFT JOIN t_bobbin tb ON tb.id = ts.material_id\n" +
            "WHERE pp.id = #{deId} AND pw.pppid = #{pppId} AND pp.delete_no = 0 " +
            "</script>")
    ProductsVo findProductsVoById(@Param("deId")Integer deId,@Param("pppId")Integer pppId,@Param("id")Integer id);


    //工序-新增产物成功后查询自增的id
    @Select(value = "<script>SELECT id as id,net_weightg as netWeightg,wastageg as wastageg,lossg as lossg\n" +
            "FROM ppp_products#{id} pp\n" +
            "WHERE pp.pppid = #{deId} AND pp.delete_no = 0 " +
            "</script>")
    List<PPPProducts0> findProductsIdByPPPId(@Param("deId")Integer deId,@Param("id")Integer id);

    @Transactional
    @Modifying
    @Select(value = "<script>INSERT INTO ppp_products#{id}(pppid,slip,bobbin_detail_id,create_time,delete_no,gross_weight," +
            "gx_id,lengthm,lossg,net_weightg,net_weightg_sum," +
            "paying_off,straight_line,surface,take_up_speed,total_length,traction_speed,wastageg,wire_diameter_um,numbers," +
            "flat_cable,tension,oddmentsG,state,fid,axle_number,axleload_weight) values \n" +
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
            "0,"+
            " #{item.Fid},"+
            " #{item.axleNumber},"+
            " #{item.axleloadWeight}"+
            ")"+
            "</foreach>" +
            "ON DUPLICATE KEY UPDATE\n" +
            "id = values(id),pppid = values(pppid),slip = values(slip),bobbin_detail_id = values(bobbin_detail_id)," +
            "create_time = NOW(),delete_no = 0," +
            "gross_weight = values(gross_weight),gx_id = values(gx_id),lengthm = values(lengthm),lossg = values(lossg)," +
            "net_weightg = values(net_weightg),net_weightg_sum = values(net_weightg_sum)," +
            "paying_off = values(paying_off),straight_line = values(straight_line),surface = values(surface),take_up_speed = values(take_up_speed)," +
            "total_length = values(total_length),traction_speed = values(traction_speed),wastageg = values(wastageg)," +
            "wire_diameter_um = values(wire_diameter_um)," +
            "numbers = values(numbers),flat_cable = values(flat_cable),tension = values(tension),oddmentsg = values(oddmentsg)," +
            "state = values(state),fid = values(fid),axle_number = values(axle_number),axleload_weight = values(axleload_weight)" +
            "</script>")
    void insertPPPProducts(@Param("list")List<PPPProducts0> pppProducts0List,@Param("id")Integer id);

    //更改产物list状态
    @Transactional
    @Modifying
    @Select(value = "<script>" +
            "UPDATE ppp_products#{id} SET delete_no = 1 where pppid = #{deId}"+
            "</script>")
    void UpdatePPPProductsByPPPId(@Param("id")Integer id,@Param("deId")Integer deId);

    //更改产物list状态
    @Transactional
    @Modifying
    @Select(value = "<script>" +
            "UPDATE ppp_products#{id} SET lppid = #{deId} , state = 1 where id IN"+
            "<foreach collection='ids' item='item' open='(' separator=',' close=')'>#{item.id}</foreach>\n" +
            "</script>")
    void UpdatePPPProductsLPPPIdByPPPId(@Param("id")Integer id,@Param("deId")Integer deId,@Param("ids")List<PPPProducts0> ids);

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
            "pp.create_time as createTime,pp.bobbin_detail_id as bobbinDetailId," +
            "tb.bobbin_name as bobbinName,ts.standards as standards,\n" +
            "pp.wire_diameter_um as wireDiameterUm,pp.lengthm as lengthM," +
            "pp.gross_weight as grossWeight,pp.net_weightg as netWeightg,\n" +
            "pp.wastageg as wastageg,pp.lossg as lossg," +
            "pp.slip as Slip,pp.traction_speed as tractionSpeed," +
            "pp.take_up_speed as takeUpSpeed,pp.numbers as numbers,\n" +
            "pp.surface as surface,pp.paying_off as payingOff," +
            "pp.axle_number as axleNumber,pp.axleload_weight as axleloadWeight,\n" +
            "pp.total_length as totalLength,\n" +
            "pp.net_weightg_sum as netWeightgSum,pp.delete_no as deleteNo," +
//            "pw.straight_line as straightLine,\n" +

            "pw.bobbin_color as bobbinColor\n" +
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
//    @Select(value = "<script>SELECT ins.ppp_id as id,ins.stock_model as productModel, ppp.production_number as ppNumber\n" +
//            "FROM inventory_status ins\n" +
//            "LEFT JOIN pp_production ppp ON ppp.id = ins.ppp_id\n" +
//            "WHERE inventory_type =2\n" +
//            "GROUP BY ppp_id</script>")
//    @Select(value = "<script>SELECT ins.ppp_id as id,ppp.production_number as ppNumber,\n" +
//            "ins.stock_model as productModel,ins.standards as stockName,\n" +
//            "sd.`name` as stockRemarks\n" +
//            "FROM inventory_status ins\n" +
//            "LEFT JOIN pp_production ppp ON ppp.id = ins.ppp_id\n" +
//            "LEFT JOIN s_dictionarier sd ON sd.id = ppp.gxid\n" +
//            "WHERE ins.inventory_type = 2 AND ins.delete_no = 0 AND ins.state = 0 AND ins.picking_no != 1\n" +
//            "GROUP BY ppp.production_number\n"+
//            "ORDER BY ppp.id DESC</script>")
//    List<PPProductionVo> findAllFinished();

    @Select(value = "<script>SELECT ins.ppp_id as id,ppp.production_number as stockNumber,\n" +
            "ins.stock_model as stockModel,ins.standards as stockName,ins.unit_id as dictionarierId,\n" +
            "sd.`name` as stockRemarks\n" +
            "FROM inventory_status ins\n" +
            "LEFT JOIN pp_production ppp ON ppp.id = ins.ppp_id\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = ppp.gxid\n" +
            "WHERE ins.inventory_type = 2 AND ins.warehouse_id =9 AND ins.delete_no = 0 AND ins.state = 0" +
            " AND ins.picking_no != 1\n" +
            "GROUP BY ppp.production_number\n"+
            "ORDER BY ppp.id DESC</script>")
    List<StockModel> findAllFinished();



    //工序-回填-根据库存数据查询绕线数量
//    @Select(value = "<script>SELECT pp.id as id,tb.bobbin_name as bobbinName,\n" +
//            "pp.lengthm as lengthM,ins.inventorysum as numbers\n" +
//            "FROM ppp_products#{id} pp\n" +
//            "LEFT JOIN inventory_status ins ON ins.product_id = pp.id\n" +
//            "LEFT JOIN t_standards ts ON ts.id = pp.bobbin_detail_id\n" +
//            "LEFT JOIN t_bobbin tb ON tb.id = ts.material_id\n" +
//            "WHERE  ins.ppp_id =#{deId} AND ins.inventory_type = 2 \n" +
//            "AND pp.delete_no = 0 AND ins.delete_no = 0 AND ins.state = 0\n" +
//            "</script>")
//    List<ProductsVo> findKuCunProductsVoByPPPId(@Param("deId")Integer deId,@Param("id")Integer id);

    @Select(value = "<script>SELECT ins.id as updateID,tb.bobbin_name as updateRemark,\n" +
            "pp.lengthm as standards,ins.inventorysum as updateNum,ins.unit_id as unitId," +
            "sd.`name` as updateType,pp.axle_number as  axleNumber\n" +
            "FROM ppp_products#{id} pp\n" +
            "LEFT JOIN inventory_status ins ON ins.product_id = pp.id\n" +
            "LEFT JOIN t_standards ts ON ts.id = pp.bobbin_detail_id\n" +
            "LEFT JOIN t_bobbin tb ON tb.id = ts.material_id\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id = ins.unit_id\n" +
            "WHERE  ins.ppp_id =#{deId} AND ins.inventory_type = 2 \n" +
            "AND pp.delete_no = 0 AND ins.delete_no = 0 AND ins.state = 0" +
            " AND ins.picking_no != 1\n" +
            "</script>")
    List<UpdateModel> findAllInventoryStateByPPPId(@Param("deId")Integer deId,@Param("id")Integer id);


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
            "WHERE production_number = #{name} and delete_no = 0</script>")
    List<MapVo> findAllProductionInfoByNumber(@Param("name")String name);


//    改绕-新增待改绕信息
    @Transactional
    @Modifying
    @Select(value = "<script>INSERT INTO ppp_products_detour(pppid,slip,bobbin_detail_id,create_time,delete_no,gross_weight,gx_id,lengthm,lossg,net_weightg,net_weightg_sum," +
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
    void insertPDetourroducts(@Param("list")List<PPPProducts0> pppProducts0List);


    //改绕-查询待改绕信息
    @Select(value = "<script>SELECT pp.id as id,pp.pppid as PPPId,pp.gx_id as gxId,\n" +
            "pp.create_time as createTime,pp.bobbin_detail_id as bobbinDetailId,tb.bobbin_name as bobbinName,ts.standards as standards,\n" +
            "pp.wire_diameter_um as wireDiameterUm,pp.lengthm as lengthM," +
            "pp.gross_weight as grossWeight,pp.net_weightg as netWeightg,\n" +
            "pp.wastageg as wastageg,pp.lossg as lossg," +
            "pp.slip as Slip,pp.traction_speed as tractionSpeed," +
            "pp.take_up_speed as takeUpSpeed,pp.numbers as numbers,\n" +
            "pp.surface as surface,pp.paying_off as payingOff," +
            "pp.total_length as totalLength,\n" +
            "pp.net_weightg_sum as netWeightgSum,pp.delete_no as deleteNo\n" +
//            ",pw.straight_line as straightLine\n" +
            "FROM ppp_products_detour pp\n" +
//            "LEFT JOIN ppp_winding_info pw ON pw.ppppid = pp.id\n" + AND pw.pppid =  #{deId}
            "LEFT JOIN t_standards ts ON ts.id = pp.bobbin_detail_id\n" +
            "LEFT JOIN t_bobbin tb ON tb.id = ts.material_id\n" +
            "WHERE pp.pppid = #{deId}  AND pp.delete_no = 0 " +
            "</script>")
    List<ProductsVo> findDetourProductsVoByPPPId(@Param("deId")Integer deId);

    //改绕查询-根据产物id查询改绕详情
    @Select(value = "<script>" +
            "SELECT pp.id as id,pp.pppid as PPPId,pp.slip as Slip,pp.create_time as createTime," +
            "ts.standards,tb.bobbin_name,pp.wire_diameter_um as wireDiameterUm, " +
            "pp.lengthm as lengthM,pp.gross_weight as grossWeight,pp.net_weightg as netWeightg," +
            "pp.surface as surface,pp.paying_off as payingOff,pp.straight_line as straightLine," +
            "pp.numbers as numbers\n" +
            "FROM  ppp_products_detour pp\n" +
            "LEFT JOIN t_standards ts ON ts.id = pp.bobbin_detail_id\n" +
            "LEFT JOIN t_bobbin tb ON tb.id = ts.material_id\n" +
            "WHERE pp.pppid = #{deId} and pp.id = #{id}"+
            "</script>")
    ProductsVo findBypppDetourProducts(@Param("deId")Integer deId,@Param("id")Integer id);




    //    抽检-查询全部
    @Select(value = "<script>SELECT ts.id as id,ppp.production_number as pppNumbers,\n" +
            "ts.report_name as reportName,ts.create_time as createTime,\n" +
            "ts.inspection_sum as inspectionSum,ts.samples_nums as samplesNums,\n" +
            "ts.qualified_num as qualifiedNum,ts.unqualified_num as unqualifiedNum,\n" +
            "ts.state as state,ts.delete_no as deleteNo\n" +
            "FROM t_sampling_report ts\n" +
            "LEFT JOIN pp_production ppp ON ppp.id = ts.ppp_id\n" +
            "WHERE ts.delete_no = 0 \n" +
            "<if test='name != null'>AND ts.report_name LIKE CONCAT('%', #{name},'%')</if>\n" +
            "ORDER BY ts.id DESC \n"+
            "LIMIT #{pageNum},#{pageSize}" +
            "</script>")
    List<TSamplingReportVo> findAllTSamplingReport(@Param("name")String name,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    //    抽检-查询全部
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM t_sampling_report ts\n" +
            "LEFT JOIN pp_production ppp ON ppp.id = ts.ppp_id\n" +
            "WHERE ts.delete_no = 0 \n" +
            "<if test='name != null'>AND ts.report_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "</script>")
    Integer countByTSamplingReport(@Param("name")String name);


    //    质量证书-查询全部
    @Select(value = "<script>SELECT tc.id as id,ppp.production_number as pppNumbers, \n" +
            "tc.report_name as reportName, tc.state as state,tc.create_time as createTime\n" +
            "FROM t_certificate_report tc \n" +
            "LEFT JOIN pp_production ppp ON ppp.id = tc.ppp_id \n" +
            "WHERE tc.delete_no = 0\n" +
            "<if test='name != null'>AND tc.report_name LIKE CONCAT('%', #{name},'%')</if>\n" +
            "ORDER BY tc.id DESC \n"+
            "LIMIT #{pageNum},#{pageSize}" +
            "</script>")
    List<TSamplingReportVo> findAllTCertificateReport(@Param("name")String name,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    //    质量证书-查询全部
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM t_certificate_report ts\n" +
            "LEFT JOIN pp_production ppp ON ppp.id = ts.ppp_id\n" +
            "WHERE ts.delete_no = 0 \n" +
            "<if test='name != null'>AND ts.report_name LIKE CONCAT('%', #{name},'%')</if>\n"+
            "</script>")
    Integer countByTCertificateReport(@Param("name")String name);





//    =========================首页-工作台=================================

    //    生产任务-根据情况查询 （待开始、进行中、已完成、预警等）
    @Select(value = "<script>SELECT ppp.id as id,ppp.gxid as GXId, \n" +
            "ppp.gx_name as GXName,ppp.production_number as productionNumber,\n" +
            "pp.create_time as createTime,pp.finished_time as finishedTime,\n" +
            "tt.team_name as teamName\n" +
            "FROM pp_production ppp\n" +
            "LEFT JOIN pp_product ppr ON ppr.id = ppp.pproduct_id\n" +
            "LEFT JOIN product_plan pp ON pp.id = ppr.pp_id\n" +
            "LEFT JOIN t_team tt ON tt.id = ppp.team_id\n" +
            "WHERE ppp.delete_no = 0 \n" +
            "AND ppp.create_time BETWEEN #{createTime} AND #{finishedTime} \n" +
            "<if test='state != null and state == 0'>AND ppp.state =  0 AND ppp.gxid = #{gxid}</if>\n"+
            "<if test='state != null and state == 1'>AND ppp.state =  0 AND ppp.gxid != #{gxid}</if>\n"+
            "<if test='state != null and state == 2'>AND ppp.state =  1 </if>\n"+
//            "<if test='gxid != null'>AND ppp.gxid = #{gxid}</if>\n"+
            "</script>")
    List<PPPVo> findByStateOrGxId(@Param("state")Integer state, @Param("gxid")Integer gxid, @Param("createTime")Date createTime, @Param("finishedTime")Date finishedTime);




    //    生产数据-生产日报汇总查询
        @Select(value = "<script>SELECT finish_edp as finishEdP,income_heavy as incomeHeavy,loss as loss,no_finish_edp as noFinishEdP," +
                "pp_number as ppNumber,product_date as productDate,product_model as productModel,production_number as productionNumber," +
                "total_net as totalNet,waste as waste\n" +
                "FROM pp_production_diary_report\n" +
                "WHERE id != 0 \n" +
                "<if test='ppnumber != null'>AND pp_number LIKE CONCAT('%', #{ppnumber},'%') </if>\n"+
                "<if test='productionNumber != null'>AND production_number  LIKE CONCAT('%', #{productionNumber},'%')</if>\n"+
                "<if test='createTime != null '>AND  product_date = #{createTime}  </if>\n"+
                "ORDER BY id DESC\n " +
                "LIMIT #{pageNum},#{pageSize}" +
                "</script>")
    List<ProductionDiaryReport> findAllByProductionDiaryReport(@Param("ppnumber")String ppnumber, @Param("productionNumber")String productionNumber, @Param("createTime")String createTime,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);


    //    生产数据-生产日报汇总查询-总数
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM pp_production_diary_report\n" +
            "WHERE id != 0 \n" +
            "<if test='ppnumber != null'>AND pp_number LIKE CONCAT('%', #{ppnumber},'%') </if>\n"+
            "<if test='productionNumber != null'>AND production_number  LIKE CONCAT('%', #{productionNumber},'%')</if>\n"+
            "<if test='createTime != null'>AND  product_date = #{createTime} </if>\n"+
            "</script>")
    Integer countByProductionDiaryReport(@Param("ppnumber")String ppnumber, @Param("productionNumber")String productionNumber, @Param("createTime")String createTime);


    //    生产数据-生产日报细分报汇总查询--暂停
    @Select(value = "<script>SELECT pppp.id,pppp.create_time,pppp.wire_diameter_um,\n" +
            "pppp.net_weightg,pppp.lengthm,\n" +
            "ppp.production_number,pl.pp_number\n" +
            "FROM ppp_products#{id} pppp\n" +
            "LEFT JOIN pp_production ppp ON ppp.id = pppp.pppid\n" +
            "LEFT JOIN pp_product pp ON pp.id = ppp.pproduct_id\n" +
            "LEFT JOIN product_plan pl ON pl.id =pp.pp_id\n" +
            "WHERE pppp.delete_no= 0 \n" +
            "<if test='ppnumber != null'>AND pl.pp_number LIKE CONCAT('%', #{ppnumber},'%') </if>\n"+
            "<if test='productionNumber != null'>AND ppp.production_number  LIKE CONCAT('%', #{productionNumber},'%')</if>\n"+
            "<if test='createTime != null '>AND  pppp.create_time = #{createTime}  </if>\n"+
            "ORDER BY id DESC\n " +
            "LIMIT #{pageNum},#{pageSize}" +
            "</script>")
    List<PPProductVo> findAllByProductionSubdivideReport(@Param("id")Integer id,@Param("ppnumber")String ppnumber, @Param("productionNumber")String productionNumber, @Param("createTime")String createTime,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);


    //    生产数据-生产日报细分报汇总查询-总数--暂停
    @Select(value = "<script>SELECT pppp.id,pppp.create_time,pppp.wire_diameter_um,\n" +
            "pppp.net_weightg,pppp.lengthm,\n" +
            "ppp.production_number,pl.pp_number\n" +
            "FROM ppp_products#{id} pppp\n" +
            "LEFT JOIN pp_production ppp ON ppp.id = pppp.pppid\n" +
            "LEFT JOIN pp_product pp ON pp.id = ppp.pproduct_id\n" +
            "LEFT JOIN product_plan pl ON pl.id =pp.pp_id\n" +
            "WHERE pppp.delete_no= 0 \n" +
            "<if test='ppnumber != null'>AND pl.pp_number LIKE CONCAT('%', #{ppnumber},'%') </if>\n"+
            "<if test='productionNumber != null'>AND ppp.production_number  LIKE CONCAT('%', #{productionNumber},'%')</if>\n"+
            "<if test='createTime != null '>AND  pppp.create_time = #{createTime}  </if>\n"+
            "ORDER BY id DESC\n " +
            "LIMIT #{pageNum},#{pageSize}" +
            "</script>")
    Integer countByProductionSubdivideReport(@Param("id")Integer id,@Param("ppnumber")String ppnumber, @Param("productionNumber")String productionNumber, @Param("createTime")String createTime,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);


    //    生产数据-生产质量分析
//    @Select(value = "<script>(SELECT id as id,create_time as createTime,net_weightg as netWeight,wastageg as wastageg,lossg as lossg FROM ppp_products0 WHERE delete_no = 0 AND create_time BETWEEN \"2021-01-12 00:00:00\" AND \"2021-01-12 23:23:59\")\n" +
//            "UNION ALL\n" +
//            "(SELECT id as id,create_time as createTime,net_weightg as netWeight,wastageg as wastageg,lossg as lossg FROM ppp_products1 WHERE delete_no = 0 AND create_time BETWEEN \"2021-01-12 00:00:00\" AND \"2021-01-12 23:23:59\" )\n" +
//            "UNION ALL\n" +
//            "(SELECT id as id,create_time as createTime,net_weightg as netWeight,wastageg as wastageg,lossg as lossg FROM ppp_products2 WHERE delete_no = 0 AND create_time BETWEEN \"2021-01-12 00:00:00\" AND \"2021-01-12 23:23:59\" )\n" +
//            "UNION ALL\n" +
//            "(SELECT id as id,create_time as createTime,net_weightg as netWeight,wastageg as wastageg,lossg as lossg FROM ppp_products3 WHERE delete_no = 0 AND create_time BETWEEN \"2021-01-12 00:00:00\" AND \"2021-01-12 23:23:59\" )\n" +
//            "UNION ALL\n" +
//            "(SELECT id as id,create_time as createTime,net_weightg as netWeight,wastageg as wastageg,lossg as lossg FROM ppp_products4 WHERE delete_no = 0 AND create_time BETWEEN \"2021-01-12 00:00:00\" AND \"2021-01-12 23:23:59\")\n" +
//            "UNION ALL\n" +
//            "(SELECT id as id,create_time as createTime,net_weightg as netWeight,wastageg as wastageg,lossg as lossg FROM ppp_products5 WHERE delete_no = 0 AND create_time BETWEEN \"2021-01-12 00:00:00\" AND \"2021-01-12 23:23:59\" )\n" +
//            "UNION ALL\n" +
//            "(SELECT id as id,create_time as createTime,net_weightg as netWeight,wastageg as wastageg,lossg as lossg FROM ppp_products6 WHERE delete_no = 0 AND create_time BETWEEN \"2021-01-12 00:00:00\" AND \"2021-01-12 23:23:59\")\n" +
//            "UNION ALL\n" +
//            "(SELECT id as id,create_time as createTime,net_weightg as netWeight,wastageg as wastageg,lossg as lossg FROM ppp_products7 WHERE delete_no = 0 AND create_time BETWEEN \"2021-01-12 00:00:00\" AND \"2021-01-12 23:23:59\" )\n" +
//            "UNION ALL\n" +
//            "(SELECT id as id,create_time as createTime,net_weightg as netWeight,wastageg as wastageg,lossg as lossg FROM ppp_products8 WHERE delete_no = 0 AND create_time BETWEEN \"2021-01-12 00:00:00\" AND \"2021-01-12 23:23:59\" )\n" +
//            "UNION ALL\n" +
//            "(SELECT id as id,create_time as createTime,net_weightg as netWeight,wastageg as wastageg,lossg as lossg FROM ppp_products9 WHERE delete_no = 0 AND create_time BETWEEN \"2021-01-12 00:00:00\" AND \"2021-01-12 23:23:59\" )\n" +
//            "ORDER BY id DESC\n " +
//            "</script>")

    @Select(value = "<script>SELECT id as id, product_date as productDate,SUM(finish_edp) as finishEdP,\n" +
            "SUM(income_heavy) as incomeHeavy,SUM(loss) as lossg,\n" +
            "SUM(waste) as wastageg\n" +
            "FROM pp_production_diary_report\n" +
            "WHERE id != 0 AND product_date  like  concat('%',#{createTime},'%') \n" +
            "GROUP BY production_number\n" +
            "ORDER BY id DESC\n " +
            "LIMIT #{pageNum},#{pageSize}" +
            "</script>")
    List<PPProductsVo> findAllByProductionQualityAnalysis(@Param("createTime")String createTime,@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);


    @Select(value = "<script>SELECT id as id, product_date as productDate,SUM(finish_edp) as finishEdP,\n" +
            "SUM(income_heavy) as incomeHeavy,SUM(loss) as lossg,\n" +
            "SUM(waste) as wastageg\n" +
            "FROM pp_production_diary_report\n" +
            "WHERE id != 0 AND product_date  like  concat('%',#{createTime},'%') \n" +
            "GROUP BY production_number\n" +
            "ORDER BY id DESC\n " +
            "</script>")
    List<PPProductsVo> findAllByProductionQualityAnalysisNoLimit(@Param("createTime")String createTime);


    //    生产数据-生产日报汇总查询-总数
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM (\n" +
            " SELECT id  FROM pp_production_diary_report\n" +
            "WHERE id != 0 AND product_date  like concat('%',#{createTime},'%') \n" +
            "GROUP BY production_number)aa\n" +
            "</script>")
    Integer countByProductionQualityAnalysis(@Param("createTime")String createTime);


    @Select(value = "<script>SELECT ppp.team_id as teamId,SUM(pd.income_heavy) as incomeHeavy,SUM(pd.finish_edp) as finishEdP," +
            "SUM(pd.waste) as wastageg,SUM(pd.loss) as lossg,tt.team_name as teamName\n" +
            "FROM pp_production_diary_report pd\n" +
            "LEFT JOIN pp_production ppp ON ppp.production_number = pd.production_number\n" +
            "LEFT JOIN t_team tt ON tt.id = ppp.team_id\n" +
            "WHERE pd.id != 0 AND pd.product_date like concat('%',#{createTime},'%') \n" +
            "AND ppp.team_id = #{teamId}\n" +
            "GROUP BY ppp.team_id" +
            "</script>")
    List<PPProductsVo> findAllByProductionTeam(@Param("createTime")String createTime,@Param("teamId")Integer teamId);


}
