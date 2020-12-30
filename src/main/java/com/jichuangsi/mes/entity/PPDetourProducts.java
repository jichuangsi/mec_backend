package com.jichuangsi.mes.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//改绕本班产物
@Entity
@Table(name = "pp_detourProducts")
public class PPDetourProducts {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//产物ID
    private Integer PPPId;//生产id
    private Date createTime;//生产时间
    private Integer bobbinId;//线轴规格id
    private BigDecimal wireDiameterUm;//线径um
    private BigDecimal lengthM;//长度m/轴
    private BigDecimal grossWeight ;//毛重g
    private BigDecimal netWeightg;//净重g
    private Integer amount;//数量
    private Integer totalLength;//总长度
    private BigDecimal netWeightgSum;//总净重g
    private Integer deleteNo;//删除否
}
