package com.zhonghui.mes.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.mes.domain.MesBom;
import com.zhonghui.mes.domain.vo.MesBomVo;
import com.zhonghui.mes.service.IMesBomService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * BomController
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
@Api(tags="Bom")
@RestController
@RequestMapping("/mes/bom")
public class MesBomController extends BaseController
{
    @Autowired
    private IMesBomService mesBomService;

    /**
     * 查询Bom列表
     */
    @ApiOperation("查询Bom列表")
    @GetMapping("/list")
    public TableDataInfo list(MesBom mesBom)
    {
        startPage();
        List<MesBomVo> list = mesBomService.selectMesBomList(mesBom);
        return getDataTable(list);
    }

    /**
     * 查询Bom列表(不分页)
     */
    @ApiOperation("查询Bom列表(不分页)")
    @GetMapping("/getList")
    public BaseResult getList(MesBom mesBom)
    {
        return BaseResult.success(mesBomService.selectMesBomList(mesBom));
    }

    /**
     * 查询Bom列表(通过计划id)
     */
    @ApiOperation("查询Bom列表(通过计划id)")
    @GetMapping(value = "/getListByMaterialId/{id}")
    public BaseResult getListByMaterialId(@PathVariable("id") Long id)
    {
        return BaseResult.success(mesBomService.selectMesBomListByMaterialId(id));
    }

    /**
     * 导出Bom列表
     */
    @ApiOperation("导出Bom列表")
    @Log(title = "Bom", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesBom mesBom)
    {
        List<MesBomVo> list = mesBomService.selectMesBomList(mesBom);
        ExcelUtil<MesBomVo> util = new ExcelUtil<MesBomVo>(MesBomVo.class);
        util.exportExcel(response, list, "Bom数据");
    }

    /**
     * 获取Bom详细信息
     */
    @ApiOperation("获取Bom详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(mesBomService.selectMesBomById(id));
    }

    /**
     * 新增Bom
     */
    @ApiOperation("新增Bom")
    @Log(title = "Bom", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult add(@RequestBody MesBom mesBom)
    {
        return BaseResult.success(mesBomService.insertMesBom(mesBom));
    }

    /**
     * 修改Bom
     */
    @ApiOperation("修改Bom")
    @Log(title = "Bom", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult edit(@RequestBody MesBom mesBom)
    {
        return BaseResult.success(mesBomService.updateMesBom(mesBom));
    }

    /**
     * 删除Bom
     */
    @ApiOperation("删除Bom")
    @Log(title = "Bom", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(mesBomService.deleteMesBomByIds(ids));
    }
}
