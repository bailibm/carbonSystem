package com.zhonghui.mes.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.mes.domain.MesFactory;
import com.zhonghui.mes.service.IMesFactoryService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 工厂建模Controller
 * 
 * @author zhonghui
 * @date 2022-05-20
 */
@Api(tags="工厂建模")
@RestController
@RequestMapping("/mes/factory")
public class MesFactoryController extends BaseController
{
    @Autowired
    private IMesFactoryService mesFactoryService;

    /**
     * 查询工厂建模列表
     */
    @ApiOperation("查询工厂建模列表")
    @GetMapping("/list")
    public TableDataInfo list(MesFactory mesFactory)
    {
        startPage();
        List<MesFactory> list = mesFactoryService.selectMesFactoryList(mesFactory);
        return getDataTable(list);
    }

    /**
     * 查询工厂建模列表(不分页)
     */
    @ApiOperation("查询工厂建模列表(不分页)")
    @GetMapping("/getList")
    public BaseResult getList(MesFactory mesFactory)
    {
        return BaseResult.success(mesFactoryService.selectMesFactoryList(mesFactory));
    }

    /**
     * 导出工厂建模列表
     */
    @ApiOperation("导出工厂建模列表")
    @Log(title = "工厂建模", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesFactory mesFactory)
    {
        List<MesFactory> list = mesFactoryService.selectMesFactoryList(mesFactory);
        ExcelUtil<MesFactory> util = new ExcelUtil<MesFactory>(MesFactory.class);
        util.exportExcel(response, list, "工厂建模数据");
    }

    /**
     * 获取工厂建模详细信息
     */
    @ApiOperation("获取工厂建模详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(mesFactoryService.selectMesFactoryById(id));
    }

    /**
     * 新增工厂建模
     */
    @ApiOperation("新增工厂建模")
    @Log(title = "工厂建模", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult add(@RequestBody MesFactory mesFactory)
    {
        return BaseResult.success(mesFactoryService.insertMesFactory(mesFactory));
    }

    /**
     * 修改工厂建模
     */
    @ApiOperation("修改工厂建模")
    @Log(title = "工厂建模", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult edit(@RequestBody MesFactory mesFactory)
    {
        return BaseResult.success(mesFactoryService.updateMesFactory(mesFactory));
    }

    /**
     * 删除工厂建模
     */
    @ApiOperation("删除工厂建模")
    @Log(title = "工厂建模", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(mesFactoryService.deleteMesFactoryByIds(ids));
    }
}
