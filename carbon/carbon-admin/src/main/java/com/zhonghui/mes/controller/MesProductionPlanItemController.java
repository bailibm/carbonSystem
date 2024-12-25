package com.zhonghui.mes.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.domain.AjaxResult;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.mes.domain.MesProductionPlanItem;
import com.zhonghui.mes.domain.vo.MesProductionPlanItemVo;
import com.zhonghui.mes.service.IMesProductionPlanItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 生产计划明细Controller
 * 
 * @author zhonghui
 * @date 2022-05-24
 */
@Api(tags ="生产计划明细")
@RestController
@RequestMapping("/mes/planItem")
public class MesProductionPlanItemController extends BaseController
{
    @Autowired
    private IMesProductionPlanItemService mesProductionPlanItemService;

    /**
     * 查询生产计划明细列表
     */
    @ApiOperation("查询生产计划明细列表")
    @GetMapping("/list")
    public TableDataInfo list(MesProductionPlanItemVo mesProductionPlanItemVo)
    {
        startPage();
        List<MesProductionPlanItemVo> list = mesProductionPlanItemService.selectMesProductionPlanItemList(mesProductionPlanItemVo);
        return getDataTable(list);
    }

    /**
     * 导出生产计划明细列表
     */
    @ApiOperation("导出生产计划明细列表")
    @Log(title = "生产计划明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesProductionPlanItemVo mesProductionPlanItemVo)
    {
        List<MesProductionPlanItemVo> list = mesProductionPlanItemService.selectMesProductionPlanItemList(mesProductionPlanItemVo);
        ExcelUtil<MesProductionPlanItemVo> util = new ExcelUtil<MesProductionPlanItemVo>(MesProductionPlanItemVo.class);
        util.exportExcel(response, list, "生产计划明细数据");
    }

    /**
     * 获取生产计划明细详细信息
     */
    @ApiOperation("获取生产计划明细详细信息")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(mesProductionPlanItemService.selectMesProductionPlanItemById(id));
    }

    /**
     * 新增生产计划明细
     */
    @ApiOperation("新增生产计划明细")
    @Log(title = "生产计划明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesProductionPlanItem mesProductionPlanItem)
    {
        return toAjax(mesProductionPlanItemService.insertMesProductionPlanItem(mesProductionPlanItem));
    }

    /**
     * 修改生产计划明细
     */
    @ApiOperation("修改生产计划明细")
    @Log(title = "生产计划明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesProductionPlanItem mesProductionPlanItem)
    {
        return toAjax(mesProductionPlanItemService.updateMesProductionPlanItem(mesProductionPlanItem));
    }

    /**
     * 删除生产计划明细
     */
    @ApiOperation("删除生产计划明细")
    @Log(title = "生产计划明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mesProductionPlanItemService.deleteMesProductionPlanItemByIds(ids));
    }
}
