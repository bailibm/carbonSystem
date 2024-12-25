package com.zhonghui.mes.mapper;

import com.zhonghui.mes.domain.MesFactory;
import com.zhonghui.mes.domain.MesFactoryDeviceItem;
import com.zhonghui.mes.domain.vo.MesFactoryVo;

import java.util.List;

/**
 * 工厂建模Mapper接口
 *
 * @author carbon
 * @date 2022-05-20
 */
public interface MesFactoryMapper
{
    /**
     * 查询工厂建模
     *
     * @param id 工厂建模主键
     * @return 工厂建模
     */
    public MesFactoryVo selectMesFactoryById(Long id);

    /**
     * 查询工厂建模列表
     *
     * @param mesFactory 工厂建模
     * @return 工厂建模集合
     */
    public List<MesFactory> selectMesFactoryList(MesFactory mesFactory);

    /**
     * 新增工厂建模
     *
     * @param mesFactory 工厂建模
     * @return 结果
     */
    public int insertMesFactory(MesFactory mesFactory);

    /**
     * 修改工厂建模
     *
     * @param mesFactory 工厂建模
     * @return 结果
     */
    public int updateMesFactory(MesFactory mesFactory);

    /**
     * 删除工厂建模
     *
     * @param id 工厂建模主键
     * @return 结果
     */
    public int deleteMesFactoryById(Long id);

    /**
     * 批量删除工厂建模
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesFactoryByIds(Long[] ids);

    /**
     * 批量删除工厂建模设备信息子
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesFactoryDeviceItemByFactoryIds(Long[] ids);

    /**
     * 批量新增工厂建模设备信息子
     *
     * @param mesFactoryDeviceItemList 工厂建模设备信息子列表
     * @return 结果
     */
    public int batchMesFactoryDeviceItem(List<MesFactoryDeviceItem> mesFactoryDeviceItemList);


    /**
     * 通过工厂建模主键删除工厂建模设备信息子信息
     *
     * @param id 工厂建模ID
     * @return 结果
     */
    public int deleteMesFactoryDeviceItemByFactoryId(Long id);
}
