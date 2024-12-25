package com.zhonghui.scm.service;

import com.zhonghui.scm.domain.ScmSaleCustom;
import com.zhonghui.scm.domain.ScmSaleCustomBill;

import java.util.List;

/**
 * 客户档案Service接口
 * 
 * @author zhonghui
 * @date 2022-05-19
 */
public interface IScmSaleCustomService 
{
    /**
     * 查询客户档案
     * 
     * @param id 客户档案主键
     * @return 客户档案
     */
    public ScmSaleCustom selectScmSaleCustomById(Long id);

    /**
     * 查询客户档案列表
     * 
     * @param scmSaleCustom 客户档案
     * @return 客户档案集合
     */
    public List<ScmSaleCustom> selectScmSaleCustomList(ScmSaleCustom scmSaleCustom);

    /**
     * 新增客户档案
     * 
     * @param scmSaleCustom 客户档案
     * @return 结果
     */
    public int insertScmSaleCustom(ScmSaleCustom scmSaleCustom);

    /**
     * 修改客户档案
     * 
     * @param scmSaleCustom 客户档案
     * @return 结果
     */
    public int updateScmSaleCustom(ScmSaleCustom scmSaleCustom);

    /**
     * 批量删除客户档案
     * 
     * @param ids 需要删除的客户档案主键集合
     * @return 结果
     */
    public int deleteScmSaleCustomByIds(Long[] ids);

    /**
     * 删除客户档案信息
     * 
     * @param id 客户档案主键
     * @return 结果
     */
    public int deleteScmSaleCustomById(Long id);

    List<ScmSaleCustomBill> bill(ScmSaleCustomBill scmSaleCustomBill);
}
