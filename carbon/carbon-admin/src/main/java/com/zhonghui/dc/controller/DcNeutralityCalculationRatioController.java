package com.zhonghui.dc.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.domain.AjaxResult;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.dc.domain.DcNeutralityCalculationRatio;
import com.zhonghui.dc.service.IDcNeutralityCalculationRatioService;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.common.core.page.TableDataInfo;

/**
 * 碳中和计算比例Controller
 * 
 * @author zhonghui
 * @date 2022-05-27
 */
@Api(tags="智造双碳—碳中和计算比例")
@RestController
@RequestMapping("/dc/neutrality")
public class DcNeutralityCalculationRatioController extends BaseController
{
    @Autowired
    private IDcNeutralityCalculationRatioService dcNeutralityCalculationRatioService;

    /**
     * 查询碳中和计算比例列表
     */
    @ApiOperation("查询变化碳排放列表")
    @GetMapping("/list")
    public TableDataInfo<List<DcNeutralityCalculationRatio>> list(DcNeutralityCalculationRatio dcNeutralityCalculationRatio)
    {
        startPage();
        List<DcNeutralityCalculationRatio> list = dcNeutralityCalculationRatioService.selectDcNeutralityCalculationRatioList(dcNeutralityCalculationRatio);
        return getDataTable(list);
    }

    /**
     * 导出碳中和计算比例列表
     */
    @ApiOperation("导出碳中和计算比例列表")
    @Log(title = "碳中和计算比例", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DcNeutralityCalculationRatio dcNeutralityCalculationRatio)
    {
        List<DcNeutralityCalculationRatio> list = dcNeutralityCalculationRatioService.selectDcNeutralityCalculationRatioList(dcNeutralityCalculationRatio);
        ExcelUtil<DcNeutralityCalculationRatio> util = new ExcelUtil<DcNeutralityCalculationRatio>(DcNeutralityCalculationRatio.class);
        util.exportExcel(response, list, "碳中和计算比例数据");
    }

    /**
     * 获取碳中和计算比例详细信息
     */
    @ApiOperation("获取碳中和计算比例详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult<DcNeutralityCalculationRatio> getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(dcNeutralityCalculationRatioService.selectDcNeutralityCalculationRatioById(id));
    }

    /**
     * 新增碳中和计算比例
     */
    @ApiOperation("新增碳中和计算比例")
    @Log(title = "碳中和计算比例", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult<Integer> add(@RequestBody DcNeutralityCalculationRatio dcNeutralityCalculationRatio)
    {
        return BaseResult.success(dcNeutralityCalculationRatioService.insertDcNeutralityCalculationRatio(dcNeutralityCalculationRatio));
    }

    /**
     * 修改碳中和计算比例
     */
    @ApiOperation("修改碳中和计算比例")
    @Log(title = "碳中和计算比例", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult<Integer> edit(@RequestBody DcNeutralityCalculationRatio dcNeutralityCalculationRatio)
    {
        return BaseResult.success(dcNeutralityCalculationRatioService.updateDcNeutralityCalculationRatio(dcNeutralityCalculationRatio));
    }

    /**
     * 删除碳中和计算比例
     */
    @ApiOperation("删除碳中和计算比例")
    @Log(title = "碳中和计算比例", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult<Integer> remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(dcNeutralityCalculationRatioService.deleteDcNeutralityCalculationRatioByIds(ids));
    }
}
