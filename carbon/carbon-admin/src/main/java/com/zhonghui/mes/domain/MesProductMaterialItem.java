package com.zhonghui.mes.domain;

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
public class MesProductMaterialItem extends BaseEntity
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productId", getProductId())
            .append("materialId", getMaterialId())
            .append("remark", getRemark())
            .toString();
    }
}
