package com.zhonghui.wms.mapper;

import com.zhonghui.wms.domain.WmsMaterial;

import java.util.List;

/**
 * 物料档案Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-19
 */
public interface WmsMaterialMapper 
{
    /**
     * 查询物料档案
     * 
     * @param id 物料档案主键
     * @return 物料档案
     */
    public WmsMaterial selectWmsMaterialById(Long id);

    /**
     * 查询物料档案列表
     * 
     * @param wmsMaterial 物料档案
     * @return 物料档案集合
     */
    public List<WmsMaterial> selectWmsMaterialList(WmsMaterial wmsMaterial);

    /**
     * 新增物料档案
     * 
     * @param wmsMaterial 物料档案
     * @return 结果
     */
    public int insertWmsMaterial(WmsMaterial wmsMaterial);

    /**
     * 修改物料档案
     * 
     * @param wmsMaterial 物料档案
     * @return 结果
     */
    public int updateWmsMaterial(WmsMaterial wmsMaterial);

    /**
     * 删除物料档案
     * 
     * @param id 物料档案主键
     * @return 结果
     */
    public int deleteWmsMaterialById(Long id);

    /**
     * 批量删除物料档案
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmsMaterialByIds(Long[] ids);
}
