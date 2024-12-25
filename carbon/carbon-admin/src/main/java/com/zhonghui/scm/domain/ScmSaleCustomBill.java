package com.zhonghui.scm.domain;


import com.zhonghui.common.core.domain.BaseEntity;

public class ScmSaleCustomBill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Integer typeName;

    private Long customId;

    private String customName;

    private Long totalAmount;

    private String year;

    private Integer type;

    public Integer getTypeName() {
        return typeName;
    }

    public void setTypeName(Integer typeName) {
        this.typeName = typeName;
    }

    public Long getCustomId() {
        return customId;
    }

    public void setCustomId(Long customId) {
        this.customId = customId;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ScmSaleCustomBill{" +
                "typeName=" + typeName +
                ", customId=" + customId +
                ", customName='" + customName + '\'' +
                ", totalAmount=" + totalAmount +
                ", year='" + year + '\'' +
                ", type=" + type +
                '}';
    }
}
