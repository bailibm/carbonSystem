package com.zhonghui.mes.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 产品建模对象 mes_product
 * 
 * @author zhonghui
 * @date 2022-05-20
 */
@ApiModel("产品建模对象")
public class MesProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    @ApiModelProperty("编号")
    private Long id;

    /** 模型名称 */
    @Excel(name = "模型名称")
    @ApiModelProperty("模型名称")
    private String modeName;

    /** 物料id */
    @Excel(name = "物料id")
    @ApiModelProperty("物料id")
    private Long materialId;

    /** 产品物料子信息 */
    @ApiModelProperty("产品物料子信息")
    private List<MesProductMaterialItem> mesProductMaterialItemList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setModeName(String modeName) 
    {
        this.modeName = modeName;
    }

    public String getModeName() 
    {
        return modeName;
    }
    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }

    public Long getMaterialId()
    {
        return materialId;
    }
    public List<MesProductMaterialItem> getMesProductMaterialItemList()
    {
        return mesProductMaterialItemList;
    }

    public void setMesProductMaterialItemList(List<MesProductMaterialItem> mesProductMaterialItemList)
    {
        this.mesProductMaterialItemList = mesProductMaterialItemList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("modeName", getModeName())
            .append("materialId", getMaterialId())
            .append("remark", getRemark())
            .append("mesProductMaterialItemList", getMesProductMaterialItemList())
            .toString();
    }
}
