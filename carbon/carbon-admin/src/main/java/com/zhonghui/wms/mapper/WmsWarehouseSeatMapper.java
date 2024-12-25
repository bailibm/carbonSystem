package com.zhonghui.wms.mapper;

import com.zhonghui.wms.domain.WmsWarehouseSeat;

import java.util.List;

/**
 * 库位Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-27
 */
public interface WmsWarehouseSeatMapper 
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
     * 删除库位
     * 
     * @param id 库位主键
     * @return 结果
     */
    public int deleteWmsWarehouseSeatById(Long id);

    /**
     * 批量删除库位
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmsWarehouseSeatByIds(Long[] ids);
}
