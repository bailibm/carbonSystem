package com.zhonghui.mes.service.impl;

import com.zhonghui.common.utils.StringUtils;
import com.zhonghui.mes.domain.MesFactory;
import com.zhonghui.mes.domain.MesFactoryDeviceItem;
import com.zhonghui.mes.domain.vo.MesFactoryVo;
import com.zhonghui.mes.mapper.MesFactoryMapper;
import com.zhonghui.mes.service.IMesFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 工厂建模Service业务层处理
 *
 * @author carbon
 * @date 2022-05-20
 */
@Service
public class MesFactoryServiceImpl implements IMesFactoryService
{
    @Autowired
    private MesFactoryMapper mesFactoryMapper;

    /**
     * 查询工厂建模
     *
     * @param id 工厂建模主键
     * @return 工厂建模
     */
    @Override
    public MesFactoryVo selectMesFactoryById(Long id)
    {
        return mesFactoryMapper.selectMesFactoryById(id);
    }

    /**
     * 查询工厂建模列表
     *
     * @param mesFactory 工厂建模
     * @return 工厂建模
     */
    @Override
    public List<MesFactory> selectMesFactoryList(MesFactory mesFactory)
    {
        return mesFactoryMapper.selectMesFactoryList(mesFactory);
    }

    /**
     * 新增工厂建模
     *
     * @param mesFactory 工厂建模
     * @return 结果
     */
    @Transactional
    @Override
    public int insertMesFactory(MesFactory mesFactory)
    {
        int rows = mesFactoryMapper.insertMesFactory(mesFactory);
        insertMesFactoryDeviceItem(mesFactory);
        return rows;
    }

    /**
     * 修改工厂建模
     *
     * @param mesFactory 工厂建模
     * @return 结果
     */
    @Transactional
    @Override
    public int updateMesFactory(MesFactory mesFactory)
    {
        mesFactoryMapper.deleteMesFactoryDeviceItemByFactoryId(mesFactory.getId());
        insertMesFactoryDeviceItem(mesFactory);
        return mesFactoryMapper.updateMesFactory(mesFactory);
    }

    /**
     * 批量删除工厂建模
     *
     * @param ids 需要删除的工厂建模主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMesFactoryByIds(Long[] ids)
    {
        mesFactoryMapper.deleteMesFactoryDeviceItemByFactoryIds(ids);
        return mesFactoryMapper.deleteMesFactoryByIds(ids);
    }

    /**
     * 删除工厂建模信息
     *
     * @param id 工厂建模主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMesFactoryById(Long id)
    {
        mesFactoryMapper.deleteMesFactoryDeviceItemByFactoryId(id);
        return mesFactoryMapper.deleteMesFactoryById(id);
    }

    /**
     * 新增工厂建模设备信息子信息
     *
     * @param mesFactory 工厂建模对象
     */
    public void insertMesFactoryDeviceItem(MesFactory mesFactory)
    {
        List<MesFactoryDeviceItem> mesFactoryDeviceItemList = mesFactory.getMesFactoryDeviceItemList();
        Long id = mesFactory.getId();
        if (StringUtils.isNotNull(mesFactoryDeviceItemList))
        {
            List<MesFactoryDeviceItem> list = new ArrayList<MesFactoryDeviceItem>();
            for (MesFactoryDeviceItem mesFactoryDeviceItem : mesFactoryDeviceItemList)
            {
                mesFactoryDeviceItem.setFactoryId(id);
                list.add(mesFactoryDeviceItem);
            }
            if (list.size() > 0)
            {
                mesFactoryMapper.batchMesFactoryDeviceItem(list);
            }
        }
    }
}
