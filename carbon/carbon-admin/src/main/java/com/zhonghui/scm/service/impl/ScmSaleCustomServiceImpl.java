package com.zhonghui.scm.service.impl;

import com.zhonghui.common.utils.DateUtils;
import com.zhonghui.scm.domain.ScmSaleCustom;
import com.zhonghui.scm.domain.ScmSaleCustomBill;
import com.zhonghui.scm.mapper.ScmSaleCustomMapper;
import com.zhonghui.scm.service.IScmSaleCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户档案Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-19
 */
@Service
public class ScmSaleCustomServiceImpl implements IScmSaleCustomService 
{
    @Autowired
    private ScmSaleCustomMapper scmSaleCustomMapper;

    /**
     * 查询客户档案
     * 
     * @param id 客户档案主键
     * @return 客户档案
     */
    @Override
    public ScmSaleCustom selectScmSaleCustomById(Long id)
    {
        return scmSaleCustomMapper.selectScmSaleCustomById(id);
    }

    /**
     * 查询客户档案列表
     * 
     * @param scmSaleCustom 客户档案
     * @return 客户档案
     */
    @Override
    public List<ScmSaleCustom> selectScmSaleCustomList(ScmSaleCustom scmSaleCustom)
    {
        return scmSaleCustomMapper.selectScmSaleCustomList(scmSaleCustom);
    }

    /**
     * 新增客户档案
     * 
     * @param scmSaleCustom 客户档案
     * @return 结果
     */
    @Override
    public int insertScmSaleCustom(ScmSaleCustom scmSaleCustom)
    {
        scmSaleCustom.setCreateTime(DateUtils.getNowDate());
        return scmSaleCustomMapper.insertScmSaleCustom(scmSaleCustom);
    }

    /**
     * 修改客户档案
     * 
     * @param scmSaleCustom 客户档案
     * @return 结果
     */
    @Override
    public int updateScmSaleCustom(ScmSaleCustom scmSaleCustom)
    {
        return scmSaleCustomMapper.updateScmSaleCustom(scmSaleCustom);
    }

    /**
     * 批量删除客户档案
     * 
     * @param ids 需要删除的客户档案主键
     * @return 结果
     */
    @Override
    public int deleteScmSaleCustomByIds(Long[] ids)
    {
        return scmSaleCustomMapper.deleteScmSaleCustomByIds(ids);
    }

    /**
     * 删除客户档案信息
     * 
     * @param id 客户档案主键
     * @return 结果
     */
    @Override
    public int deleteScmSaleCustomById(Long id)
    {
        return scmSaleCustomMapper.deleteScmSaleCustomById(id);
    }

    @Override
    public List<ScmSaleCustomBill> bill(ScmSaleCustomBill scmSaleCustomBill) {
        if (scmSaleCustomBill.getType() == 0){
           return scmSaleCustomMapper.billByQuarter(scmSaleCustomBill);
        }
        return scmSaleCustomMapper.billByMonth(scmSaleCustomBill);
    }


}
