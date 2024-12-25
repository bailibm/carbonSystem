package com.zhonghui.wms.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.response.BaseResult;
import com.zhonghui.wms.domain.WmsWarehouse;
import com.zhonghui.wms.service.IWmsWarehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 仓库Controller
 * 
 * @author zhonghui
 * @date 2022-05-20
 */
@Api(tags="智能仓储WMS-仓库")
@RestController
@RequestMapping("/wms/warehouse")
public class WmsWarehouseController extends BaseController
{
    @Autowired
    private IWmsWarehouseService wmsWarehouseService;

    /**
     * 查询仓库列表
     */
    @ApiOperation("查询智能仓储WMS-仓库列表")
//    @PreAuthorize("@ss.hasPermi('wms:warehouse:list')")
    @GetMapping("/list")
    public TableDataInfo list(WmsWarehouse wmsWarehouse)
    {
        startPage();
        List<WmsWarehouse> list = wmsWarehouseService.selectWmsWarehouseList(wmsWarehouse);
        return getDataTable(list);
    }

    /**
     * 查询仓库不分页
     */
    @ApiOperation("查询智能仓储WMS-仓库不分页")
//    @PreAuthorize("@ss.hasPermi('wms:warehouse:list')")
    @GetMapping("/warehouseList")
    public List<WmsWarehouse> warehouseList(WmsWarehouse wmsWarehouse)
    {
        return wmsWarehouseService.selectWmsWarehouseList(wmsWarehouse);
    }

    /**
     * 导出仓库列表
     */
    @ApiOperation("导出智能仓储WMS-仓库列表")
//    @PreAuthorize("@ss.hasPermi('wms:warehouse:export')")
    @Log(title = "仓库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsWarehouse wmsWarehouse)
    {
        List<WmsWarehouse> list = wmsWarehouseService.selectWmsWarehouseList(wmsWarehouse);
        ExcelUtil<WmsWarehouse> util = new ExcelUtil<WmsWarehouse>(WmsWarehouse.class);
        util.exportExcel(response, list, "仓库数据");
    }

    /**
     * 获取仓库详细信息
     */
    @ApiOperation("获取智能仓储WMS-仓库详细信息")
//    @PreAuthorize("@ss.hasPermi('wms:warehouse:query')")
    @GetMapping(value = "/{id}")
    public BaseResult getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(wmsWarehouseService.selectWmsWarehouseById(id));
    }

    /**
     * 新增仓库
     */
    @ApiOperation("新增智能仓储WMS-仓库")
//    @PreAuthorize("@ss.hasPermi('wms:warehouse:add')")
    @Log(title = "仓库", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult add(@RequestBody WmsWarehouse wmsWarehouse)
    {
        return BaseResult.success(wmsWarehouseService.insertWmsWarehouse(wmsWarehouse));
    }

    /**
     * 修改仓库
     */
    @ApiOperation("修改智能仓储WMS-仓库")
//    @PreAuthorize("@ss.hasPermi('wms:warehouse:edit')")
    @Log(title = "仓库", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult edit(@RequestBody WmsWarehouse wmsWarehouse)
    {
        return BaseResult.success(wmsWarehouseService.updateWmsWarehouse(wmsWarehouse));
    }

    /**
     * 删除仓库
     */
    @ApiOperation("删除智能仓储WMS-仓库")
//    @PreAuthorize("@ss.hasPermi('wms:warehouse:remove')")
    @Log(title = "仓库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(wmsWarehouseService.deleteWmsWarehouseByIds(ids));
    }
}
