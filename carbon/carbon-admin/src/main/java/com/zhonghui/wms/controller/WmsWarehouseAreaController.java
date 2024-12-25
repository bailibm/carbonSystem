package com.zhonghui.wms.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.response.BaseResult;
import com.zhonghui.wms.domain.WmsWarehouseArea;
import com.zhonghui.wms.service.IWmsWarehouseAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 库区Controller
 * 
 * @author zhonghui
 * @date 2022-05-26
 */
@Api(tags="智能仓储WMS-库区")
@RestController
@RequestMapping("/wms/area")
public class WmsWarehouseAreaController extends BaseController
{
    @Autowired
    private IWmsWarehouseAreaService wmsWarehouseAreaService;

    /**
     * 查询库区列表
     */
    @ApiOperation("查询智能仓储WMS-库区列表")
//    @PreAuthorize("@ss.hasPermi('wms:area:list')")
    @GetMapping("/list")
    public TableDataInfo list(WmsWarehouseArea wmsWarehouseArea)
    {
        startPage();
        List<WmsWarehouseArea> list = wmsWarehouseAreaService.selectWmsWarehouseAreaList(wmsWarehouseArea);
        return getDataTable(list);
    }
    /**
     * 查询库区列表不分页
     */
    @ApiOperation("查询智能仓储WMS-库区不分页")
//    @PreAuthorize("@ss.hasPermi('wms:area:areaList')")
    @GetMapping("/areaList")
    public List<WmsWarehouseArea> areaList(WmsWarehouseArea wmsWarehouseArea)
    {
        return wmsWarehouseAreaService.selectWmsWarehouseAreaList(wmsWarehouseArea);
    }
    /**
     * 导出库区列表
     */
    @ApiOperation("导出智能仓储WMS-库区列表")
//    @PreAuthorize("@ss.hasPermi('wms:area:export')")
    @Log(title = "库区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsWarehouseArea wmsWarehouseArea)
    {
        List<WmsWarehouseArea> list = wmsWarehouseAreaService.selectWmsWarehouseAreaList(wmsWarehouseArea);
        ExcelUtil<WmsWarehouseArea> util = new ExcelUtil<WmsWarehouseArea>(WmsWarehouseArea.class);
        util.exportExcel(response, list, "库区数据");
    }

    /**
     * 获取库区详细信息
     */
    @ApiOperation("获取智能仓储WMS-库区详细信息")
//    @PreAuthorize("@ss.hasPermi('wms:area:query')")
    @GetMapping(value = "/{id}")
    public BaseResult getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(wmsWarehouseAreaService.selectWmsWarehouseAreaById(id));
    }

    /**
     * 新增库区
     */
    @ApiOperation("新增智能仓储WMS-库区")
//    @PreAuthorize("@ss.hasPermi('wms:area:add')")
    @Log(title = "库区", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult add(@RequestBody WmsWarehouseArea wmsWarehouseArea)
    {
        return BaseResult.success(wmsWarehouseAreaService.insertWmsWarehouseArea(wmsWarehouseArea));
    }

    /**
     * 修改库区
     */
    @ApiOperation("修改智能仓储WMS-库区")
//    @PreAuthorize("@ss.hasPermi('wms:area:edit')")
    @Log(title = "库区", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult edit(@RequestBody WmsWarehouseArea wmsWarehouseArea)
    {
        return BaseResult.success(wmsWarehouseAreaService.updateWmsWarehouseArea(wmsWarehouseArea));
    }

    /**
     * 删除库区
     */
    @ApiOperation("删除智能仓储WMS-库区")
//    @PreAuthorize("@ss.hasPermi('wms:area:remove')")
    @Log(title = "库区", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(wmsWarehouseAreaService.deleteWmsWarehouseAreaByIds(ids));
    }
}
