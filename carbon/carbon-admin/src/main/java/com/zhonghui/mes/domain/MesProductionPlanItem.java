package com.zhonghui.mes.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 生产计划-生产计划明细子对象 mes_production_plan_item
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
@ApiModel("生产计划明细子对象")
public class MesProductionPlanItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @ApiModelProperty("编号")
    private Long id;

    /** 生产计划id */
    @Excel(name = "生产计划id")
    @ApiModelProperty("生产计划id")
    private Long planId;

    /** 物料id */
    @Excel(name = "物料id")
    @ApiModelProperty("物料id")
    private Long materialId;

    /** 生产数量 */
    @Excel(name = "生产数量")
    @ApiModelProperty("生产数量")
    private Double quantity;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("生产日期")
    private Date manufacture;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setQuantity(Double quantity)
    {
        this.quantity = quantity;
    }

    public Double getQuantity()
    {
        return quantity;
    }
    public void setManufacture(Date manufacture)
    {
        this.manufacture = manufacture;
    }

    public Date getManufacture()
    {
        return manufacture;
    }
    public void setPlanId(Long planId)
    {
        this.planId = planId;
    }

    public Long getPlanId()
    {
        return planId;
    }
    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }

    public Long getMaterialId()
    {
        return materialId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("quantity", getQuantity())
            .append("materialId", getMaterialId())
            .append("planId", getPlanId())
            .append("manufacture", getManufacture())
            .toString();
    }
}
