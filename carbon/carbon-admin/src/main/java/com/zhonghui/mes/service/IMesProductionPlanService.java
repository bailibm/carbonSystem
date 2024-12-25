package com.zhonghui.mes.service;

import com.zhonghui.mes.domain.MesProductionPlan;
import com.zhonghui.mes.domain.vo.MesProductionPlanVo;

import java.util.List;

/**
 * 生产计划Service接口
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
public interface IMesProductionPlanService 
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
     * 批量删除生产计划
     * 
     * @param ids 需要删除的生产计划主键集合
     * @return 结果
     */
    public int deleteMesProductionPlanByIds(String[] ids);

    /**
     * 删除生产计划信息
     * 
     * @param id 生产计划主键
     * @return 结果
     */
    public int deleteMesProductionPlanById(Long id);
}
