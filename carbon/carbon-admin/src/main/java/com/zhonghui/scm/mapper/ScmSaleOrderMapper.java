package com.zhonghui.scm.mapper;

import com.zhonghui.scm.domain.ScmSaleOrder;
import com.zhonghui.scm.domain.ScmSaleOrderItem;
import com.zhonghui.scm.domain.vo.ScmSaleOrderVo;

import java.util.List;

/**
 * 供应链SCM-销售管理-销售订单Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-20
 */
public interface ScmSaleOrderMapper 
{
    /**
     * 查询供应链SCM-销售管理-销售订单
     * 
     * @param id 供应链SCM-销售管理-销售订单主键
     * @return 供应链SCM-销售管理-销售订单
     */
    public ScmSaleOrderVo selectScmSaleOrderById(Long id);

    /**
     * 查询供应链SCM-销售管理-销售订单列表
     * 
     * @param scmSaleOrder 供应链SCM-销售管理-销售订单
     * @return 供应链SCM-销售管理-销售订单集合
     */
    public List<ScmSaleOrderVo> selectScmSaleOrderList(ScmSaleOrder scmSaleOrder);

    /**
     * 新增供应链SCM-销售管理-销售订单
     * 
     * @param scmSaleOrder 供应链SCM-销售管理-销售订单
     * @return 结果
     */
    public int insertScmSaleOrder(ScmSaleOrder scmSaleOrder);

    /**
     * 修改供应链SCM-销售管理-销售订单
     * 
     * @param scmSaleOrder 供应链SCM-销售管理-销售订单
     * @return 结果
     */
    public int updateScmSaleOrder(ScmSaleOrder scmSaleOrder);

    /**
     * 删除供应链SCM-销售管理-销售订单
     * 
     * @param id 供应链SCM-销售管理-销售订单主键
     * @return 结果
     */
    public int deleteScmSaleOrderById(Long id);

    /**
     * 批量删除供应链SCM-销售管理-销售订单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteScmSaleOrderByIds(Long[] ids);

    /**
     * 批量删除供应链SCM-销售管理-销售订单子
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteScmSaleOrderItemByOrderIds(Long[] ids);
    
    /**
     * 批量新增供应链SCM-销售管理-销售订单子
     * 
     * @param scmSaleOrderItemList 供应链SCM-销售管理-销售订单子列表
     * @return 结果
     */
    public int batchScmSaleOrderItem(List<ScmSaleOrderItem> scmSaleOrderItemList);
    

    /**
     * 通过供应链SCM-销售管理-销售订单主键删除供应链SCM-销售管理-销售订单子信息
     * 
     * @param id 供应链SCM-销售管理-销售订单ID
     * @return 结果
     */
    public int deleteScmSaleOrderItemByOrderId(Long id);
}
