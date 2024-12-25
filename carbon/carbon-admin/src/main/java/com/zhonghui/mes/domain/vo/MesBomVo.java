package com.zhonghui.mes.domain.vo;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * Bom对象 mes_bom
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
@ApiModel("Bom对象")
public class MesBomVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    @ApiModelProperty("编号")
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    @ApiModelProperty("名称")
    private String name;

    /** 产品id */
    @Excel(name = "产品id")
    @ApiModelProperty("产品id")
    private Long productId;

    /** 物料id */
    @Excel(name = "物料id")
    @ApiModelProperty("物料id")
    private Long materialId;

    /** 描述 */
    @ApiModelProperty("描述")
    private String bomDescribe;

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

    /** BOM单明细信息 */
    @ApiModelProperty("BOM单明细信息")
    private List<MesBomDetailItemVo> mesBomDetailItemList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setProductId(Long productId)
    {
        this.productId = productId;
    }

    public Long getProductId()
    {
        return productId;
    }
    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }

    public Long getMaterialId()
    {
        return materialId;
    }
    public void setBomDescribe(String bomDescribe) 
    {
        this.bomDescribe = bomDescribe;
    }

    public String getBomDescribe() 
    {
        return bomDescribe;
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

    public List<MesBomDetailItemVo> getMesBomDetailItemList()
    {
        return mesBomDetailItemList;
    }

    public void setMesBomDetailItemList(List<MesBomDetailItemVo> mesBomDetailItemList)
    {
        this.mesBomDetailItemList = mesBomDetailItemList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("productId", getProductId())
            .append("materialId", getMaterialId())
            .append("bomDescribe", getBomDescribe())
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialSpecifications", getMaterialSpecifications())
            .append("materialUnit", getMaterialUnit())
            .append("mesBomDetailItemList", getMesBomDetailItemList())
            .toString();
    }
}
