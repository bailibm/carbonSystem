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
 * 生产计划对象 mes_production_plan
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
@ApiModel("生产计划对象")
public class MesProductionPlanVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    @ApiModelProperty("编号")
    private Long id;

    /** 计划号 */
    @Excel(name = "计划号")
    @ApiModelProperty("计划号")
    private String planNumber;

    /** 订单id */
    @Excel(name = "订单id")
    @ApiModelProperty("订单id")
    private Long saleOrderId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    @ApiModelProperty("订单编号")
    private String saleOrderNo;

    /** 项目id */
    @Excel(name = "项目id")
    @ApiModelProperty("项目id")
    private Long projectId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    @ApiModelProperty("项目名称")
    private String projectName;

    /** 名称 */
    @Excel(name = "名称")
    @ApiModelProperty("名称")
    private String name;

    /** 交货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "交货日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("交货日期")
    private Date deliveryDate;

    /** 申请人 */
    @Excel(name = "申请人")
    @ApiModelProperty("申请人")
    private Long applicant;

    /** 申请人姓名 */
    @Excel(name = "申请人姓名")
    @ApiModelProperty("申请人姓名")
    private String applicantName;

    /** 申请时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("申请时间")
    private Date applicantDate;

    /** 申请状态 */
    @Excel(name = "申请状态")
    @ApiModelProperty("申请状态")
    private Integer applicantStatus;

    /** 审核人 */
    @Excel(name = "审核人")
    @ApiModelProperty("审核人")
    private Long reviewer;

    /** 审核人姓名 */
    @Excel(name = "审核人姓名")
    @ApiModelProperty("审核人姓名")
    private String reviewerName;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("审核时间")
    private Date reviewerDate;

    /** 审核状态 */
    @Excel(name = "审核状态")
    @ApiModelProperty("审核状态")
    private Integer reviewerStatus;

    /** 审核意见 */
    @ApiModelProperty("审核意见")
    private String reviewComments;

    /** 生产计划-生产计划明细信息 */
    @ApiModelProperty("生产计划明细信息")
    private List<MesProductionPlanItemVo> mesProductionPlanItemList;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPlanNumber(String planNumber)
    {
        this.planNumber = planNumber;
    }

    public String getPlanNumber()
    {
        return planNumber;
    }
    public void setSaleOrderId(Long saleOrderId)
    {
        this.saleOrderId = saleOrderId;
    }

    public Long getSaleOrderId()
    {
        return saleOrderId;
    }
    public void setSaleOrderNo(String saleOrderNo)
    {
        this.saleOrderNo = saleOrderNo;
    }

    public String getSaleOrderNo()
    {
        return saleOrderNo;
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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDeliveryDate(Date deliveryDate) 
    {
        this.deliveryDate = deliveryDate;
    }

    public Date getDeliveryDate() 
    {
        return deliveryDate;
    }
    public void setApplicant(Long applicant)
    {
        this.applicant = applicant;
    }

    public Long getApplicant()
    {
        return applicant;
    }
    public void setApplicantName(String applicantName)
    {
        this.applicantName = applicantName;
    }

    public String getApplicantName()
    {
        return applicantName;
    }
    public void setApplicantDate(Date applicantDate) 
    {
        this.applicantDate = applicantDate;
    }

    public Date getApplicantDate() 
    {
        return applicantDate;
    }
    public void setApplicantStatus(Integer applicantStatus)
    {
        this.applicantStatus = applicantStatus;
    }

    public Integer getApplicantStatus()
    {
        return applicantStatus;
    }
    public void setReviewer(Long reviewer)
    {
        this.reviewer = reviewer;
    }

    public Long getReviewer()
    {
        return reviewer;
    }
    public void setReviewerName(String reviewerName)
    {
        this.reviewerName = reviewerName;
    }

    public String getReviewerName()
    {
        return reviewerName;
    }
    public void setReviewerDate(Date reviewerDate) 
    {
        this.reviewerDate = reviewerDate;
    }

    public Date getReviewerDate() 
    {
        return reviewerDate;
    }
    public void setReviewerStatus(Integer reviewerStatus)
    {
        this.reviewerStatus = reviewerStatus;
    }

    public Integer getReviewerStatus()
    {
        return reviewerStatus;
    }
    public void setReviewComments(String reviewComments) 
    {
        this.reviewComments = reviewComments;
    }

    public String getReviewComments() 
    {
        return reviewComments;
    }

    public List<MesProductionPlanItemVo> getMesProductionPlanItemList()
    {
        return mesProductionPlanItemList;
    }

    public void setMesProductionPlanItemList(List<MesProductionPlanItemVo> mesProductionPlanItemList)
    {
        this.mesProductionPlanItemList = mesProductionPlanItemList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("planNumber", getPlanNumber())
            .append("saleOrderId", getSaleOrderId())
            .append("saleOrderNo", getSaleOrderNo())
            .append("projectId", getProjectId())
            .append("projectName", getProjectName())
            .append("name", getName())
            .append("deliveryDate", getDeliveryDate())
            .append("applicant", getApplicant())
            .append("applicantName", getApplicantName())
            .append("applicantDate", getApplicantDate())
            .append("applicantStatus", getApplicantStatus())
            .append("reviewer", getReviewer())
            .append("reviewerName", getReviewerName())
            .append("reviewerDate", getReviewerDate())
            .append("reviewerStatus", getReviewerStatus())
            .append("remark", getRemark())
            .append("reviewComments", getReviewComments())
            .append("mesProductionPlanItemList", getMesProductionPlanItemList())
            .toString();
    }
}
