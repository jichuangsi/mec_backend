package com.jichuangsi.mes.mapper;


import com.jichuangsi.mes.entity.ProductionStock;
import com.jichuangsi.mes.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface INewProductionMapper {



    //生产领料-查询当前生产计划单--查询已经审核完成的
    @Select(value = "<script>SELECT pp.id as id,pp.pp_name as ppName,\n" +
            "pp.pp_number as ppNumber,pp.create_time as createTime,pp.finished_time as finishedTime,\n" +
            "IFNULL(ts.sale_order,\"无\") as SaleOrder\n" +
            "FROM product_plan pp\n" +
            "LEFT JOIN t_saleorder ts ON ts.id = pp.sale_id\n" +
            "WHERE pp.delete_no = 0 and pp.pp_plan_state = 3 \n"+
            "ORDER BY pp.id DESC\n" +
            "</script>")
    List<PPVo> findProductPlanInfo();


    //生产领料-根据生产计划单id查询详情信息
    @Select(value = "<script>SELECT pp.id as id,pp.pp_name as ppName,\n" +
            "pp.pp_number as ppNumber,pp.create_time as createTime,pp.finished_time as finishedTime,\n" +
            "IFNULL(ts.sale_order,\"无\") as SaleOrder\n" +
            "FROM product_plan pp\n" +
            "LEFT JOIN t_saleorder ts ON ts.id = pp.sale_id\n" +
            "WHERE pp.delete_no = 0 and pp.pp_plan_state = 3 and pp.id = #{deId} \n"+
            "ORDER BY pp.id DESC\n" +
            "</script>")
    PPVo findProductPlanInfoById(@Param("deId")Integer deId);



    //查询生产表
    @Select(value = "<script>SELECT ppi.id as id ,ppi.ppiname as ppiname,ppi.ppinumber as ppinumber,\n" +
            "ppi.total_net as totalNet,ppi.delete_no as deleteNo,ppi.create_time as createTime,\n" +
            "pp.pp_number as ppnumber,tw.warehousen_name as ppiwarehouseName\n" +
            "FROM production_picking ppi\n" +
            "LEFT JOIN product_plan pp ON pp.id = ppi.ppid\n" +
            "LEFT JOIN t_warehouse tw ON tw.id = ppi.warehouse_id\n"+
            "WHERE ppi.delete_no = 0\n"+
            "<if test='name != null'>AND pp.pp_number LIKE CONCAT('%', #{name},'%')</if>\n"+
            "ORDER BY ppi.id DESC\n" +
            "LIMIT #{pageNum},#{pageSize}</script>")
    List<PPPickingVo> findAllPPPicking(@Param("name")String name, @Param("pageNum")int pageNum, @Param("pageSize")int pageSize);


    //查询生产领料-总数
    @Select(value = "<script>SELECT count(1)\n" +
            "FROM production_picking ppi\n" +
            "LEFT JOIN product_plan pp ON pp.id = ppi.ppid\n" +
            "LEFT JOIN t_warehouse tw ON tw.id = ppi.warehouse_id\n"+
            "WHERE ppi.delete_no = 0\n"+
            "<if test='name != null'>AND pp.pp_number LIKE CONCAT('%', #{name},'%')</if>\n"+
            "ORDER BY ppi.id DESC\n" +
            "</script>")
    Integer countAllPPPicking(@Param("name")String name);



    //生产领料-回填-查询领料的原材料
    @Select(value = "<script>SELECT ps.id as id,ps.ppiid as PPPId,ps.inventory_status_id as inventoryStatusId,\n" +
            "ps.quantity_choose as quantityChoose,ps.total_net as totalNet,sd.`name` as unitName,\n" +
            "st.standards as standards,ts.stock_name as stockName,ts.stock_model as stockModel," +
            "ts.stock_number as stockNumber,ps.warehourse_id as warehourseId," +
            " tw.warehousen_name as warehourseName,ps.delete_no as deleteNo\n" +
            "FROM picking_stock ps\n" +
            "LEFT JOIN inventory_status ns ON ns.id = ps.inventory_status_id\n" +
            "LEFT JOIN t_standards st ON st.id = ns.product_id\n" +
            "LEFT JOIN t_stock ts ON ts.id = st.material_id\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id =ts.dictionarier_id\n" +
            "LEFT JOIN t_warehouse tw ON tw.id = ps.warehourse_id\n" +
            "WHERE ps.delete_no = 0 AND ps.ppiid = #{deId}" +
            "</script>")
    List<ProductionStockVo> findPickingStocksByPPIId(@Param("deId")Integer deId);

//---------------------------【新】-生产管理数据-----------------------------------------------------------------

    //查询生产表 (除了退火工序的生产表)
    @Select(value = "<script>SELECT ppp.id as id,\n" +
            "pp.pp_number as ppNumber, ppp.production_number as productionNumber,\n" +
            "ppp.gx_name as GXName\n" +
            "FROM pp_production ppp\n" +
            "LEFT JOIN pp_product pr ON pr.id = ppp.pproduct_id\n" +
            "LEFT JOIN product_plan pp ON pp.id = pr.pp_id\n" +
            "WHERE ppp.delete_no = 0 and (ppp.state != 0 and ppp.gxid = #{deId}) or ( ppp.gxid = #{dId} and  ppp.state = 2)\n"+
            "<if test='pname != null'>AND ppp.production_number LIKE CONCAT('%', #{pname},'%')</if>\n"+
            "ORDER BY ppp.id DESC\n" +
            "</script>")
    List<PPPVo> findAllPPProduction(@Param("deId")Integer deId,@Param("dId")Integer dId,@Param("pname")String pname);

    //查询生产表 -退火的时候状态是4
    @Select(value = "<script>SELECT ppp.id as id,\n" +
            "pp.pp_number as ppNumber, ppp.production_number as productionNumber,\n" +
            "ppp.gx_name as GXName\n" +
            "FROM pp_production ppp\n" +
            "LEFT JOIN pp_product pr ON pr.id = ppp.pproduct_id\n" +
            "LEFT JOIN product_plan pp ON pp.id = pr.pp_id\n" +
            "WHERE ppp.delete_no = 0 and (ppp.state != 0 and ppp.gxid = #{deId}) or (ppp.state = #{state})\n"+
            "<if test='pname != null'>AND ppp.production_number LIKE CONCAT('%', #{pname},'%')</if>\n"+
            "ORDER BY ppp.id DESC\n" +
            "</script>")
    List<PPPVo> findAllPPProductionAnnealing(@Param("deId")Integer deId,@Param("pname")String pname,@Param("state")Integer state);

    //生产熔炼-根据生产计划单id查询领料的原材料
    @Select(value = "<script>SELECT ps.id as id,ps.ppiid as PPPId,ps.inventory_status_id as inventoryStatusId,\n" +
            "ps.quantity_choose as quantityChoose,ps.total_net as totalNet,sd.`name` as unitName,\n" +
            "st.standards as standards,ts.stock_name as stockName,ts.stock_model as stockModel," +
            "ts.stock_number as stockNumber,ps.warehourse_id as warehourseId," +
            " tw.warehousen_name as warehourseName,ps.delete_no as deleteNo\n" +
            "FROM picking_stock ps\n" +
            "LEFT JOIN production_picking pi ON pi.id = ps.ppiid\n" +
            "LEFT JOIN inventory_status ns ON ns.id = ps.inventory_status_id\n" +
            "LEFT JOIN t_standards st ON st.id = ns.product_id\n" +
            "LEFT JOIN t_stock ts ON ts.id = st.material_id\n" +
            "LEFT JOIN s_dictionarier sd ON sd.id =ts.dictionarier_id\n" +
            "LEFT JOIN t_warehouse tw ON tw.id = ps.warehourse_id\n" +
            "WHERE ps.delete_no = 0 and ps.state = 0 AND pi.ppid = #{deId}" +
            "</script>")
    List<ProductionStockVo> findPickingStocksByPPId(@Param("deId")Integer deId);


    //   生产管理-根据id修改领料的状态为已使用
    @Select(value = "<script>UPDATE picking_stock SET state = 1 WHERE  id IN \n" +
            "<foreach collection='ids' item='item' open='(' separator=',' close=')'>#{item.id}</foreach>\n" +
            "</script>")
    void updatePickingStockstateByIds(@Param("ids")List<ProductionStockVo> ids);


}
