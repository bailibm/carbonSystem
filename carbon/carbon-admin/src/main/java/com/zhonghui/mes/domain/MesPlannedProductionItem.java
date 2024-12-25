package com.zhonghui.mes.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 计划排产-生产计划子对象 mes_planned_production_item
 * 
 * @author zhonghui
 * @date 2022-05-22
 */
@ApiModel("计划排产-生产计划子对象")
public class MesPlannedProductionItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @ApiModelProperty("编号")
    private Long id;

    /** 计划排产id */
    @Excel(name = "计划排产id")
    @ApiModelProperty("计划排产id")
    private Long productionId;

    /** 物料id */
    @Excel(name = "物料id")
    @ApiModelProperty("物料id")
    private Long materialId;

    /** 需求数量 */
    @Excel(name = "需求数量")
    @ApiModelProperty("需求数量")
    private Double dosage;

    /** 已用数量 */
    @Excel(name = "已用数量")
    @ApiModelProperty("已用数量")
    private Double usedQuantity;

    /** 剩余数量 */
    @Excel(name = "剩余数量")
    @ApiModelProperty("剩余数量")
    private Double residueQuantity;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductionId(Long productionId) 
    {
        this.productionId = productionId;
    }

    public Long getProductionId() 
    {
        return productionId;
    }
    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }

    public Long getMaterialId()
    {
        return materialId;
    }
    public void setDosage(Double dosage)
    {
        this.dosage = dosage;
    }

    public Double getDosage()
    {
        return dosage;
    }
    public void setUsedQuantity(Double usedQuantity)
    {
        this.usedQuantity = usedQuantity;
    }

    public Double getUsedQuantity()
    {
        return usedQuantity;
    }
    public void setResidueQuantity(Double residueQuantity)
    {
        this.residueQuantity = residueQuantity;
    }

    public Double getResidueQuantity()
    {
        return residueQuantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productionId", getProductionId())
            .append("materialId", getMaterialId())
            .append("dosage", getDosage())
            .append("usedQuantity", getUsedQuantity())
            .append("residueQuantity", getResidueQuantity())
            .append("remark", getRemark())
            .toString();
    }
}
