package com.zhonghui.dc.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.zhonghui.dc.domain.DcChangedCarbonEmissions;
import com.zhonghui.dc.service.IDcChangedCarbonEmissionsService;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.common.core.page.TableDataInfo;

/**
 * 变化碳排放Controller
 * 
 * @author zhonghui
 * @date 2022-05-24
 */
@Api(tags="智造双碳—变化碳排放")
@RestController
@RequestMapping("/dc/changedEmissions")
public class DcChangedCarbonEmissionsController extends BaseController
{
    @Autowired
    private IDcChangedCarbonEmissionsService dcChangedCarbonEmissionsService;

    /**
     * 查询变化碳排放列表
     */
    @ApiOperation("查询变化碳排放列表")
    @GetMapping("/list")
    public TableDataInfo<List<DcChangedCarbonEmissions>> list(DcChangedCarbonEmissions dcChangedCarbonEmissions)
    {
        startPage();
        List<DcChangedCarbonEmissions> list = dcChangedCarbonEmissionsService.selectDcChangedCarbonEmissionsList(dcChangedCarbonEmissions);
        return getDataTable(list);
    }

    /**
     * 导出变化碳排放列表
     */
    @ApiOperation("导出变化碳排放列表")
    @Log(title = "变化碳排放", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DcChangedCarbonEmissions dcChangedCarbonEmissions)
    {
        List<DcChangedCarbonEmissions> list = dcChangedCarbonEmissionsService.selectDcChangedCarbonEmissionsList(dcChangedCarbonEmissions);
        ExcelUtil<DcChangedCarbonEmissions> util = new ExcelUtil<DcChangedCarbonEmissions>(DcChangedCarbonEmissions.class);
        util.exportExcel(response, list, "变化碳排放数据");
    }

    /**
     * 获取变化碳排放详细信息
     */
    @ApiOperation("获取变化碳排放详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult<DcChangedCarbonEmissions> getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(dcChangedCarbonEmissionsService.selectDcChangedCarbonEmissionsById(id));
    }

    /**
     * 新增变化碳排放
     */
    @ApiOperation("新增变化碳排放")
    @Log(title = "变化碳排放", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult<Integer> add(@RequestBody DcChangedCarbonEmissions dcChangedCarbonEmissions)
    {
        return BaseResult.success(dcChangedCarbonEmissionsService.insertDcChangedCarbonEmissions(dcChangedCarbonEmissions));
    }

    /**
     * 修改变化碳排放
     */
    @ApiOperation("修改变化碳排放")
    @Log(title = "变化碳排放", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult<Integer> edit(@RequestBody DcChangedCarbonEmissions dcChangedCarbonEmissions)
    {
        return BaseResult.success(dcChangedCarbonEmissionsService.updateDcChangedCarbonEmissions(dcChangedCarbonEmissions));
    }

    /**
     * 删除变化碳排放
     */
    @ApiOperation("删除变化碳排放")
    @Log(title = "变化碳排放", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult<Integer> remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(dcChangedCarbonEmissionsService.deleteDcChangedCarbonEmissionsByIds(ids));
    }
}
