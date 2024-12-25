package com.zhonghui.procurementManagement.service;

import java.util.List;
import com.zhonghui.procurementManagement.domain.PmMark;

/**
 * 参与投标表Service接口
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
public interface IPmMarkService 
{
    /**
     * 查询参与投标表
     * 
     * @param markId 参与投标表主键
     * @return 参与投标表
     */
    public PmMark selectPmMarkByMarkId(Long markId);

    /**
     * 查询参与投标表列表
     * 
     * @param pmMark 参与投标表
     * @return 参与投标表集合
     */
    public List<PmMark> selectPmMarkList(PmMark pmMark);

    /**
     * 新增参与投标表
     * 
     * @param pmMark 参与投标表
     * @return 结果
     */
    public int insertPmMark(PmMark pmMark);

    /**
     * 修改参与投标表
     * 
     * @param pmMark 参与投标表
     * @return 结果
     */
    public int updatePmMark(PmMark pmMark);

    /**
     * 批量删除参与投标表
     * 
     * @param markIds 需要删除的参与投标表主键集合
     * @return 结果
     */
    public int deletePmMarkByMarkIds(Long[] markIds);

    /**
     * 删除参与投标表信息
     * 
     * @param markId 参与投标表主键
     * @return 结果
     */
    public int deletePmMarkByMarkId(Long markId);
}
