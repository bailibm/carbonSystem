package com.zhonghui.scm.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.response.BaseResult;
import com.zhonghui.scm.domain.ScmSaleOrder;
import com.zhonghui.scm.domain.vo.ScmSaleOrderVo;
import com.zhonghui.scm.service.IScmSaleOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 供应链SCM-销售管理-销售订单Controller
 * 
 * @author zhonghui
 * @date 2022-05-20
 */
@Api(tags="供应链SCM-销售管理-销售订单")
@RestController
@RequestMapping("/scm/order")
public class ScmSaleOrderController extends BaseController
{
    @Autowired
    private IScmSaleOrderService scmSaleOrderService;

    /**
     * 查询供应链SCM-销售管理-销售订单列表
     */
    @ApiOperation("销售管理-销售订单列表")
    @GetMapping("/list")
    public TableDataInfo list(ScmSaleOrder scmSaleOrder)
    {
        startPage();
        List<ScmSaleOrderVo> list = scmSaleOrderService.selectScmSaleOrderList(scmSaleOrder);
        return getDataTable(list);
    }

    /**
     * 销售订单列表(不分页)
     */
    @ApiOperation("销售管理-销售订单列表(不分页)")
    @GetMapping("/getList")
    public BaseResult getList(ScmSaleOrder scmSaleOrder)
    {
        return BaseResult.success(scmSaleOrderService.selectScmSaleOrderList(scmSaleOrder));
    }

    /**
     * 导出供应链SCM-销售管理-销售订单列表
     */
    @ApiOperation("导出销售管理-销售订单列表")
    @Log(title = "供应链SCM-销售管理-销售订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScmSaleOrder scmSaleOrder)
    {
        List<ScmSaleOrderVo> list = scmSaleOrderService.selectScmSaleOrderList(scmSaleOrder);
        ExcelUtil<ScmSaleOrderVo> util = new ExcelUtil<ScmSaleOrderVo>(ScmSaleOrderVo.class);
        util.exportExcel(response, list, "供应链SCM-销售管理-销售订单数据");
    }

    /**
     * 获取供应链SCM-销售管理-销售订单详细信息
     */
    @ApiOperation("销售管理-销售订单详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(scmSaleOrderService.selectScmSaleOrderById(id));
    }

    /**
     * 新增供应链SCM-销售管理-销售订单
     */
    @ApiOperation("新增销售管理-销售订单")
    @Log(title = "供应链SCM-销售管理-销售订单", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult add(@RequestBody ScmSaleOrder scmSaleOrder)
    {
        return BaseResult.success(scmSaleOrderService.insertScmSaleOrder(scmSaleOrder));
    }

    /**
     * 修改供应链SCM-销售管理-销售订单
     */
    @ApiOperation("修改销售管理-销售订单")
    @Log(title = "供应链SCM-销售管理-销售订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult edit(@RequestBody ScmSaleOrder scmSaleOrder)
    {
        return BaseResult.success(scmSaleOrderService.updateScmSaleOrder(scmSaleOrder));
    }

    /**
     * 删除供应链SCM-销售管理-销售订单
     */
    @ApiOperation("删除销售管理-销售订单")
    @Log(title = "供应链SCM-销售管理-销售订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(scmSaleOrderService.deleteScmSaleOrderByIds(ids));
    }
}
