package com.zhonghui.wms.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.domain.entity.WmsMaterialClassify;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.response.BaseResult;
import com.zhonghui.wms.domain.WmsMaterial;
import com.zhonghui.wms.service.IWmsMaterialClassifyService;
import com.zhonghui.wms.service.IWmsMaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 物料档案Controller
 * 
 * @author zhonghui
 * @date 2022-05-19
 */
@Api(tags="智能仓储WMS-物料档案")
@RestController
@RequestMapping("/wms/material")
public class WmsMaterialController extends BaseController
{
    @Autowired
    private IWmsMaterialService wmsMaterialService;

    @Autowired
    private IWmsMaterialClassifyService wmsMaterialClassifyService;

    /**
     * 查询物料档案列表
     */
    @ApiOperation("查询智能仓储WMS-物料档案列表")
    @GetMapping("/list")
    public TableDataInfo list(WmsMaterial wmsMaterial)
    {
        startPage();
        List<WmsMaterial> list = wmsMaterialService.selectWmsMaterialList(wmsMaterial);
        return getDataTable(list);
    }

    /**
     * 查询物料档案列表不分页
     */
    @ApiOperation("查询智能仓储WMS-物料档案列表不分页")
    @GetMapping("/materialList")
    public List<WmsMaterial> materialList(WmsMaterial wmsMaterial)
    {
        return wmsMaterialService.selectWmsMaterialList(wmsMaterial);
    }

    /**
     * 导出物料档案列表
     */
    @ApiOperation("导出智能仓储WMS-物料档案列表")
    @Log(title = "物料档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsMaterial wmsMaterial)
    {
        List<WmsMaterial> list = wmsMaterialService.selectWmsMaterialList(wmsMaterial);
        ExcelUtil<WmsMaterial> util = new ExcelUtil<WmsMaterial>(WmsMaterial.class);
        util.exportExcel(response, list, "物料档案数据");
    }

    /**
     * 获取物料档案详细信息
     */
    @ApiOperation("获取智能仓储WMS-物料档案详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(wmsMaterialService.selectWmsMaterialById(id));
    }

    /**
     * 新增物料档案
     */
    @ApiOperation("新增智能仓储WMS-物料档案")
    @Log(title = "物料档案", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult add(@RequestBody WmsMaterial wmsMaterial)
    {
        return BaseResult.success(wmsMaterialService.insertWmsMaterial(wmsMaterial));
    }

    /**
     * 修改物料档案
     */
    @ApiOperation("修改智能仓储WMS-物料档案")
    @Log(title = "物料档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult edit(@RequestBody WmsMaterial wmsMaterial)
    {
        return BaseResult.success(wmsMaterialService.updateWmsMaterial(wmsMaterial));
    }

    /**
     * 删除物料档案
     */
    @ApiOperation("删除智能仓储WMS-物料档案")
    @Log(title = "物料档案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(wmsMaterialService.deleteWmsMaterialByIds(ids));
    }

    /**
     * 获取物料分类树列表
     */
    @ApiOperation("获取智能仓储WMS-物料分类树列表")
    @GetMapping("/classifyTree")
    public BaseResult classifyTree(WmsMaterialClassify wmsMaterialClassify)
    {
        return BaseResult.success(wmsMaterialClassifyService.selectClassifyTreeList(wmsMaterialClassify));
    }
}
