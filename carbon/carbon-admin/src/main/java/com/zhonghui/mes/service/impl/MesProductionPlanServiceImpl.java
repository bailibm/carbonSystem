package com.zhonghui.mes.service.impl;

import com.zhonghui.common.utils.SecurityUtils;
import com.zhonghui.common.utils.StringUtils;
import com.zhonghui.mes.domain.MesProductionPlan;
import com.zhonghui.mes.domain.MesProductionPlanItem;
import com.zhonghui.mes.domain.vo.MesProductionPlanVo;
import com.zhonghui.mes.mapper.MesProductionPlanMapper;
import com.zhonghui.mes.service.IMesProductionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 生产计划Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
@Service
public class MesProductionPlanServiceImpl implements IMesProductionPlanService 
{
    @Autowired
    private MesProductionPlanMapper mesProductionPlanMapper;

    /**
     * 查询生产计划
     * 
     * @param id 生产计划主键
     * @return 生产计划
     */
    @Override
    public MesProductionPlanVo selectMesProductionPlanById(Long id)
    {
        return mesProductionPlanMapper.selectMesProductionPlanById(id);
    }

    /**
     * 查询生产计划列表
     * 
     * @param mesProductionPlan 生产计划
     * @return 生产计划
     */
    @Override
    public List<MesProductionPlanVo> selectMesProductionPlanList(MesProductionPlan mesProductionPlan)
    {
        return mesProductionPlanMapper.selectMesProductionPlanList(mesProductionPlan);
    }

    /**
     * 新增生产计划
     * 
     * @param mesProductionPlan 生产计划
     * @return 结果
     */
    @Transactional
    @Override
    public int insertMesProductionPlan(MesProductionPlan mesProductionPlan)
    {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        mesProductionPlan.setPlanNumber("SCJH" + format.format(date));
        mesProductionPlan.setApplicant(SecurityUtils.getUserId());
        mesProductionPlan.setApplicantDate(new Date());
        int rows = mesProductionPlanMapper.insertMesProductionPlan(mesProductionPlan);
        insertMesProductionPlanItem(mesProductionPlan);
        return rows;
    }

    /**
     * 修改生产计划
     * 
     * @param mesProductionPlan 生产计划
     * @return 结果
     */
    @Transactional
    @Override
    public int updateMesProductionPlan(MesProductionPlan mesProductionPlan)
    {
        if(mesProductionPlan.getReviewerStatus() != null) {
            mesProductionPlan.setApplicantStatus(2);
            mesProductionPlan.setReviewer(SecurityUtils.getUserId());
            mesProductionPlan.setReviewerDate(new Date());
        }
        mesProductionPlanMapper.deleteMesProductionPlanItemByPlanId(mesProductionPlan.getId());
        insertMesProductionPlanItem(mesProductionPlan);
        return mesProductionPlanMapper.updateMesProductionPlan(mesProductionPlan);
    }

    /**
     * 批量删除生产计划
     * 
     * @param ids 需要删除的生产计划主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMesProductionPlanByIds(String[] ids)
    {
        mesProductionPlanMapper.deleteMesProductionPlanItemByPlanIds(ids);
        return mesProductionPlanMapper.deleteMesProductionPlanByIds(ids);
    }

    /**
     * 删除生产计划信息
     * 
     * @param id 生产计划主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMesProductionPlanById(Long id)
    {
        mesProductionPlanMapper.deleteMesProductionPlanItemByPlanId(id);
        return mesProductionPlanMapper.deleteMesProductionPlanById(id);
    }

    /**
     * 新增生产计划-生产计划明细子信息
     * 
     * @param mesProductionPlan 生产计划对象
     */
    public void insertMesProductionPlanItem(MesProductionPlan mesProductionPlan)
    {
        List<MesProductionPlanItem> mesProductionPlanItemList = mesProductionPlan.getMesProductionPlanItemList();
        Long id = mesProductionPlan.getId();
        if (StringUtils.isNotNull(mesProductionPlanItemList))
        {
            List<MesProductionPlanItem> list = new ArrayList<MesProductionPlanItem>();
            for (MesProductionPlanItem mesProductionPlanItem : mesProductionPlanItemList)
            {
                mesProductionPlanItem.setPlanId(id);
                list.add(mesProductionPlanItem);
            }
            if (list.size() > 0)
            {
                mesProductionPlanMapper.batchMesProductionPlanItem(list);
            }
        }
    }
}
