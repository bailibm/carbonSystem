package com.zhonghui.mes.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.mes.domain.MesProjectMaintenance;
import com.zhonghui.mes.service.IMesProjectMaintenanceService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 项目维护Controller
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
@Api(tags="项目维护")
@RestController
@RequestMapping("/mes/maintenance")
public class MesProjectMaintenanceController extends BaseController
{
    @Autowired
    private IMesProjectMaintenanceService mesProjectMaintenanceService;

    /**
     * 查询项目维护列表
     */
    @ApiOperation("查询项目维护列表")
    @GetMapping("/list")
    public TableDataInfo list(MesProjectMaintenance mesProjectMaintenance)
    {
        startPage();
        System.out.println(mesProjectMaintenance.getParams());
        List<MesProjectMaintenance> list = mesProjectMaintenanceService.selectMesProjectMaintenanceList(mesProjectMaintenance);
        return getDataTable(list);
    }

    /**
     * 查询项目维护列表(不分页)
     */
    @ApiOperation("查询项目维护列表(不分页)")
    @GetMapping("/getList")
    public BaseResult getList(MesProjectMaintenance mesProjectMaintenance)
    {
        return BaseResult.success(mesProjectMaintenanceService.selectMesProjectMaintenanceList(mesProjectMaintenance));
    }

    /**
     * 导出项目维护列表
     */
    @ApiOperation("导出项目维护列表")
    @Log(title = "项目维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesProjectMaintenance mesProjectMaintenance)
    {
        List<MesProjectMaintenance> list = mesProjectMaintenanceService.selectMesProjectMaintenanceList(mesProjectMaintenance);
        ExcelUtil<MesProjectMaintenance> util = new ExcelUtil<MesProjectMaintenance>(MesProjectMaintenance.class);
        util.exportExcel(response, list, "项目维护数据");
    }

    /**
     * 获取项目维护详细信息
     */
    @ApiOperation("获取项目维护详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult getInfo(@PathVariable("id") Integer id)
    {
        return BaseResult.success(mesProjectMaintenanceService.selectMesProjectMaintenanceById(id));
    }

    /**
     * 新增项目维护
     */
    @ApiOperation("新增项目维护")
    @Log(title = "项目维护", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult add(@RequestBody MesProjectMaintenance mesProjectMaintenance)
    {
        return BaseResult.success(mesProjectMaintenanceService.insertMesProjectMaintenance(mesProjectMaintenance));
    }

    /**
     * 修改项目维护
     */
    @ApiOperation("修改项目维护")
    @Log(title = "项目维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult edit(@RequestBody MesProjectMaintenance mesProjectMaintenance)
    {
        return BaseResult.success(mesProjectMaintenanceService.updateMesProjectMaintenance(mesProjectMaintenance));
    }

    /**
     * 删除项目维护
     */
    @ApiOperation("删除项目维护")
    @Log(title = "项目维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult remove(@PathVariable Integer[] ids)
    {
        return BaseResult.success(mesProjectMaintenanceService.deleteMesProjectMaintenanceByIds(ids));
    }
}
