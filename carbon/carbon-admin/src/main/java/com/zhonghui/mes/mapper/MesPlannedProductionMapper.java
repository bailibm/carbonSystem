package com.zhonghui.mes.mapper;

import com.zhonghui.mes.domain.MesPlannedProduction;
import com.zhonghui.mes.domain.MesPlannedProductionItem;
import com.zhonghui.mes.domain.vo.MesPlannedProductionVo;

import java.util.List;

/**
 * 计划排产Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-22
 */
public interface MesPlannedProductionMapper 
{
    /**
     * 查询计划排产
     * 
     * @param id 计划排产主键
     * @return 计划排产
     */
    public MesPlannedProductionVo selectMesPlannedProductionById(Long id);

    /**
     * 查询计划排产列表
     * 
     * @param mesPlannedProductionVo 计划排产
     * @return 计划排产集合
     */
    public List<MesPlannedProductionVo> selectMesPlannedProductionList(MesPlannedProductionVo mesPlannedProductionVo);

    /**
     * 新增计划排产
     * 
     * @param mesPlannedProduction 计划排产
     * @return 结果
     */
    public int insertMesPlannedProduction(MesPlannedProduction mesPlannedProduction);

    /**
     * 修改计划排产
     * 
     * @param mesPlannedProduction 计划排产
     * @return 结果
     */
    public int updateMesPlannedProduction(MesPlannedProduction mesPlannedProduction);

    /**
     * 删除计划排产
     * 
     * @param id 计划排产主键
     * @return 结果
     */
    public int deleteMesPlannedProductionById(Long id);

    /**
     * 批量删除计划排产
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesPlannedProductionByIds(Long[] ids);

    /**
     * 批量删除计划排产-生产计划子
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesPlannedProductionItemByProductionIds(Long[] ids);
    
    /**
     * 批量新增计划排产-生产计划子
     * 
     * @param mesPlannedProductionItemList 计划排产-生产计划子列表
     * @return 结果
     */
    public int batchMesPlannedProductionItem(List<MesPlannedProductionItem> mesPlannedProductionItemList);


    /**
     * 通过计划排产主键删除计划排产-生产计划子信息
     * 
     * @param id 计划排产ID
     * @return 结果
     */
    public int deleteMesPlannedProductionItemByProductionId(Long id);
}
