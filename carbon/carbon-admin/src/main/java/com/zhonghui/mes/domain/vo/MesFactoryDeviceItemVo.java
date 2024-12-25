package com.zhonghui.mes.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 工厂建模设备信息子对象 mes_factory_device_item
 * 
 * @author carbon
 * @date 2022-05-20
 */
@ApiModel("工厂建模设备信息子对象")
public class MesFactoryDeviceItemVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @ApiModelProperty("编号")
    private Long id;

    /** 工厂建模ID */
    @Excel(name = "工厂建模ID")
    @ApiModelProperty("工厂建模ID")
    private Long factoryId;

    /** 设备ID */
    @Excel(name = "设备ID")
    @ApiModelProperty("设备ID")
    private Long deviceId;

    /** 名称 */
    @Excel(name = "名称")
    @ApiModelProperty("名称")
    private String deviceName;

    /** 编码 */
    @Excel(name = "编码")
    @ApiModelProperty("编码")
    private String deviceCode;

    /** 型号 */
    @Excel(name = "型号")
    @ApiModelProperty("型号")
    private String deviceModel;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("生产日期")
    private Date produceDate;

    /** 生产批号 */
    @Excel(name = "生产批号")
    @ApiModelProperty("生产批号")
    private String produceCode;

    /** 制造商 */
    @Excel(name = "制造商")
    @ApiModelProperty("制造商")
    private String manufacturer;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFactoryId(Long factoryId) 
    {
        this.factoryId = factoryId;
    }

    public Long getFactoryId() 
    {
        return factoryId;
    }
    public void setDeviceId(Long deviceId)
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId()
    {
        return deviceId;
    }
    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName()
    {
        return deviceName;
    }
    public void setDeviceCode(String deviceCode)
    {
        this.deviceCode = deviceCode;
    }

    public String getDeviceCode()
    {
        return deviceCode;
    }
    public void setDeviceModel(String deviceModel)
    {
        this.deviceModel = deviceModel;
    }

    public String getDeviceModel()
    {
        return deviceModel;
    }
    public void setProduceDate(Date produceDate)
    {
        this.produceDate = produceDate;
    }

    public Date getProduceDate()
    {
        return produceDate;
    }
    public void setProduceCode(String produceCode)
    {
        this.produceCode = produceCode;
    }

    public String getProduceCode()
    {
        return produceCode;
    }
    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("factoryId", getFactoryId())
            .append("deviceId",getDeviceId())
            .append("deviceName", getDeviceName())
            .append("deviceCode", getDeviceCode())
            .append("deviceModel", getDeviceModel())
            .append("produceDate", getProduceDate())
            .append("produceCode", getProduceCode())
            .append("manufacturer", getManufacturer())
            .toString();
    }
}
