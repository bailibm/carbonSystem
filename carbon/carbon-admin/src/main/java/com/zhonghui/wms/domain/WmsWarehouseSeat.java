package com.zhonghui.wms.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 库位对象 wms_warehouse_seat
 * 
 * @author zhonghui
 * @date 2022-05-26
 */
@ApiModel("库位对象")
public class WmsWarehouseSeat extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库位ID */
    private Long id;

    /** 库区ID */
    @Excel(name = "库区ID")
    @ApiModelProperty("库区ID")
    private Long warehouseAreaId;

    /** 库位编码 */
    @Excel(name = "库位编码")
    @ApiModelProperty("库位编码")
    private String seatCode;

    /** 库位名称 */
    @Excel(name = "库位名称")
    @ApiModelProperty("库位名称")
    private String seatName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setWarehouseAreaId(Long warehouseAreaId) 
    {
        this.warehouseAreaId = warehouseAreaId;
    }

    public Long getWarehouseAreaId() 
    {
        return warehouseAreaId;
    }
    public void setSeatCode(String seatCode) 
    {
        this.seatCode = seatCode;
    }

    public String getSeatCode() 
    {
        return seatCode;
    }
    public void setSeatName(String seatName) 
    {
        this.seatName = seatName;
    }

    public String getSeatName() 
    {
        return seatName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("warehouseAreaId", getWarehouseAreaId())
            .append("seatCode", getSeatCode())
            .append("seatName", getSeatName())
            .toString();
    }
}