package com.zhonghui.mes.service;

import com.zhonghui.mes.domain.MesDeviceInformation;

import java.util.List;

/**
 * 设备信息Service接口
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
public interface IMesDeviceInformationService 
{
    /**
     * 查询设备信息
     * 
     * @param id 设备信息主键
     * @return 设备信息
     */
    public MesDeviceInformation selectMesDeviceInformationById(Integer id);

    /**
     * 查询设备信息列表
     * 
     * @param mesDeviceInformation 设备信息
     * @return 设备信息集合
     */
    public List<MesDeviceInformation> selectMesDeviceInformationList(MesDeviceInformation mesDeviceInformation);

    /**
     * 新增设备信息
     * 
     * @param mesDeviceInformation 设备信息
     * @return 结果
     */
    public int insertMesDeviceInformation(MesDeviceInformation mesDeviceInformation);

    /**
     * 修改设备信息
     * 
     * @param mesDeviceInformation 设备信息
     * @return 结果
     */
    public int updateMesDeviceInformation(MesDeviceInformation mesDeviceInformation);

    /**
     * 批量删除设备信息
     * 
     * @param ids 需要删除的设备信息主键集合
     * @return 结果
     */
    public int deleteMesDeviceInformationByIds(Integer[] ids);

    /**
     * 删除设备信息信息
     * 
     * @param id 设备信息主键
     * @return 结果
     */
    public int deleteMesDeviceInformationById(Integer id);
}
