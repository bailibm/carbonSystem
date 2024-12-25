package com.zhonghui.mes.domain.vo;

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
public class MesPlannedProductionItemVo extends BaseEntity
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

    /** 物料 */
    @Excel(name = "物料")
    @ApiModelProperty("物料")
    private String materialName;

    /** 型号 */
    @Excel(name = "型号")
    @ApiModelProperty("型号")
    private String materialModel;

    /** 规格 */
    @Excel(name = "规格")
    @ApiModelProperty("规格")
    private String materialSpecifications;

    /** 单位 */
    @Excel(name = "单位")
    @ApiModelProperty("单位")
    private String materialUnit;

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
    public void setMaterialName(String materialName)
    {
        this.materialName = materialName;
    }

    public String getMaterialName()
    {
        return materialName;
    }
    public void setMaterialModel(String materialModel)
    {
        this.materialModel = materialModel;
    }

    public String getMaterialModel()
    {
        return materialModel;
    }
    public void setMaterialSpecifications(String materialSpecifications)
    {
        this.materialSpecifications = materialSpecifications;
    }

    public String getMaterialSpecifications()
    {
        return materialSpecifications;
    }
    public void setMaterialUnit(String materialUnit)
    {
        this.materialUnit = materialUnit;
    }

    public String getMaterialUnit()
    {
        return materialUnit;
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
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialSpecifications", getMaterialSpecifications())
            .append("materialUnit", getMaterialUnit())
            .append("dosage", getDosage())
            .append("usedQuantity", getUsedQuantity())
            .append("residueQuantity", getResidueQuantity())
            .toString();
    }
}
