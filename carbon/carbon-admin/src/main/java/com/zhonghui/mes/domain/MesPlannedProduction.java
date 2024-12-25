package com.zhonghui.mes.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 计划排产对象 mes_planned_production
 * 
 * @author zhonghui
 * @date 2022-05-22
 */
@ApiModel("计划排产对象")
public class MesPlannedProduction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    @ApiModelProperty("编号")
    private Long id;

    /** 流水号 */
    @Excel(name = "流水号")
    @ApiModelProperty("流水号")
    private String serialNo;

    /** 生产计划id */
    @Excel(name = "生产计划id")
    @ApiModelProperty("生产计划id")
    private Long productionPlanId;

    /** 物料id */
    @Excel(name = "物料id")
    @ApiModelProperty("物料id")
    private Long materialId;

    /** BOM */
    @Excel(name = "BOM")
    @ApiModelProperty("BOM")
    private Long bomId;

    /** 工厂id */
    @Excel(name = "工厂id")
    @ApiModelProperty("工厂id")
    private Long factoryId;

    /** 工艺id */
    @Excel(name = "工艺id")
    @ApiModelProperty("工艺id")
    private Long technologyId;

    /** 待产数量 */
    @Excel(name = "待产数量")
    @ApiModelProperty("待产数量")
    private Double producedQuantity;

    /** 已产数量 */
    @Excel(name = "已产数量")
    @ApiModelProperty("已产数量")
    private Double quantityProduced;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("生产日期")
    private Date manufactureDate;

    /** 交货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "交货日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("交货日期")
    private Date deliveryDate;

    /** 发布状态 */
    @Excel(name = "发布状态")
    @ApiModelProperty("发布状态")
    private Integer status;

    /** 领料状态 */
    @Excel(name = "领料状态")
    @ApiModelProperty("领料状态")
    private Integer pickingStatus;

    /** 计划排产-生产计划*/
    @ApiModelProperty("计划排产-生产计划信息")
    private List<MesPlannedProductionItem> mesPlannedProductionItemList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSerialNo(String serialNo) 
    {
        this.serialNo = serialNo;
    }

    public String getSerialNo() 
    {
        return serialNo;
    }
    public void setProductionPlanId(Long productionPlanId)
    {
        this.productionPlanId = productionPlanId;
    }

    public Long getProductionPlanId()
    {
        return productionPlanId;
    }
    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }

    public Long getMaterialId()
    {
        return materialId;
    }
    public void setBomId(Long bomId)
    {
        this.bomId = bomId;
    }

    public Long getBomId()
    {
        return bomId;
    }
    public void setFactoryId(Long factoryId)
    {
        this.factoryId = factoryId;
    }

    public Long getFactoryId()
    {
        return factoryId;
    }
    public void setTechnologyId(Long technologyId)
    {
        this.technologyId = technologyId;
    }

    public Long getTechnologyId()
    {
        return technologyId;
    }
    public void setProducedQuantity(Double producedQuantity)
    {
        this.producedQuantity = producedQuantity;
    }

    public Double getProducedQuantity()
    {
        return producedQuantity;
    }
    public void setQuantityProduced(Double quantityProduced)
    {
        this.quantityProduced = quantityProduced;
    }

    public Double getQuantityProduced()
    {
        return quantityProduced;
    }
    public void setManufactureDate(Date manufactureDate) 
    {
        this.manufactureDate = manufactureDate;
    }

    public Date getManufactureDate() 
    {
        return manufactureDate;
    }
    public void setDeliveryDate(Date deliveryDate) 
    {
        this.deliveryDate = deliveryDate;
    }

    public Date getDeliveryDate() 
    {
        return deliveryDate;
    }
    public void setPickingStatus(Integer pickingStatus)
    {
        this.pickingStatus = pickingStatus;
    }

    public Integer getPickingStatus()
    {
        return pickingStatus;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }

    public List<MesPlannedProductionItem> getMesPlannedProductionItemList()
    {
        return mesPlannedProductionItemList;
    }

    public void setMesPlannedProductionItemList(List<MesPlannedProductionItem> mesPlannedProductionItemList)
    {
        this.mesPlannedProductionItemList = mesPlannedProductionItemList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("serialNo", getSerialNo())
            .append("productionPlanId", getProductionPlanId())
            .append("materialId", getMaterialId())
            .append("bomId", getBomId())
            .append("factoryId", getFactoryId())
            .append("technologyId", getTechnologyId())
            .append("producedQuantity", getProducedQuantity())
            .append("quantityProduced", getQuantityProduced())
            .append("manufactureDate", getManufactureDate())
            .append("deliveryDate", getDeliveryDate())
            .append("pickingStatus", getPickingStatus())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("mesPlannedProductionItemList", getMesPlannedProductionItemList())
            .toString();
    }
}
