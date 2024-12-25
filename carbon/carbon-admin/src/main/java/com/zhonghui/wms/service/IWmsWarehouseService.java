package com.zhonghui.wms.service;

import com.zhonghui.wms.domain.WmsWarehouse;

import java.util.List;

/**
 * 仓库Service接口
 * 
 * @author zhonghui
 * @date 2022-05-20
 */
public interface IWmsWarehouseService 
{
    /**
     * 查询仓库
     * 
     * @param id 仓库主键
     * @return 仓库
     */
    public WmsWarehouse selectWmsWarehouseById(Long id);

    /**
     * 查询仓库列表
     * 
     * @param wmsWarehouse 仓库
     * @return 仓库集合
     */
    public List<WmsWarehouse> selectWmsWarehouseList(WmsWarehouse wmsWarehouse);

    /**
     * 新增仓库
     * 
     * @param wmsWarehouse 仓库
     * @return 结果
     */
    public int insertWmsWarehouse(WmsWarehouse wmsWarehouse);

    /**
     * 修改仓库
     * 
     * @param wmsWarehouse 仓库
     * @return 结果
     */
    public int updateWmsWarehouse(WmsWarehouse wmsWarehouse);

    /**
     * 批量删除仓库
     * 
     * @param ids 需要删除的仓库主键集合
     * @return 结果
     */
    public int deleteWmsWarehouseByIds(Long[] ids);

    /**
     * 删除仓库信息
     * 
     * @param id 仓库主键
     * @return 结果
     */
    public int deleteWmsWarehouseById(Long id);
}
