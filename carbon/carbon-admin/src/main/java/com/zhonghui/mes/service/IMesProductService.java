package com.zhonghui.mes.service;

import com.zhonghui.mes.domain.MesProduct;
import com.zhonghui.mes.domain.vo.MesProductVo;

import java.util.List;

/**
 * 产品建模Service接口
 * 
 * @author zhonghui
 * @date 2022-05-20
 */
public interface IMesProductService 
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
     * 批量删除产品建模
     * 
     * @param ids 需要删除的产品建模主键集合
     * @return 结果
     */
    public int deleteMesProductByIds(Long[] ids);

    /**
     * 删除产品建模信息
     * 
     * @param id 产品建模主键
     * @return 结果
     */
    public int deleteMesProductById(Long id);
}
