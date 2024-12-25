package com.zhonghui.mes.mapper;

import com.zhonghui.mes.domain.MesBom;
import com.zhonghui.mes.domain.MesBomDetailItem;
import com.zhonghui.mes.domain.vo.MesBomVo;

import java.util.List;

/**
 * BomMapper接口
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
public interface MesBomMapper 
{
    /**
     * 查询Bom
     * 
     * @param id Bom主键
     * @return Bom
     */
    public MesBomVo selectMesBomById(Long id);

    /**
     * 查询Bom列表
     * 
     * @param mesBom Bom
     * @return Bom集合
     */
    public List<MesBomVo> selectMesBomList(MesBom mesBom);

    /**
     * 新增Bom
     * 
     * @param mesBom Bom
     * @return 结果
     */
    public int insertMesBom(MesBom mesBom);

    /**
     * 修改Bom
     * 
     * @param mesBom Bom
     * @return 结果
     */
    public int updateMesBom(MesBom mesBom);

    /**
     * 删除Bom
     * 
     * @param id Bom主键
     * @return 结果
     */
    public int deleteMesBomById(Long id);

    /**
     * 批量删除Bom
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesBomByIds(Long[] ids);

    /**
     * 批量删除BOM单明细信息子
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesBomDetailItemByBomIds(Long[] ids);
    
    /**
     * 批量新增BOM单明细信息子
     * 
     * @param mesBomDetailItemList BOM单明细信息子列表
     * @return 结果
     */
    public int batchMesBomDetailItem(List<MesBomDetailItem> mesBomDetailItemList);
    

    /**
     * 通过Bom主键删除BOM单明细信息子信息
     * 
     * @param id BomID
     * @return 结果
     */
    public int deleteMesBomDetailItemByBomId(Long id);

    /**
     * 通过产品id查询BOM列表
     *
     * @param productId 产品id数组
     * @return 结果
     */
    public List<MesBomVo> selectMesBomListByProductIds(Long[] productId);
}
