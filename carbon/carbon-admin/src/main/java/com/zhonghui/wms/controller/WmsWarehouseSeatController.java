package com.zhonghui.wms.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.response.BaseResult;
import com.zhonghui.wms.domain.WmsWarehouseSeat;
import com.zhonghui.wms.service.IWmsWarehouseSeatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 库位Controller
 * 
 * @author zhonghui
 * @date 2022-05-27
 */
@Api(tags="智能仓储WMS-库位")
@RestController
@RequestMapping("/wms/seat")
public class WmsWarehouseSeatController extends BaseController
{
    @Autowired
    private IWmsWarehouseSeatService wmsWarehouseSeatService;

    /**
     * 查询库位列表
     */
    @ApiOperation("查询智能仓储WMS-库位列表")
//    @PreAuthorize("@ss.hasPermi('wms:seat:list')")
    @GetMapping("/list")
    public TableDataInfo list(WmsWarehouseSeat wmsWarehouseSeat)
    {
        startPage();
        List<WmsWarehouseSeat> list = wmsWarehouseSeatService.selectWmsWarehouseSeatList(wmsWarehouseSeat);
        return getDataTable(list);
    }
    /**
     * 查询库位列表不分页
     */
    @ApiOperation("查询智能仓储WMS-库位不分页")
//    @PreAuthorize("@ss.hasPermi('wms:area:seatList')")
    @GetMapping("/seatList")
    public List<WmsWarehouseSeat> seatList(WmsWarehouseSeat wmsWarehouseSeat)
    {
        return wmsWarehouseSeatService.selectWmsWarehouseSeatList(wmsWarehouseSeat);
    }
    /**
     * 导出库位列表
     */
    @ApiOperation("导出智能仓储WMS-库位列表")
//    @PreAuthorize("@ss.hasPermi('wms:seat:export')")
    @Log(title = "库位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsWarehouseSeat wmsWarehouseSeat)
    {
        List<WmsWarehouseSeat> list = wmsWarehouseSeatService.selectWmsWarehouseSeatList(wmsWarehouseSeat);
        ExcelUtil<WmsWarehouseSeat> util = new ExcelUtil<WmsWarehouseSeat>(WmsWarehouseSeat.class);
        util.exportExcel(response, list, "库位数据");
    }

    /**
     * 获取库位详细信息
     */
    @ApiOperation("获取智能仓储WMS-库位详细信息")
//    @PreAuthorize("@ss.hasPermi('wms:seat:query')")
    @GetMapping(value = "/{id}")
    public BaseResult getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(wmsWarehouseSeatService.selectWmsWarehouseSeatById(id));
    }

    /**
     * 新增库位
     */
    @ApiOperation("新增智能仓储WMS-库位")
//    @PreAuthorize("@ss.hasPermi('wms:seat:add')")
    @Log(title = "库位", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult add(@RequestBody WmsWarehouseSeat wmsWarehouseSeat)
    {
        return BaseResult.success(wmsWarehouseSeatService.insertWmsWarehouseSeat(wmsWarehouseSeat));
    }

    /**
     * 修改库位
     */
    @ApiOperation("修改智能仓储WMS-库位")
//    @PreAuthorize("@ss.hasPermi('wms:seat:edit')")
    @Log(title = "库位", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult edit(@RequestBody WmsWarehouseSeat wmsWarehouseSeat)
    {
        return BaseResult.success(wmsWarehouseSeatService.updateWmsWarehouseSeat(wmsWarehouseSeat));
    }

    /**
     * 删除库位
     */
    @ApiOperation("删除智能仓储WMS-库位")
//    @PreAuthorize("@ss.hasPermi('wms:seat:remove')")
    @Log(title = "库位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(wmsWarehouseSeatService.deleteWmsWarehouseSeatByIds(ids));
    }
}
