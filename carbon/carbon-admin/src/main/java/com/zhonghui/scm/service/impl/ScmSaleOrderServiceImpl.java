package com.zhonghui.scm.service.impl;

import com.zhonghui.common.utils.SecurityUtils;
import com.zhonghui.common.utils.StringUtils;
import com.zhonghui.scm.domain.ScmSaleOrder;
import com.zhonghui.scm.domain.ScmSaleOrderItem;
import com.zhonghui.scm.domain.vo.ScmSaleOrderVo;
import com.zhonghui.scm.mapper.ScmSaleOrderMapper;
import com.zhonghui.scm.service.IScmSaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 供应链SCM-销售管理-销售订单Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-20
 */
@Service
public class ScmSaleOrderServiceImpl implements IScmSaleOrderService 
{
    @Autowired
    private ScmSaleOrderMapper scmSaleOrderMapper;

    /**
     * 查询供应链SCM-销售管理-销售订单
     * 
     * @param id 供应链SCM-销售管理-销售订单主键
     * @return 供应链SCM-销售管理-销售订单
     */
    @Override
    public ScmSaleOrderVo selectScmSaleOrderById(Long id)
    {
        return scmSaleOrderMapper.selectScmSaleOrderById(id);
    }

    /**
     * 查询供应链SCM-销售管理-销售订单列表
     * 
     * @param scmSaleOrder 供应链SCM-销售管理-销售订单
     * @return 供应链SCM-销售管理-销售订单
     */
    @Override
    public List<ScmSaleOrderVo> selectScmSaleOrderList(ScmSaleOrder scmSaleOrder)
    {
        return scmSaleOrderMapper.selectScmSaleOrderList(scmSaleOrder);
    }

    /**
     * 新增供应链SCM-销售管理-销售订单
     * 
     * @param scmSaleOrder 供应链SCM-销售管理-销售订单
     * @return 结果
     */
    @Transactional
    @Override
    public int insertScmSaleOrder(ScmSaleOrder scmSaleOrder)
    {
        scmSaleOrder.setOrderNo(generateNumber("DS"));
        scmSaleOrder.setApplyId(SecurityUtils.getUserId());
        scmSaleOrder.setApplyDate(new Date());
        int rows = scmSaleOrderMapper.insertScmSaleOrder(scmSaleOrder);
        insertScmSaleOrderItem(scmSaleOrder);
        return rows;
    }

    /**
     * 修改供应链SCM-销售管理-销售订单
     * 
     * @param scmSaleOrder 供应链SCM-销售管理-销售订单
     * @return 结果
     */
    @Transactional
    @Override
    public int updateScmSaleOrder(ScmSaleOrder scmSaleOrder)
    {
        if(scmSaleOrder.getAuditStatus() != null) {
            scmSaleOrder.setApplyStatus(2);
            scmSaleOrder.setAuditorId(SecurityUtils.getUserId());
            scmSaleOrder.setAuditTime(new Date());
            scmSaleOrder.setApplyStatus(2);
        }
        scmSaleOrderMapper.deleteScmSaleOrderItemByOrderId(scmSaleOrder.getId());
        insertScmSaleOrderItem(scmSaleOrder);
        return scmSaleOrderMapper.updateScmSaleOrder(scmSaleOrder);
    }

    /**
     * 批量删除供应链SCM-销售管理-销售订单
     * 
     * @param ids 需要删除的供应链SCM-销售管理-销售订单主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteScmSaleOrderByIds(Long[] ids)
    {
        scmSaleOrderMapper.deleteScmSaleOrderItemByOrderIds(ids);
        return scmSaleOrderMapper.deleteScmSaleOrderByIds(ids);
    }

    /**
     * 删除供应链SCM-销售管理-销售订单信息
     * 
     * @param id 供应链SCM-销售管理-销售订单主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteScmSaleOrderById(Long id)
    {
        scmSaleOrderMapper.deleteScmSaleOrderItemByOrderId(id);
        return scmSaleOrderMapper.deleteScmSaleOrderById(id);
    }

    /**
     * 新增供应链SCM-销售管理-销售订单子信息
     * 
     * @param scmSaleOrder 供应链SCM-销售管理-销售订单对象
     */
    public void insertScmSaleOrderItem(ScmSaleOrder scmSaleOrder)
    {
        List<ScmSaleOrderItem> scmSaleOrderItemList = scmSaleOrder.getScmSaleOrderItemList();
        Long id = scmSaleOrder.getId();
        if (StringUtils.isNotNull(scmSaleOrderItemList))
        {
            List<ScmSaleOrderItem> list = new ArrayList<ScmSaleOrderItem>();
            for (ScmSaleOrderItem scmSaleOrderItem : scmSaleOrderItemList)
            {
                scmSaleOrderItem.setOrderId(id);
                list.add(scmSaleOrderItem);
            }
            if (list.size() > 0)
            {
                scmSaleOrderMapper.batchScmSaleOrderItem(list);
            }
        }
    }

    public String generateNumber(String number){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return number+format.format(date);
    }

}
