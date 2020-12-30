package com.jichuangsi.mes.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_proloss")
public class TProloss {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;//损耗比ID
    private Integer processId;//产品ID
    private BigDecimal yieldRateStart;//成品率%
    private BigDecimal yieldRateEnd;//成品率%
    private BigDecimal losSrateStart;//损耗率%
    private BigDecimal losSrateEend;//损耗率%
    private BigDecimal wasteRateStart;//废品率%
    private BigDecimal wasteRateEnd;//废品率%

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public BigDecimal getYieldRateStart() {
        return yieldRateStart;
    }

    public void setYieldRateStart(BigDecimal yieldRateStart) {
        this.yieldRateStart = yieldRateStart;
    }

    public BigDecimal getYieldRateEnd() {
        return yieldRateEnd;
    }

    public void setYieldRateEnd(BigDecimal yieldRateEnd) {
        this.yieldRateEnd = yieldRateEnd;
    }

    public BigDecimal getLosSrateStart() {
        return losSrateStart;
    }

    public void setLosSrateStart(BigDecimal losSrateStart) {
        this.losSrateStart = losSrateStart;
    }

    public BigDecimal getLosSrateEend() {
        return losSrateEend;
    }

    public void setLosSrateEend(BigDecimal losSrateEend) {
        this.losSrateEend = losSrateEend;
    }

    public BigDecimal getWasteRateStart() {
        return wasteRateStart;
    }

    public void setWasteRateStart(BigDecimal wasteRateStart) {
        this.wasteRateStart = wasteRateStart;
    }

    public BigDecimal getWasteRateEnd() {
        return wasteRateEnd;
    }

    public void setWasteRateEnd(BigDecimal wasteRateEnd) {
        this.wasteRateEnd = wasteRateEnd;
    }
}
