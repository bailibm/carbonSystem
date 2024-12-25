package com.zhonghui.mes.service.impl;

import com.zhonghui.mes.domain.MesProductionPlanItem;
import com.zhonghui.mes.domain.vo.MesProductionPlanItemVo;
import com.zhonghui.mes.mapper.MesProductionPlanItemMapper;
import com.zhonghui.mes.service.IMesProductionPlanItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 生产计划明细Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-24
 */
@Service
public class MesProductionPlanItemServiceImpl implements IMesProductionPlanItemService 
{
    @Autowired
    private MesProductionPlanItemMapper mesProductionPlanItemMapper;

    /**
     * 查询生产计划明细
     * 
     * @param id 生产计划明细主键
     * @return 生产计划明细
     */
    @Override
    public MesProductionPlanItem selectMesProductionPlanItemById(Long id)
    {
        return mesProductionPlanItemMapper.selectMesProductionPlanItemById(id);
    }

    /**
     * 查询生产计划明细列表
     * 
     * @param mesProductionPlanItemVo 生产计划明细
     * @return 生产计划明细
     */
    @Override
    public List<MesProductionPlanItemVo> selectMesProductionPlanItemList(MesProductionPlanItemVo mesProductionPlanItemVo)
    {
        return mesProductionPlanItemMapper.selectMesProductionPlanItemList(mesProductionPlanItemVo);
    }

    /**
     * 新增生产计划明细
     * 
     * @param mesProductionPlanItem 生产计划明细
     * @return 结果
     */
    @Override
    public int insertMesProductionPlanItem(MesProductionPlanItem mesProductionPlanItem)
    {
        return mesProductionPlanItemMapper.insertMesProductionPlanItem(mesProductionPlanItem);
    }

    /**
     * 修改生产计划明细
     * 
     * @param mesProductionPlanItem 生产计划明细
     * @return 结果
     */
    @Override
    public int updateMesProductionPlanItem(MesProductionPlanItem mesProductionPlanItem)
    {
        return mesProductionPlanItemMapper.updateMesProductionPlanItem(mesProductionPlanItem);
    }

    /**
     * 批量删除生产计划明细
     * 
     * @param ids 需要删除的生产计划明细主键
     * @return 结果
     */
    @Override
    public int deleteMesProductionPlanItemByIds(Long[] ids)
    {
        return mesProductionPlanItemMapper.deleteMesProductionPlanItemByIds(ids);
    }

    /**
     * 删除生产计划明细信息
     * 
     * @param id 生产计划明细主键
     * @return 结果
     */
    @Override
    public int deleteMesProductionPlanItemById(Long id)
    {
        return mesProductionPlanItemMapper.deleteMesProductionPlanItemById(id);
    }
}
