package com.zhonghui.mes.domain;

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
public class MesBom extends BaseEntity
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

    /** BOM单明细信息 */
    @ApiModelProperty("BOM单明细信息")
    private List<MesBomDetailItem> mesBomDetailItemList;

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

    public List<MesBomDetailItem> getMesBomDetailItemList()
    {
        return mesBomDetailItemList;
    }

    public void setMesBomDetailItemList(List<MesBomDetailItem> mesBomDetailItemList)
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
            .append("mesBomDetailItemList", getMesBomDetailItemList())
            .toString();
    }
}
