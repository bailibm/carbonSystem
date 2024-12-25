package com.zhonghui.wms.service;

import com.zhonghui.wms.domain.WmsWarehouseArea;

import java.util.List;

/**
 * 库区Service接口
 * 
 * @author zhonghui
 * @date 2022-05-26
 */
public interface IWmsWarehouseAreaService 
{
    /**
     * 查询库区
     * 
     * @param id 库区主键
     * @return 库区
     */
    public WmsWarehouseArea selectWmsWarehouseAreaById(Long id);

    /**
     * 查询库区列表
     * 
     * @param wmsWarehouseArea 库区
     * @return 库区集合
     */
    public List<WmsWarehouseArea> selectWmsWarehouseAreaList(WmsWarehouseArea wmsWarehouseArea);

    /**
     * 新增库区
     * 
     * @param wmsWarehouseArea 库区
     * @return 结果
     */
    public int insertWmsWarehouseArea(WmsWarehouseArea wmsWarehouseArea);

    /**
     * 修改库区
     * 
     * @param wmsWarehouseArea 库区
     * @return 结果
     */
    public int updateWmsWarehouseArea(WmsWarehouseArea wmsWarehouseArea);

    /**
     * 批量删除库区
     * 
     * @param ids 需要删除的库区主键集合
     * @return 结果
     */
    public int deleteWmsWarehouseAreaByIds(Long[] ids);

    /**
     * 删除库区信息
     * 
     * @param id 库区主键
     * @return 结果
     */
    public int deleteWmsWarehouseAreaById(Long id);
}
