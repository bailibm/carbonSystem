package com.zhonghui.mes.service;

import com.zhonghui.mes.domain.MesFactory;
import com.zhonghui.mes.domain.vo.MesFactoryVo;

import java.util.List;

/**
 * 工厂建模Service接口
 *
 * @author carbon
 * @date 2022-05-20
 */
public interface IMesFactoryService
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
     * 批量删除工厂建模
     *
     * @param ids 需要删除的工厂建模主键集合
     * @return 结果
     */
    public int deleteMesFactoryByIds(Long[] ids);

    /**
     * 删除工厂建模信息
     *
     * @param id 工厂建模主键
     * @return 结果
     */
    public int deleteMesFactoryById(Long id);
}
