package com.zhonghui.mes.domain.vo;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 产品物料子对象 mes_product_material_item
 * 
 * @author zhonghui
 * @date 2022-05-20
 */
@ApiModel("产品物料子对象")
public class MesProductMaterialItemVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @ApiModelProperty("编号")
    private Long id;

    /** 产品建模编号 */
    @Excel(name = "产品建模编号")
    @ApiModelProperty("产品建模编号")
    private Long productId;

    /** 物料编号 */
    @Excel(name = "物料编号")
    @ApiModelProperty("物料编号")
    private Long materialId;

    /** 物料名称 */
    @Excel(name = "物料名称")
    @ApiModelProperty("物料名称")
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

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productId", getProductId())
            .append("materialId", getMaterialId())
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialSpecifications", getMaterialSpecifications())
            .append("materialUnit", getMaterialUnit())
            .append("remark", getRemark())
            .toString();
    }
}
