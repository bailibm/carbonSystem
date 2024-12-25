package com.zhonghui.mes.mapper;

import com.zhonghui.mes.domain.MesProductionPlan;
import com.zhonghui.mes.domain.MesProductionPlanItem;
import com.zhonghui.mes.domain.vo.MesProductionPlanVo;

import java.util.List;

/**
 * 生产计划Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
public interface MesProductionPlanMapper 
{
    /**
     * 查询生产计划
     * 
     * @param id 生产计划主键
     * @return 生产计划
     */
    public MesProductionPlanVo selectMesProductionPlanById(Long id);

    /**
     * 查询生产计划列表
     * 
     * @param mesProductionPlan 生产计划
     * @return 生产计划集合
     */
    public List<MesProductionPlanVo> selectMesProductionPlanList(MesProductionPlan mesProductionPlan);

    /**
     * 新增生产计划
     * 
     * @param mesProductionPlan 生产计划
     * @return 结果
     */
    public int insertMesProductionPlan(MesProductionPlan mesProductionPlan);

    /**
     * 修改生产计划
     * 
     * @param mesProductionPlan 生产计划
     * @return 结果
     */
    public int updateMesProductionPlan(MesProductionPlan mesProductionPlan);

    /**
     * 删除生产计划
     * 
     * @param id 生产计划主键
     * @return 结果
     */
    public int deleteMesProductionPlanById(Long id);

    /**
     * 批量删除生产计划
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesProductionPlanByIds(String[] ids);

    /**
     * 批量删除生产计划-生产计划明细子
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesProductionPlanItemByPlanIds(String[] ids);
    
    /**
     * 批量新增生产计划-生产计划明细子
     * 
     * @param mesProductionPlanItemList 生产计划-生产计划明细子列表
     * @return 结果
     */
    public int batchMesProductionPlanItem(List<MesProductionPlanItem> mesProductionPlanItemList);
    

    /**
     * 通过生产计划主键删除生产计划-生产计划明细子信息
     * 
     * @param id 生产计划ID
     * @return 结果
     */
    public int deleteMesProductionPlanItemByPlanId(Long id);
}
