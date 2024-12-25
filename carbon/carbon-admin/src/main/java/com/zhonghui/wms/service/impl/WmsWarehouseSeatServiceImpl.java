package com.zhonghui.wms.service.impl;

import com.zhonghui.wms.domain.WmsWarehouseSeat;
import com.zhonghui.wms.mapper.WmsWarehouseSeatMapper;
import com.zhonghui.wms.service.IWmsWarehouseSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 库位Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-27
 */
@Service
public class WmsWarehouseSeatServiceImpl implements IWmsWarehouseSeatService 
{
    @Autowired
    private WmsWarehouseSeatMapper wmsWarehouseSeatMapper;

    /**
     * 查询库位
     * 
     * @param id 库位主键
     * @return 库位
     */
    @Override
    public WmsWarehouseSeat selectWmsWarehouseSeatById(Long id)
    {
        return wmsWarehouseSeatMapper.selectWmsWarehouseSeatById(id);
    }

    /**
     * 查询库位列表
     * 
     * @param wmsWarehouseSeat 库位
     * @return 库位
     */
    @Override
    public List<WmsWarehouseSeat> selectWmsWarehouseSeatList(WmsWarehouseSeat wmsWarehouseSeat)
    {
        return wmsWarehouseSeatMapper.selectWmsWarehouseSeatList(wmsWarehouseSeat);
    }

    /**
     * 新增库位
     * 
     * @param wmsWarehouseSeat 库位
     * @return 结果
     */
    @Override
    public int insertWmsWarehouseSeat(WmsWarehouseSeat wmsWarehouseSeat)
    {
        return wmsWarehouseSeatMapper.insertWmsWarehouseSeat(wmsWarehouseSeat);
    }

    /**
     * 修改库位
     * 
     * @param wmsWarehouseSeat 库位
     * @return 结果
     */
    @Override
    public int updateWmsWarehouseSeat(WmsWarehouseSeat wmsWarehouseSeat)
    {
        return wmsWarehouseSeatMapper.updateWmsWarehouseSeat(wmsWarehouseSeat);
    }

    /**
     * 批量删除库位
     * 
     * @param ids 需要删除的库位主键
     * @return 结果
     */
    @Override
    public int deleteWmsWarehouseSeatByIds(Long[] ids)
    {
        return wmsWarehouseSeatMapper.deleteWmsWarehouseSeatByIds(ids);
    }

    /**
     * 删除库位信息
     * 
     * @param id 库位主键
     * @return 结果
     */
    @Override
    public int deleteWmsWarehouseSeatById(Long id)
    {
        return wmsWarehouseSeatMapper.deleteWmsWarehouseSeatById(id);
    }
}
