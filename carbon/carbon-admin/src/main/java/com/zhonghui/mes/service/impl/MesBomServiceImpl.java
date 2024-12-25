package com.zhonghui.mes.service.impl;

import com.zhonghui.common.utils.StringUtils;
import com.zhonghui.mes.domain.MesBom;
import com.zhonghui.mes.domain.MesBomDetailItem;
import com.zhonghui.mes.domain.MesProduct;
import com.zhonghui.mes.domain.vo.MesBomVo;
import com.zhonghui.mes.domain.vo.MesProductionPlanVo;
import com.zhonghui.mes.mapper.MesBomMapper;
import com.zhonghui.mes.mapper.MesProductMapper;
import com.zhonghui.mes.mapper.MesProductionPlanMapper;
import com.zhonghui.mes.service.IMesBomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * BomService业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
@Service
public class MesBomServiceImpl implements IMesBomService 
{
    @Autowired
    private MesBomMapper mesBomMapper;

    @Autowired
    private MesProductionPlanMapper mesProductionPlanMapper;

    @Autowired
    private MesProductMapper mesProductMapper;

    /**
     * 查询Bom
     * 
     * @param id Bom主键
     * @return Bom
     */
    @Override
    public MesBomVo selectMesBomById(Long id)
    {
        return mesBomMapper.selectMesBomById(id);
    }

    /**
     * 查询Bom列表
     * 
     * @param mesBom Bom
     * @return Bom
     */
    @Override
    public List<MesBomVo> selectMesBomList(MesBom mesBom)
    {
        return mesBomMapper.selectMesBomList(mesBom);
    }

    /**
     * 新增Bom
     * 
     * @param mesBom Bom
     * @return 结果
     */
    @Transactional
    @Override
    public int insertMesBom(MesBom mesBom)
    {
        int rows = mesBomMapper.insertMesBom(mesBom);
        insertMesBomDetailItem(mesBom);
        return rows;
    }

    /**
     * 修改Bom
     * 
     * @param mesBom Bom
     * @return 结果
     */
    @Transactional
    @Override
    public int updateMesBom(MesBom mesBom)
    {
        mesBomMapper.deleteMesBomDetailItemByBomId(mesBom.getId());
        insertMesBomDetailItem(mesBom);
        return mesBomMapper.updateMesBom(mesBom);
    }

    /**
     * 批量删除Bom
     * 
     * @param ids 需要删除的Bom主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMesBomByIds(Long[] ids)
    {
        mesBomMapper.deleteMesBomDetailItemByBomIds(ids);
        return mesBomMapper.deleteMesBomByIds(ids);
    }

    /**
     * 删除Bom信息
     * 
     * @param id Bom主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMesBomById(Long id)
    {
        mesBomMapper.deleteMesBomDetailItemByBomId(id);
        return mesBomMapper.deleteMesBomById(id);
    }

    /**
     * 新增BOM单明细信息子信息
     * 
     * @param mesBom Bom对象
     */
    public void insertMesBomDetailItem(MesBom mesBom)
    {
        List<MesBomDetailItem> mesBomDetailItemList = mesBom.getMesBomDetailItemList();
        Long id = mesBom.getId();
        if (StringUtils.isNotNull(mesBomDetailItemList))
        {
            List<MesBomDetailItem> list = new ArrayList<MesBomDetailItem>();
            for (MesBomDetailItem mesBomDetailItem : mesBomDetailItemList)
            {
                mesBomDetailItem.setBomId(id);
                list.add(mesBomDetailItem);
            }
            if (list.size() > 0)
            {
                mesBomMapper.batchMesBomDetailItem(list);
            }
        }
    }

    @Override
    public List<MesBomVo> selectMesBomListByMaterialId(Long id) {
        MesProductionPlanVo mesProductionPlanVo = mesProductionPlanMapper.selectMesProductionPlanById(id);
        Long[] materialIds = new Long[mesProductionPlanVo.getMesProductionPlanItemList().size()];
        for (int i = 0; i < mesProductionPlanVo.getMesProductionPlanItemList().size(); i++) {
            materialIds[i] = mesProductionPlanVo.getMesProductionPlanItemList().get(i).getMaterialId();
        }
        List<MesProduct> mesProducts = mesProductMapper.selectMesProductByMaterialIds(materialIds);
        Long[] productIds = new Long[mesProducts.size()];
        for (int i = 0; i < productIds.length; i++) {
            productIds[i] = mesProducts.get(i).getId();
        }
        return mesBomMapper.selectMesBomListByProductIds(productIds);
    }
}
