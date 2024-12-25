package com.zhonghui.scm.service;

import com.zhonghui.scm.domain.ScmSaleOrder;
import com.zhonghui.scm.domain.vo.ScmSaleOrderVo;

import java.util.List;

/**
 * 供应链SCM-销售管理-销售订单Service接口
 * 
 * @author zhonghui
 * @date 2022-05-20
 */
public interface IScmSaleOrderService 
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
     * 批量删除供应链SCM-销售管理-销售订单
     * 
     * @param ids 需要删除的供应链SCM-销售管理-销售订单主键集合
     * @return 结果
     */
    public int deleteScmSaleOrderByIds(Long[] ids);

    /**
     * 删除供应链SCM-销售管理-销售订单信息
     * 
     * @param id 供应链SCM-销售管理-销售订单主键
     * @return 结果
     */
    public int deleteScmSaleOrderById(Long id);
}
