package com.zhonghui.mes.service.impl;

import com.zhonghui.common.utils.StringUtils;
import com.zhonghui.mes.domain.MesPlannedProduction;
import com.zhonghui.mes.domain.MesPlannedProductionItem;
import com.zhonghui.mes.domain.vo.MesPlannedProductionVo;
import com.zhonghui.mes.mapper.MesPlannedProductionMapper;
import com.zhonghui.mes.service.IMesPlannedProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 计划排产Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-22
 */
@Service
public class MesPlannedProductionServiceImpl implements IMesPlannedProductionService 
{
    @Autowired
    private MesPlannedProductionMapper mesPlannedProductionMapper;

    /**
     * 查询计划排产
     * 
     * @param id 计划排产主键
     * @return 计划排产
     */
    @Override
    public MesPlannedProductionVo selectMesPlannedProductionById(Long id)
    {
        return mesPlannedProductionMapper.selectMesPlannedProductionById(id);
    }

    /**
     * 查询计划排产列表
     * 
     * @param mesPlannedProductionVo 计划排产
     * @return 计划排产
     */
    @Override
    public List<MesPlannedProductionVo> selectMesPlannedProductionList(MesPlannedProductionVo mesPlannedProductionVo)
    {
        return mesPlannedProductionMapper.selectMesPlannedProductionList(mesPlannedProductionVo);
    }

    /**
     * 新增计划排产
     * 
     * @param mesPlannedProduction 计划排产
     * @return 结果
     */
    @Transactional
    @Override
    public int insertMesPlannedProduction(MesPlannedProduction mesPlannedProduction)
    {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        mesPlannedProduction.setSerialNo("JHPC" + format.format(date));
        int rows = mesPlannedProductionMapper.insertMesPlannedProduction(mesPlannedProduction);
        insertMesPlannedProductionItem(mesPlannedProduction);
        return rows;
    }

    /**
     * 修改计划排产
     * 
     * @param mesPlannedProduction 计划排产
     * @return 结果
     */
    @Transactional
    @Override
    public int updateMesPlannedProduction(MesPlannedProduction mesPlannedProduction)
    {
        mesPlannedProductionMapper.deleteMesPlannedProductionItemByProductionId(mesPlannedProduction.getId());
        insertMesPlannedProductionItem(mesPlannedProduction);
        return mesPlannedProductionMapper.updateMesPlannedProduction(mesPlannedProduction);
    }

    /**
     * 批量删除计划排产
     * 
     * @param ids 需要删除的计划排产主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMesPlannedProductionByIds(Long[] ids)
    {
        mesPlannedProductionMapper.deleteMesPlannedProductionItemByProductionIds(ids);
        return mesPlannedProductionMapper.deleteMesPlannedProductionByIds(ids);
    }

    /**
     * 删除计划排产信息
     * 
     * @param id 计划排产主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMesPlannedProductionById(Long id)
    {
        mesPlannedProductionMapper.deleteMesPlannedProductionItemByProductionId(id);
        return mesPlannedProductionMapper.deleteMesPlannedProductionById(id);
    }

    /**
     * 新增计划排产-生产计划子信息
     * 
     * @param mesPlannedProduction 计划排产对象
     */
    public void insertMesPlannedProductionItem(MesPlannedProduction mesPlannedProduction)
    {
        List<MesPlannedProductionItem> mesPlannedProductionItemList = mesPlannedProduction.getMesPlannedProductionItemList();
        Long id = mesPlannedProduction.getId();
        if (StringUtils.isNotNull(mesPlannedProductionItemList))
        {
            List<MesPlannedProductionItem> list = new ArrayList<MesPlannedProductionItem>();
            for (MesPlannedProductionItem mesPlannedProductionItem : mesPlannedProductionItemList)
            {
                mesPlannedProductionItem.setProductionId(id);
                list.add(mesPlannedProductionItem);
            }
            if (list.size() > 0)
            {
                mesPlannedProductionMapper.batchMesPlannedProductionItem(list);
            }
        }
    }
}
