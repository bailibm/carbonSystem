package com.zhonghui.mes.service;

import com.zhonghui.mes.domain.MesBom;
import com.zhonghui.mes.domain.vo.MesBomVo;

import java.util.List;

/**
 * BomService接口
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
public interface IMesBomService 
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
     * 批量删除Bom
     * 
     * @param ids 需要删除的Bom主键集合
     * @return 结果
     */
    public int deleteMesBomByIds(Long[] ids);

    /**
     * 删除Bom信息
     * 
     * @param id Bom主键
     * @return 结果
     */
    public int deleteMesBomById(Long id);

    /**
     * 查询Bom列表(通过计划明细物料id)
     *
     * @param id 计划id主键
     * @return Bom集合
     */
    public List<MesBomVo> selectMesBomListByMaterialId(Long id);
}
