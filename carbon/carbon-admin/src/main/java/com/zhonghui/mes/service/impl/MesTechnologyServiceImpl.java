package com.zhonghui.mes.service.impl;

import com.zhonghui.mes.domain.MesTechnology;
import com.zhonghui.mes.domain.vo.MesTechnologyVo;
import com.zhonghui.mes.mapper.MesTechnologyMapper;
import com.zhonghui.mes.service.IMesTechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 工艺建模Service业务层处理
 *
 * @author carbon
 * @date 2022-05-19
 */
@Service
public class MesTechnologyServiceImpl implements IMesTechnologyService
{

    @Autowired
    private MesTechnologyMapper mesTechnologyMapper;

    /**
     * 查询工艺建模
     *
     * @param id 工艺建模主键
     * @return 工艺建模
     */
    @Override
    public MesTechnologyVo selectMesTechnologyById(Long id)
    {
        return mesTechnologyMapper.selectMesTechnologyById(id);
    }

    /**
     * 查询工艺建模列表
     *
     * @param mesTechnology 工艺建模
     * @return 工艺建模
     */
    @Override
    public List<MesTechnologyVo> selectMesTechnologyList(MesTechnology mesTechnology)
    {
        return mesTechnologyMapper.selectMesTechnologyList(mesTechnology);
    }

    /**
     * 新增工艺建模
     *
     * @param mesTechnology 工艺建模
     * @return 结果
     */
    @Transactional
    @Override
    public int insertMesTechnology(MesTechnology mesTechnology)
    {
        return mesTechnologyMapper.insertMesTechnology(mesTechnology);
    }

    /**
     * 修改工艺建模
     *
     * @param mesTechnology 工艺建模
     * @return 结果
     */
    @Transactional
    @Override
    public int updateMesTechnology(MesTechnology mesTechnology)
    {
        return mesTechnologyMapper.updateMesTechnology(mesTechnology);
    }

    /**
     * 批量删除工艺建模
     *
     * @param ids 需要删除的工艺建模主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMesTechnologyByIds(Long[] ids)
    {
        return mesTechnologyMapper.deleteMesTechnologyByIds(ids);
    }

    /**
     * 删除工艺建模信息
     *
     * @param id 工艺建模主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMesTechnologyById(Long id)
    {
        return mesTechnologyMapper.deleteMesTechnologyById(id);
    }

}
