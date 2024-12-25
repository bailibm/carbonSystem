package com.zhonghui.mes.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.mes.domain.MesProduct;
import com.zhonghui.mes.domain.vo.MesProductVo;
import com.zhonghui.mes.service.IMesProductService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 产品建模Controller
 * 
 * @author zhonghui
 * @date 2022-05-20
 */
@Api(tags="产品建模")
@RestController
@RequestMapping("/mes/product")
public class MesProductController extends BaseController
{
    @Autowired
    private IMesProductService mesProductService;

    /**
     * 查询产品建模列表
     */
    @ApiOperation("查询产品建模列表")
    @GetMapping("/list")
    public TableDataInfo list(MesProduct mesProduct)
    {
        startPage();
        List<MesProductVo> list = mesProductService.selectMesProductList(mesProduct);
        return getDataTable(list);
    }

    /**
     * 查询产品建模列表（不分页）
     */
    @ApiOperation("查询产品建模列表（不分页）")
    @GetMapping("/getList")
    public BaseResult getList(MesProduct mesProduct)
    {
        return BaseResult.success(mesProductService.selectMesProductList(mesProduct));
    }

    /**
     * 导出产品建模列表
     */
    @ApiOperation("导出产品建模列表")
    @Log(title = "产品建模", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesProduct mesProduct)
    {
        List<MesProductVo> list = mesProductService.selectMesProductList(mesProduct);
        ExcelUtil<MesProductVo> util = new ExcelUtil<MesProductVo>(MesProductVo.class);
        util.exportExcel(response, list, "产品建模数据");
    }

    /**
     * 获取产品建模详细信息
     */
    @ApiOperation("获取产品建模详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(mesProductService.selectMesProductById(id));
    }

    /**
     * 新增产品建模
     */
    @ApiOperation("新增产品建模")
    @Log(title = "产品建模", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult add(@RequestBody MesProduct mesProduct)
    {
        return BaseResult.success(mesProductService.insertMesProduct(mesProduct));
    }

    /**
     * 修改产品建模
     */
    @ApiOperation("修改产品建模")
    @Log(title = "产品建模", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult edit(@RequestBody MesProduct mesProduct)
    {
        return BaseResult.success(mesProductService.updateMesProduct(mesProduct));
    }

    /**
     * 删除产品建模
     */
    @ApiOperation("删除产品建模")
    @Log(title = "产品建模", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(mesProductService.deleteMesProductByIds(ids));
    }
}
