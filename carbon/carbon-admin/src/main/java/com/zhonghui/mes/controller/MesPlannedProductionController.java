package com.zhonghui.mes.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.mes.domain.MesPlannedProduction;
import com.zhonghui.mes.domain.vo.MesPlannedProductionVo;
import com.zhonghui.mes.service.IMesPlannedProductionService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 计划排产Controller
 * 
 * @author zhonghui
 * @date 2022-05-22
 */
@Api(tags="计划排产")
@RestController
@RequestMapping("/mes/production")
public class MesPlannedProductionController extends BaseController
{
    @Autowired
    private IMesPlannedProductionService mesPlannedProductionService;

    /**
     * 查询计划排产列表
     */
    @ApiOperation("查询计划排产列表")
    @GetMapping("/list")
    public TableDataInfo list(MesPlannedProductionVo mesPlannedProductionVo)
    {
        startPage();
        List<MesPlannedProductionVo> list = mesPlannedProductionService.selectMesPlannedProductionList(mesPlannedProductionVo);
        return getDataTable(list);
    }

    /**
     * 导出计划排产列表
     */
    @ApiOperation("导出计划排产列表")
    @Log(title = "计划排产", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesPlannedProductionVo mesPlannedProductionVo)
    {
        List<MesPlannedProductionVo> list = mesPlannedProductionService.selectMesPlannedProductionList(mesPlannedProductionVo);
        ExcelUtil<MesPlannedProductionVo> util = new ExcelUtil<MesPlannedProductionVo>(MesPlannedProductionVo.class);
        util.exportExcel(response, list, "计划排产数据");
    }

    /**
     * 获取计划排产详细信息
     */
    @ApiOperation("获取计划排产详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(mesPlannedProductionService.selectMesPlannedProductionById(id));
    }

    /**
     * 新增计划排产
     */
    @ApiOperation("新增计划排产")
    @Log(title = "计划排产", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult add(@RequestBody MesPlannedProduction mesPlannedProduction)
    {
        return BaseResult.success(mesPlannedProductionService.insertMesPlannedProduction(mesPlannedProduction));
    }

    /**
     * 修改计划排产
     */
    @ApiOperation("修改计划排产")
    @Log(title = "计划排产", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult edit(@RequestBody MesPlannedProduction mesPlannedProduction)
    {
        return BaseResult.success(mesPlannedProductionService.updateMesPlannedProduction(mesPlannedProduction));
    }

    /**
     * 删除计划排产
     */
    @ApiOperation("删除计划排产")
    @Log(title = "计划排产", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(mesPlannedProductionService.deleteMesPlannedProductionByIds(ids));
    }
}
