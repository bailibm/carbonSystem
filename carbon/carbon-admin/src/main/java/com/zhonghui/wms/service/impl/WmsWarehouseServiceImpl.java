package com.zhonghui.wms.service.impl;

import com.zhonghui.common.utils.StringUtils;
import com.zhonghui.wms.domain.WmsWarehouse;
import com.zhonghui.wms.domain.WmsWarehouseArea;
import com.zhonghui.wms.mapper.WmsWarehouseMapper;
import com.zhonghui.wms.service.IWmsWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 仓库Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-20
 */
@Service
public class WmsWarehouseServiceImpl implements IWmsWarehouseService 
{
    @Autowired
    private WmsWarehouseMapper wmsWarehouseMapper;

    /**
     * 查询仓库
     * 
     * @param id 仓库主键
     * @return 仓库
     */
    @Override
    public WmsWarehouse selectWmsWarehouseById(Long id)
    {
        return wmsWarehouseMapper.selectWmsWarehouseById(id);
    }

    /**
     * 查询仓库列表
     * 
     * @param wmsWarehouse 仓库
     * @return 仓库
     */
    @Override
    public List<WmsWarehouse> selectWmsWarehouseList(WmsWarehouse wmsWarehouse)
    {
        return wmsWarehouseMapper.selectWmsWarehouseList(wmsWarehouse);
    }

    /**
     * 新增仓库
     * 
     * @param wmsWarehouse 仓库
     * @return 结果
     */
    @Transactional
    @Override
    public int insertWmsWarehouse(WmsWarehouse wmsWarehouse)
    {
        int rows = wmsWarehouseMapper.insertWmsWarehouse(wmsWarehouse);
        insertWmsWarehouseArea(wmsWarehouse);
        return rows;
    }

    /**
     * 修改仓库
     * 
     * @param wmsWarehouse 仓库
     * @return 结果
     */
    @Transactional
    @Override
    public int updateWmsWarehouse(WmsWarehouse wmsWarehouse)
    {
        wmsWarehouseMapper.deleteWmsWarehouseAreaByWarehouseId(wmsWarehouse.getId());
        insertWmsWarehouseArea(wmsWarehouse);
        return wmsWarehouseMapper.updateWmsWarehouse(wmsWarehouse);
    }

    /**
     * 批量删除仓库
     * 
     * @param ids 需要删除的仓库主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteWmsWarehouseByIds(Long[] ids)
    {
        wmsWarehouseMapper.deleteWmsWarehouseAreaByWarehouseIds(ids);
        return wmsWarehouseMapper.deleteWmsWarehouseByIds(ids);
    }

    /**
     * 删除仓库信息
     * 
     * @param id 仓库主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteWmsWarehouseById(Long id)
    {
        wmsWarehouseMapper.deleteWmsWarehouseAreaByWarehouseId(id);
        return wmsWarehouseMapper.deleteWmsWarehouseById(id);
    }

    /**
     * 新增库区信息
     * 
     * @param wmsWarehouse 仓库对象
     */
    public void insertWmsWarehouseArea(WmsWarehouse wmsWarehouse)
    {
        List<WmsWarehouseArea> wmsWarehouseAreaList = wmsWarehouse.getWmsWarehouseAreaList();
        Long id = wmsWarehouse.getId();
        if (StringUtils.isNotNull(wmsWarehouseAreaList))
        {
            List<WmsWarehouseArea> list = new ArrayList<WmsWarehouseArea>();
            for (WmsWarehouseArea wmsWarehouseArea : wmsWarehouseAreaList)
            {
                wmsWarehouseArea.setWarehouseId(id);
                list.add(wmsWarehouseArea);
            }
            if (list.size() > 0)
            {
                wmsWarehouseMapper.batchWmsWarehouseArea(list);
            }
        }
    }
}
