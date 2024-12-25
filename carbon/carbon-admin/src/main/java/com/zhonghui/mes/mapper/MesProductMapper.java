package com.zhonghui.mes.mapper;

import com.zhonghui.mes.domain.MesProduct;
import com.zhonghui.mes.domain.MesProductMaterialItem;
import com.zhonghui.mes.domain.vo.MesProductVo;

import java.util.List;

/**
 * 产品建模Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-20
 */
public interface MesProductMapper 
{
    /**
     * 查询产品建模
     * 
     * @param id 产品建模主键
     * @return 产品建模
     */
    public MesProductVo selectMesProductById(Long id);

    /**
     * 查询产品建模列表
     * 
     * @param mesProduct 产品建模
     * @return 产品建模集合
     */
    public List<MesProductVo> selectMesProductList(MesProduct mesProduct);

    /**
     * 新增产品建模
     * 
     * @param mesProduct 产品建模
     * @return 结果
     */
    public int insertMesProduct(MesProduct mesProduct);

    /**
     * 修改产品建模
     * 
     * @param mesProduct 产品建模
     * @return 结果
     */
    public int updateMesProduct(MesProduct mesProduct);

    /**
     * 删除产品建模
     * 
     * @param id 产品建模主键
     * @return 结果
     */
    public int deleteMesProductById(Long id);

    /**
     * 批量删除产品建模
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesProductByIds(Long[] ids);

    /**
     * 批量删除产品物料子
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesProductMaterialItemByProductIds(Long[] ids);
    
    /**
     * 批量新增产品物料子
     * 
     * @param mesProductMaterialItemList 产品物料子列表
     * @return 结果
     */
    public int batchMesProductMaterialItem(List<MesProductMaterialItem> mesProductMaterialItemList);
    

    /**
     * 通过产品建模主键删除产品物料子信息
     * 
     * @param id 产品建模ID
     * @return 结果
     */
    public int deleteMesProductMaterialItemByProductId(Long id);

    /**
     * 通过物料id查询产品列表
     *
     * @param materialId 物料id数组
     * @return 结果
     */
    public List<MesProduct> selectMesProductByMaterialIds(Long[] materialId);
}
