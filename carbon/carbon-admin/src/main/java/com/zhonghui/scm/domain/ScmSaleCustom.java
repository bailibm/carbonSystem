package com.zhonghui.scm.domain;

import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 客户档案对象 scm_sale_custom
 * 
 * @author zhonghui
 * @date 2022-05-19
 */
@ApiModel("销售管理-客户档案对象")
public class ScmSaleCustom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long id;

    private String customName;

    private String abbreviation;

    private String address;

    private String zipCode;

    private String phoneNumber;

    private String accountsBank;

    private String bankAccount;

    private String taxId;

    private String linkman;

    private String linkmanPhoneNumber;

    private String customType;

    private String creditLevel;

    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCustomName(String customName) 
    {
        this.customName = customName;
    }

    public String getCustomName() 
    {
        return customName;
    }
    public void setAbbreviation(String abbreviation) 
    {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() 
    {
        return abbreviation;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setZipCode(String zipCode) 
    {
        this.zipCode = zipCode;
    }

    public String getZipCode() 
    {
        return zipCode;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setAccountsBank(String accountsBank) 
    {
        this.accountsBank = accountsBank;
    }

    public String getAccountsBank() 
    {
        return accountsBank;
    }
    public void setBankAccount(String bankAccount) 
    {
        this.bankAccount = bankAccount;
    }

    public String getBankAccount() 
    {
        return bankAccount;
    }
    public void setTaxId(String taxId) 
    {
        this.taxId = taxId;
    }

    public String getTaxId() 
    {
        return taxId;
    }
    public void setLinkman(String linkman) 
    {
        this.linkman = linkman;
    }

    public String getLinkman() 
    {
        return linkman;
    }
    public void setLinkmanPhoneNumber(String linkmanPhoneNumber) 
    {
        this.linkmanPhoneNumber = linkmanPhoneNumber;
    }

    public String getLinkmanPhoneNumber() 
    {
        return linkmanPhoneNumber;
    }
    public void setCustomType(String customType) 
    {
        this.customType = customType;
    }

    public String getCustomType() 
    {
        return customType;
    }
    public void setCreditLevel(String creditLevel) 
    {
        this.creditLevel = creditLevel;
    }

    public String getCreditLevel() 
    {
        return creditLevel;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("customName", getCustomName())
            .append("abbreviation", getAbbreviation())
            .append("address", getAddress())
            .append("zipCode", getZipCode())
            .append("phoneNumber", getPhoneNumber())
            .append("accountsBank", getAccountsBank())
            .append("bankAccount", getBankAccount())
            .append("taxId", getTaxId())
            .append("linkman", getLinkman())
            .append("linkmanPhoneNumber", getLinkmanPhoneNumber())
            .append("customType", getCustomType())
            .append("creditLevel", getCreditLevel())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .toString();
    }
}
