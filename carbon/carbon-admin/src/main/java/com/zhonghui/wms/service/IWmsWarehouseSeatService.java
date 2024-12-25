package com.zhonghui.wms.service;

import com.zhonghui.wms.domain.WmsWarehouseSeat;

import java.util.List;

/**
 * 库位Service接口
 * 
 * @author zhonghui
 * @date 2022-05-27
 */
public interface IWmsWarehouseSeatService 
{
    /**
     * 查询库位
     * 
     * @param id 库位主键
     * @return 库位
     */
    public WmsWarehouseSeat selectWmsWarehouseSeatById(Long id);

    /**
     * 查询库位列表
     * 
     * @param wmsWarehouseSeat 库位
     * @return 库位集合
     */
    public List<WmsWarehouseSeat> selectWmsWarehouseSeatList(WmsWarehouseSeat wmsWarehouseSeat);

    /**
     * 新增库位
     * 
     * @param wmsWarehouseSeat 库位
     * @return 结果
     */
    public int insertWmsWarehouseSeat(WmsWarehouseSeat wmsWarehouseSeat);

    /**
     * 修改库位
     * 
     * @param wmsWarehouseSeat 库位
     * @return 结果
     */
    public int updateWmsWarehouseSeat(WmsWarehouseSeat wmsWarehouseSeat);

    /**
     * 批量删除库位
     * 
     * @param ids 需要删除的库位主键集合
     * @return 结果
     */
    public int deleteWmsWarehouseSeatByIds(Long[] ids);

    /**
     * 删除库位信息
     * 
     * @param id 库位主键
     * @return 结果
     */
    public int deleteWmsWarehouseSeatById(Long id);
}
