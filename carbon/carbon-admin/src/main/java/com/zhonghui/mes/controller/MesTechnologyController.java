package com.zhonghui.mes.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.mes.domain.MesTechnology;
import com.zhonghui.mes.domain.vo.MesTechnologyVo;
import com.zhonghui.mes.service.IMesTechnologyService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 工艺建模Controller
 *
 * @author carbon
 * @date 2022-05-19
 */
@Api(tags="工艺建模")
@RestController
@RequestMapping("/mes/technology")
public class MesTechnologyController extends BaseController
{
    @Autowired
    private IMesTechnologyService mesTechnologyService;

    /**
     * 查询工艺建模列表
     */
    @ApiOperation("查询工艺建模列表")
    @GetMapping("/list")
    public TableDataInfo list(MesTechnology mesTechnology)
    {
        startPage();
        List<MesTechnologyVo> list = mesTechnologyService.selectMesTechnologyList(mesTechnology);
        return getDataTable(list);
    }

    /**
     * 查询工艺建模列表(不分页)
     */
    @ApiOperation("查询工艺建模列表(不分页)")
    @GetMapping("/getList")
    public BaseResult getList(MesTechnology mesTechnology)
    {
        return BaseResult.success(mesTechnologyService.selectMesTechnologyList(mesTechnology));
    }

    /**
     * 导出工艺建模列表
     */
    @ApiOperation("导出工艺建模列表")
    @Log(title = "工艺建模", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesTechnology mesTechnology)
    {
        List<MesTechnologyVo> list = mesTechnologyService.selectMesTechnologyList(mesTechnology);
        ExcelUtil<MesTechnologyVo> util = new ExcelUtil<MesTechnologyVo>(MesTechnologyVo.class);
        util.exportExcel(response, list, "工艺建模数据");
    }

    /**
     * 获取工艺建模详细信息
     */
    @ApiOperation("获取工艺建模详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(mesTechnologyService.selectMesTechnologyById(id));
    }

    /**
     * 新增工艺建模
     */
    @ApiOperation("新增工艺建模")
    @Log(title = "工艺建模", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult add(@RequestBody MesTechnology mesTechnology)
    {
        return BaseResult.success(mesTechnologyService.insertMesTechnology(mesTechnology));
    }

    /**
     * 修改工艺建模
     */
    @ApiOperation("修改工艺建模")
    @Log(title = "工艺建模", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult edit(@RequestBody MesTechnology mesTechnology)
    {
        return BaseResult.success(mesTechnologyService.updateMesTechnology(mesTechnology));
    }

    /**
     * 删除工艺建模
     */
    @ApiOperation("删除工艺建模")
    @Log(title = "工艺建模", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public BaseResult remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(mesTechnologyService.deleteMesTechnologyByIds(ids));
    }
}
