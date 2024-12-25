package com.zhonghui.mes.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.mes.domain.MesProductionPlan;
import com.zhonghui.mes.domain.vo.MesProductionPlanVo;
import com.zhonghui.mes.service.IMesProductionPlanService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 生产计划Controller
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
@Api(tags="生产计划")
@RestController
@RequestMapping("/mes/plan")
public class MesProductionPlanController extends BaseController
{
    @Autowired
    private IMesProductionPlanService mesProductionPlanService;

    /**
     * 查询生产计划列表
     */
    @ApiOperation("查询生产计划列表")
    @GetMapping("/list")
    public TableDataInfo list(MesProductionPlan mesProductionPlan)
    {
        startPage();
        List<MesProductionPlanVo> list = mesProductionPlanService.selectMesProductionPlanList(mesProductionPlan);
        return getDataTable(list);
    }

    /**
     * 导出生产计划列表
     */
    @ApiOperation("导出生产计划列表")
    @Log(title = "生产计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesProductionPlan mesProductionPlan)
    {
        List<MesProductionPlanVo> list = mesProductionPlanService.selectMesProductionPlanList(mesProductionPlan);
        ExcelUtil<MesProductionPlanVo> util = new ExcelUtil<MesProductionPlanVo>(MesProductionPlanVo.class);
        util.exportExcel(response, list, "生产计划数据");
    }

    /**
     * 获取生产计划详细信息
     */
    @ApiOperation("获取生产计划详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(mesProductionPlanService.selectMesProductionPlanById(id));
    }

    /**
     * 新增生产计划
     */
    @ApiOperation("新增生产计划")
    @Log(title = "生产计划", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult add(@RequestBody MesProductionPlan mesProductionPlan)
    {
        return BaseResult.success(mesProductionPlanService.insertMesProductionPlan(mesProductionPlan));
    }

    /**
     * 修改生产计划
     */
    @ApiOperation("修改生产计划")
    @Log(title = "生产计划", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult edit(@RequestBody MesProductionPlan mesProductionPlan)
    {
        return BaseResult.success(mesProductionPlanService.updateMesProductionPlan(mesProductionPlan));
    }

    /**
     * 删除生产计划
     */
    @ApiOperation("删除生产计划")
    @Log(title = "生产计划", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult remove(@PathVariable String[] ids)
    {
        return BaseResult.success(mesProductionPlanService.deleteMesProductionPlanByIds(ids));
    }
}
