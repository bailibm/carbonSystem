package com.zhonghui.wms.service.impl;

import com.zhonghui.common.utils.StringUtils;
import com.zhonghui.wms.domain.WmsWarehouseArea;
import com.zhonghui.wms.domain.WmsWarehouseSeat;
import com.zhonghui.wms.mapper.WmsWarehouseAreaMapper;
import com.zhonghui.wms.service.IWmsWarehouseAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 库区Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-26
 */
@Service
public class WmsWarehouseAreaServiceImpl implements IWmsWarehouseAreaService 
{
    @Autowired
    private WmsWarehouseAreaMapper wmsWarehouseAreaMapper;

    /**
     * 查询库区
     * 
     * @param id 库区主键
     * @return 库区
     */
    @Override
    public WmsWarehouseArea selectWmsWarehouseAreaById(Long id)
    {
        return wmsWarehouseAreaMapper.selectWmsWarehouseAreaById(id);
    }

    /**
     * 查询库区列表
     * 
     * @param wmsWarehouseArea 库区
     * @return 库区
     */
    @Override
    public List<WmsWarehouseArea> selectWmsWarehouseAreaList(WmsWarehouseArea wmsWarehouseArea)
    {
        return wmsWarehouseAreaMapper.selectWmsWarehouseAreaList(wmsWarehouseArea);
    }

    /**
     * 新增库区
     * 
     * @param wmsWarehouseArea 库区
     * @return 结果
     */
    @Transactional
    @Override
    public int insertWmsWarehouseArea(WmsWarehouseArea wmsWarehouseArea)
    {
        int rows = wmsWarehouseAreaMapper.insertWmsWarehouseArea(wmsWarehouseArea);
        insertWmsWarehouseSeat(wmsWarehouseArea);
        return rows;
    }

    /**
     * 修改库区
     * 
     * @param wmsWarehouseArea 库区
     * @return 结果
     */
    @Transactional
    @Override
    public int updateWmsWarehouseArea(WmsWarehouseArea wmsWarehouseArea)
    {
        wmsWarehouseAreaMapper.deleteWmsWarehouseSeatByWarehouseAreaId(wmsWarehouseArea.getId());
        insertWmsWarehouseSeat(wmsWarehouseArea);
        return wmsWarehouseAreaMapper.updateWmsWarehouseArea(wmsWarehouseArea);
    }

    /**
     * 批量删除库区
     * 
     * @param ids 需要删除的库区主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteWmsWarehouseAreaByIds(Long[] ids)
    {
        wmsWarehouseAreaMapper.deleteWmsWarehouseSeatByWarehouseAreaIds(ids);
        return wmsWarehouseAreaMapper.deleteWmsWarehouseAreaByIds(ids);
    }

    /**
     * 删除库区信息
     * 
     * @param id 库区主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteWmsWarehouseAreaById(Long id)
    {
        wmsWarehouseAreaMapper.deleteWmsWarehouseSeatByWarehouseAreaId(id);
        return wmsWarehouseAreaMapper.deleteWmsWarehouseAreaById(id);
    }

    /**
     * 新增库位信息
     * 
     * @param wmsWarehouseArea 库区对象
     */
    public void insertWmsWarehouseSeat(WmsWarehouseArea wmsWarehouseArea)
    {
        List<WmsWarehouseSeat> wmsWarehouseSeatList = wmsWarehouseArea.getWmsWarehouseSeatList();
        Long id = wmsWarehouseArea.getId();
        if (StringUtils.isNotNull(wmsWarehouseSeatList))
        {
            List<WmsWarehouseSeat> list = new ArrayList<WmsWarehouseSeat>();
            for (WmsWarehouseSeat wmsWarehouseSeat : wmsWarehouseSeatList)
            {
                wmsWarehouseSeat.setWarehouseAreaId(id);
                list.add(wmsWarehouseSeat);
            }
            if (list.size() > 0)
            {
                wmsWarehouseAreaMapper.batchWmsWarehouseSeat(list);
            }
        }
    }
}
