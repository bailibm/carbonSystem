package com.zhonghui.mes.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 工厂建模设备信息子对象 mes_factory_device_item
 *
 * @author carbon
 * @date 2022-05-20
 */
@ApiModel("工厂建模设备信息子对象")
public class MesFactoryDeviceItem extends BaseEntity
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("factoryId", getFactoryId())
                .append("deviceId",getDeviceId())
                .toString();
    }
}
