package com.zhonghui.mes.mapper;

import com.zhonghui.mes.domain.MesProduct;
import com.zhonghui.mes.domain.MesTechnology;
import com.zhonghui.mes.domain.vo.MesTechnologyVo;

import java.util.List;

/**
 * 工艺建模Mapper接口
 *
 * @author carbon
 * @date 2022-05-19
 */
public interface MesTechnologyMapper
{
    /**
     * 查询工艺建模
     *
     * @param id 工艺建模主键
     * @return 工艺建模
     */
    public MesTechnologyVo selectMesTechnologyById(Long id);

    /**
     * 查询工艺建模列表
     *
     * @param mesTechnology 工艺建模
     * @return 工艺建模集合
     */
    public List<MesTechnologyVo> selectMesTechnologyList(MesTechnology mesTechnology);

    /**
     * 新增工艺建模
     *
     * @param mesTechnology 工艺建模
     * @return 结果
     */
    public int insertMesTechnology(MesTechnology mesTechnology);

    /**
     * 修改工艺建模
     *
     * @param mesTechnology 工艺建模
     * @return 结果
     */
    public int updateMesTechnology(MesTechnology mesTechnology);

    /**
     * 删除工艺建模
     *
     * @param id 工艺建模主键
     * @return 结果
     */
    public int deleteMesTechnologyById(Long id);

    /**
     * 批量删除工艺建模
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesTechnologyByIds(Long[] ids);

    /**
     * 批量删除产品建模
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesProductByIds(Long[] ids);

    /**
     * 批量新增产品建模
     *
     * @param mesProductList 产品建模列表
     * @return 结果
     */
    public int batchMesProduct(List<MesProduct> mesProductList);


    /**
     * 通过工艺建模主键删除产品建模信息
     *
     * @param id 工艺建模ID
     * @return 结果
     */
    public int deleteMesProductById(Long id);
}
