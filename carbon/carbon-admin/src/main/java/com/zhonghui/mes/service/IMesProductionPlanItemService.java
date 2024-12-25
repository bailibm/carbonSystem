package com.zhonghui.mes.service;

import com.zhonghui.mes.domain.MesProductionPlanItem;
import com.zhonghui.mes.domain.vo.MesProductionPlanItemVo;

import java.util.List;

/**
 * 生产计划明细Service接口
 * 
 * @author zhonghui
 * @date 2022-05-24
 */
public interface IMesProductionPlanItemService 
{
    /**
     * 查询生产计划明细
     * 
     * @param id 生产计划明细主键
     * @return 生产计划明细
     */
    public MesProductionPlanItem selectMesProductionPlanItemById(Long id);

    /**
     * 查询生产计划明细列表
     * 
     * @param mesProductionPlanItemVo 生产计划明细
     * @return 生产计划明细集合
     */
    public List<MesProductionPlanItemVo> selectMesProductionPlanItemList(MesProductionPlanItemVo mesProductionPlanItemVo);

    /**
     * 新增生产计划明细
     * 
     * @param mesProductionPlanItem 生产计划明细
     * @return 结果
     */
    public int insertMesProductionPlanItem(MesProductionPlanItem mesProductionPlanItem);

    /**
     * 修改生产计划明细
     * 
     * @param mesProductionPlanItem 生产计划明细
     * @return 结果
     */
    public int updateMesProductionPlanItem(MesProductionPlanItem mesProductionPlanItem);

    /**
     * 批量删除生产计划明细
     * 
     * @param ids 需要删除的生产计划明细主键集合
     * @return 结果
     */
    public int deleteMesProductionPlanItemByIds(Long[] ids);

    /**
     * 删除生产计划明细信息
     * 
     * @param id 生产计划明细主键
     * @return 结果
     */
    public int deleteMesProductionPlanItemById(Long id);
}
