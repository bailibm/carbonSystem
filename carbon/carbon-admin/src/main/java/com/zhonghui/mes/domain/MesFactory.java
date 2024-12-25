package com.zhonghui.mes.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 工厂建模对象 mes_factory
 *
 * @author carbon
 * @date 2022-05-20
 */
@ApiModel("工厂建模对象")
public class MesFactory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    @ApiModelProperty("编号")
    private Long id;

    /** 产品 */
    @Excel(name = "产品ID")
    @ApiModelProperty("产品ID")
    private Long materialId;

    /** 生产线名称 */
    @Excel(name = "生产线名称")
    @ApiModelProperty("生产线名称")
    private String productionLine;

    /** 描述 */
    @ApiModelProperty("描述")
    private String factoryDescribe;

    /** 工厂建模设备信息子信息 */
    @ApiModelProperty("工厂建模设备信息")
    private List<MesFactoryDeviceItem> mesFactoryDeviceItemList;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }

    public Long getMaterialId()
    {
        return materialId;
    }
    public void setProductionLine(String productionLine)
    {
        this.productionLine = productionLine;
    }

    public String getProductionLine()
    {
        return productionLine;
    }
    public void setFactoryDescribe(String factoryDescribe)
    {
        this.factoryDescribe = factoryDescribe;
    }

    public String getFactoryDescribe()
    {
        return factoryDescribe;
    }

    public List<MesFactoryDeviceItem> getMesFactoryDeviceItemList()
    {
        return mesFactoryDeviceItemList;
    }

    public void setMesFactoryDeviceItemList(List<MesFactoryDeviceItem> mesFactoryDeviceItemList)
    {
        this.mesFactoryDeviceItemList = mesFactoryDeviceItemList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("materialId", getMaterialId())
                .append("productionLine", getProductionLine())
                .append("factoryDescribe", getFactoryDescribe())
                .append("mesFactoryDeviceItemList", getMesFactoryDeviceItemList())
                .toString();
    }
}
