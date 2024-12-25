package com.zhonghui.mes.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * BOM单明细信息子对象 mes_bom_detail_item
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
@ApiModel("BOM单明细信息子对象")
public class MesBomDetailItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @ApiModelProperty("编号")
    private String id;

    /** 物料id */
    @Excel(name = "物料id")
    @ApiModelProperty("物料id")
    private Long materialId;

    /** 用量 */
    @Excel(name = "用量")
    @ApiModelProperty("用量")
    private String dosage;

    /** BomId */
    @Excel(name = "BomId")
    @ApiModelProperty("BomId")
    private Long bomId;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
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
    public void setDosage(String dosage) 
    {
        this.dosage = dosage;
    }

    public String getDosage() 
    {
        return dosage;
    }
    public void setBomId(Long bomId) 
    {
        this.bomId = bomId;
    }

    public Long getBomId() 
    {
        return bomId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("materialId", getMaterialId())
            .append("dosage", getDosage())
            .append("remark", getRemark())
            .append("bomId", getBomId())
            .toString();
    }
}
