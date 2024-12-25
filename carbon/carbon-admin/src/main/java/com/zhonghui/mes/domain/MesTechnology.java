package com.zhonghui.mes.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 工艺建模对象 mes_technology
 * 
 * @author zhonghui
 * @date 2022-05-19
 */
@ApiModel("工艺建模对象")
public class MesTechnology extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工艺建模id */
    @Excel(name = "工艺建模id")
    @ApiModelProperty("id")
    private Long id;

    /** 工艺名称 */
    @Excel(name = "工艺名称")
    @ApiModelProperty("工艺名称")
    private String technologyName;

    /** 产品id */
    @Excel(name = "产品id")
    @ApiModelProperty("产品id")
    private Long materialId;

    /** 单位耗电量 */
    @Excel(name = "单位耗电量")
    @ApiModelProperty("单位耗电量")
    private Double unitPowerConsumption;

    /** 工艺描述 */
    @Excel(name = "工艺描述")
    @ApiModelProperty("工艺描述")
    private String technologyDescribe;

    /** 产品建模信息 */
    @ApiModelProperty("产品建模信息")
    private List<MesProduct> mesProductList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTechnologyName(String technologyName) 
    {
        this.technologyName = technologyName;
    }

    public String getTechnologyName() 
    {
        return technologyName;
    }
    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }

    public Long getMaterialId()
    {
        return materialId;
    }
    public void setUnitPowerConsumption(Double unitPowerConsumption)
    {
        this.unitPowerConsumption = unitPowerConsumption;
    }

    public Double getUnitPowerConsumption()
    {
        return unitPowerConsumption;
    }
    public void setTechnologyDescribe(String technologyDescribe) 
    {
        this.technologyDescribe = technologyDescribe;
    }

    public String getTechnologyDescribe() 
    {
        return technologyDescribe;
    }

    public List<MesProduct> getMesProductList()
    {
        return mesProductList;
    }

    public void setMesProductList(List<MesProduct> mesProductList)
    {
        this.mesProductList = mesProductList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("technologyName", getTechnologyName())
            .append("materialId", getMaterialId())
            .append("unitPowerConsumption", getUnitPowerConsumption())
            .append("remark", getRemark())
            .append("technologyDescribe", getTechnologyDescribe())
            .append("mesProductList", getMesProductList())
            .toString();
    }
}
