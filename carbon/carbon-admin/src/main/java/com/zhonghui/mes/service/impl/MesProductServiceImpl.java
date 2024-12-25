package com.zhonghui.mes.service.impl;

import com.zhonghui.common.utils.StringUtils;
import com.zhonghui.mes.domain.MesProduct;
import com.zhonghui.mes.domain.MesProductMaterialItem;
import com.zhonghui.mes.domain.vo.MesProductVo;
import com.zhonghui.mes.mapper.MesProductMapper;
import com.zhonghui.mes.service.IMesProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品建模Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-20
 */
@Service
public class MesProductServiceImpl implements IMesProductService 
{
    @Autowired
    private MesProductMapper mesProductMapper;

    /**
     * 查询产品建模
     * 
     * @param id 产品建模主键
     * @return 产品建模
     */
    @Override
    public MesProductVo selectMesProductById(Long id)
    {
        return mesProductMapper.selectMesProductById(id);
    }

    /**
     * 查询产品建模列表
     * 
     * @param mesProduct 产品建模
     * @return 产品建模
     */
    @Override
    public List<MesProductVo> selectMesProductList(MesProduct mesProduct)
    {
        return mesProductMapper.selectMesProductList(mesProduct);
    }

    /**
     * 新增产品建模
     * 
     * @param mesProduct 产品建模
     * @return 结果
     */
    @Transactional
    @Override
    public int insertMesProduct(MesProduct mesProduct)
    {
        int rows = mesProductMapper.insertMesProduct(mesProduct);
        insertMesProductMaterialItem(mesProduct);
        return rows;
    }

    /**
     * 修改产品建模
     * 
     * @param mesProduct 产品建模
     * @return 结果
     */
    @Transactional
    @Override
    public int updateMesProduct(MesProduct mesProduct)
    {
        mesProductMapper.deleteMesProductMaterialItemByProductId(mesProduct.getId());
        insertMesProductMaterialItem(mesProduct);
        return mesProductMapper.updateMesProduct(mesProduct);
    }

    /**
     * 批量删除产品建模
     * 
     * @param ids 需要删除的产品建模主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMesProductByIds(Long[] ids)
    {
        mesProductMapper.deleteMesProductMaterialItemByProductIds(ids);
        return mesProductMapper.deleteMesProductByIds(ids);
    }

    /**
     * 删除产品建模信息
     * 
     * @param id 产品建模主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMesProductById(Long id)
    {
        mesProductMapper.deleteMesProductMaterialItemByProductId(id);
        return mesProductMapper.deleteMesProductById(id);
    }

    /**
     * 新增产品物料子信息
     * 
     * @param mesProduct 产品建模对象
     */
    public void insertMesProductMaterialItem(MesProduct mesProduct)
    {
        List<MesProductMaterialItem> mesProductMaterialItemList = mesProduct.getMesProductMaterialItemList();
        Long id = mesProduct.getId();
        if (StringUtils.isNotNull(mesProductMaterialItemList))
        {
            List<MesProductMaterialItem> list = new ArrayList<MesProductMaterialItem>();
            for (MesProductMaterialItem mesProductMaterialItem : mesProductMaterialItemList)
            {
                mesProductMaterialItem.setProductId(id);
                list.add(mesProductMaterialItem);
            }
            if (list.size() > 0)
            {
                mesProductMapper.batchMesProductMaterialItem(list);
            }
        }
    }
}
