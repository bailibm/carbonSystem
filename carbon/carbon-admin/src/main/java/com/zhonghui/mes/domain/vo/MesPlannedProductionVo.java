package com.zhonghui.mes.domain.vo;

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
public class MesPlannedProductionVo extends BaseEntity
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

    /** 计划号 */
    @Excel(name = "计划号")
    @ApiModelProperty("计划号")
    private String planNumber;

    /** BOM */
    @Excel(name = "BOM")
    @ApiModelProperty("BOM")
    private Long bomId;

    /** BOM名称 */
    @Excel(name = "BOM名称")
    @ApiModelProperty("BOM名称")
    private String bomName;

    /** 物料id */
    @Excel(name = "物料id")
    @ApiModelProperty("物料id")
    private Long materialId;

    /** 产品 */
    @Excel(name = "产品")
    @ApiModelProperty("产品")
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

    /** 工厂id */
    @Excel(name = "工厂id")
    @ApiModelProperty("工厂id")
    private Long factoryId;

    /** 生产线 */
    @Excel(name = "生产线")
    @ApiModelProperty("生产线")
    private String productionLine;

    /** 工艺id */
    @Excel(name = "工艺id")
    @ApiModelProperty("工艺id")
    private Long technologyId;

    /** 工艺名称 */
    @Excel(name = "工艺名称")
    @ApiModelProperty("工艺名称")
    private String technologyName;

    /** 项目id */
    @Excel(name = "项目id")
    @ApiModelProperty("项目id")
    private Long projectId;

    /** 项目 */
    @Excel(name = "项目")
    @ApiModelProperty("项目")
    private String projectName;

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
    private List<MesPlannedProductionItemVo> mesPlannedProductionItemList;

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
    public void setPlanNumber(String planNumber)
    {
        this.planNumber = planNumber;
    }

    public String getPlanNumber()
    {
        return planNumber;
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
    public void setBomId(Long bomId)
    {
        this.bomId = bomId;
    }

    public Long getBomId()
    {
        return bomId;
    }
    public void setBomName(String bomName)
    {
        this.bomName = bomName;
    }

    public String getBomName()
    {
        return bomName;
    }
    public void setFactoryId(Long factoryId)
    {
        this.factoryId = factoryId;
    }

    public Long getFactoryId()
    {
        return factoryId;
    }
    public void setProductionLine(String productionLine)
    {
        this.productionLine = productionLine;
    }

    public String getProductionLine()
    {
        return productionLine;
    }
    public void setTechnologyId(Long technologyId)
    {
        this.technologyId = technologyId;
    }

    public Long getTechnologyId()
    {
        return technologyId;
    }
    public void setTechnologyName(String technologyName)
    {
        this.technologyName = technologyName;
    }

    public String getTechnologyName()
    {
        return technologyName;
    }
    public void setProjectId(Long projectId)
    {
        this.projectId = projectId;
    }

    public Long getProjectId()
    {
        return projectId;
    }
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectName()
    {
        return projectName;
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

    public List<MesPlannedProductionItemVo> getMesPlannedProductionItemList()
    {
        return mesPlannedProductionItemList;
    }

    public void setMesPlannedProductionItemList(List<MesPlannedProductionItemVo> mesPlannedProductionItemList)
    {
        this.mesPlannedProductionItemList = mesPlannedProductionItemList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("serialNo", getSerialNo())
            .append("productionPlanId", getProductionPlanId())
            .append("planNumber", getPlanNumber())
            .append("materialId", getMaterialId())
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialSpecifications", getMaterialSpecifications())
            .append("materialUnit", getMaterialUnit())
            .append("bomId", getBomId())
            .append("bomName", getBomName())
            .append("factoryId", getFactoryId())
            .append("productionLine", getProductionLine())
            .append("technologyId", getTechnologyId())
            .append("technologyName", getTechnologyName())
            .append("projectId", getProjectId())
            .append("projectName", getProjectName())
            .append("producedQuantity", getProducedQuantity())
            .append("quantityProduced", getQuantityProduced())
            .append("manufactureDate", getManufactureDate())
            .append("deliveryDate", getDeliveryDate())
            .append("pickingStatus", getPickingStatus())
            .append("status", getStatus())
            .append("mesPlannedProductionItemList", getMesPlannedProductionItemList())
            .toString();
    }
}
