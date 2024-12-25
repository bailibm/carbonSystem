package com.zhonghui.mes.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.mes.domain.MesDeviceInformation;
import com.zhonghui.mes.service.IMesDeviceInformationService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 设备信息Controller
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
@Api(tags="设备信息")
@RestController
@RequestMapping("/mes/information")
public class MesDeviceInformationController extends BaseController
{
    @Autowired
    private IMesDeviceInformationService mesDeviceInformationService;

    /**
     * 查询设备信息列表
     */
    @ApiOperation("查询设备信息列表")
    @GetMapping("/list")
    public TableDataInfo list(MesDeviceInformation mesDeviceInformation)
    {
        startPage();
        List<MesDeviceInformation> list = mesDeviceInformationService.selectMesDeviceInformationList(mesDeviceInformation);
        return getDataTable(list);
    }

    /**
     * 查询设备信息列表（不分页）
     */
    @ApiOperation("查询设备信息列表（不分页）")
    @GetMapping("/deviceList")
    public BaseResult deviceList(MesDeviceInformation mesDeviceInformation)
    {
        return BaseResult.success(mesDeviceInformationService.selectMesDeviceInformationList(mesDeviceInformation));
    }

    /**
     * 导出设备信息列表
     */
    @ApiOperation("导出设备信息列表")
    @Log(title = "设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesDeviceInformation mesDeviceInformation)
    {
        List<MesDeviceInformation> list = mesDeviceInformationService.selectMesDeviceInformationList(mesDeviceInformation);
        ExcelUtil<MesDeviceInformation> util = new ExcelUtil<MesDeviceInformation>(MesDeviceInformation.class);
        util.exportExcel(response, list, "设备信息数据");
    }

    /**
     * 获取设备信息详细信息
     */
    @ApiOperation("获取设备信息详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult getInfo(@PathVariable("id") Integer id)
    {
        return BaseResult.success(mesDeviceInformationService.selectMesDeviceInformationById(id));
    }

    /**
     * 新增设备信息
     */
    @ApiOperation("新增设备信息")
    @Log(title = "设备信息", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult add(@RequestBody MesDeviceInformation mesDeviceInformation)
    {
        return BaseResult.success(mesDeviceInformationService.insertMesDeviceInformation(mesDeviceInformation));
    }

    /**
     * 修改设备信息
     */
    @ApiOperation("修改设备信息")
    @Log(title = "设备信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult edit(@RequestBody MesDeviceInformation mesDeviceInformation)
    {
        return BaseResult.success(mesDeviceInformationService.updateMesDeviceInformation(mesDeviceInformation));
    }

    /**
     * 删除设备信息
     */
    @ApiOperation("删除设备信息")
    @Log(title = "设备信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult remove(@PathVariable Integer[] ids)
    {
        return BaseResult.success(mesDeviceInformationService.deleteMesDeviceInformationByIds(ids));
    }
}
