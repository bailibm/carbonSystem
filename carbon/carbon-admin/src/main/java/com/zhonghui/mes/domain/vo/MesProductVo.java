package com.zhonghui.mes.domain.vo;

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
public class MesProductVo extends BaseEntity
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

    /** 产品物料子信息 */
    @ApiModelProperty("产品物料子信息")
    private List<MesProductMaterialItemVo> mesProductMaterialItemList;

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
    public List<MesProductMaterialItemVo> getMesProductMaterialItemList()
    {
        return mesProductMaterialItemList;
    }

    public void setMesProductMaterialItemList(List<MesProductMaterialItemVo> mesProductMaterialItemList)
    {
        this.mesProductMaterialItemList = mesProductMaterialItemList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("modeName", getModeName())
            .append("materialId", getMaterialId())
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialSpecifications", getMaterialSpecifications())
            .append("materialUnit", getMaterialUnit())
            .append("remark", getRemark())
            .append("mesProductMaterialItemList", getMesProductMaterialItemList())
            .toString();
    }
}
