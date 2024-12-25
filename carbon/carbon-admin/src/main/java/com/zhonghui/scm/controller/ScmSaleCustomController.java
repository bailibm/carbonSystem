package com.zhonghui.scm.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.response.BaseResult;
import com.zhonghui.scm.domain.ScmSaleCustom;
import com.zhonghui.scm.domain.ScmSaleCustomBill;
import com.zhonghui.scm.service.IScmSaleCustomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 客户档案Controller
 * 
 * @author zhonghui
 * @date 2022-05-19
 */
@Api(tags="供应链SCM-销售管理-客户档案")
@RestController
@RequestMapping("/scm/custom")
public class ScmSaleCustomController extends BaseController
{
    @Autowired
    private IScmSaleCustomService scmSaleCustomService;

    /**
     * 查询客户档案列表
     */
    @ApiOperation("销售管理-客户档案列表")
//    @PreAuthorize("@ss.hasPermi('scm:custom:list')")
    @GetMapping("/list")
    public TableDataInfo list(ScmSaleCustom scmSaleCustom)
    {
        startPage();
        List<ScmSaleCustom> list = scmSaleCustomService.selectScmSaleCustomList(scmSaleCustom);
        return getDataTable(list);
    }

    /**
     * 查询客户档案列表（不分页）
     */
    @ApiOperation("销售管理-客户档案列表（不分页）")
    @GetMapping("/customList")
    public List<ScmSaleCustom> customList(ScmSaleCustom scmSaleCustom)
    {
        return scmSaleCustomService.selectScmSaleCustomList(scmSaleCustom);
    }

    /**
     * 导出客户档案列表
     */
    @ApiOperation("导出销售管理-客户档案列表")
//    @PreAuthorize("@ss.hasPermi('scm:custom:export')")
    @Log(title = "客户档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScmSaleCustom scmSaleCustom)
    {
        List<ScmSaleCustom> list = scmSaleCustomService.selectScmSaleCustomList(scmSaleCustom);
        ExcelUtil<ScmSaleCustom> util = new ExcelUtil<ScmSaleCustom>(ScmSaleCustom.class);
        util.exportExcel(response, list, "客户档案数据");
    }

    /**
     * 获取客户档案详细信息
     */
    @ApiOperation("销售管理-客户档案详细信息")
//    @PreAuthorize("@ss.hasPermi('scm:custom:query')")
    @GetMapping(value = "/{id}")
    public BaseResult getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(scmSaleCustomService.selectScmSaleCustomById(id));
    }

    /**
     * 新增客户档案
     */
    @ApiOperation("新增销售管理-客户档案")
//    @PreAuthorize("@ss.hasPermi('scm:custom:add')")
    @Log(title = "客户档案", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult add(@RequestBody ScmSaleCustom scmSaleCustom)
    {
        return BaseResult.success(scmSaleCustomService.insertScmSaleCustom(scmSaleCustom));
    }

    /**
     * 修改客户档案
     */
    @ApiOperation("修改销售管理-客户档案")
//    @PreAuthorize("@ss.hasPermi('scm:custom:edit')")
    @Log(title = "客户档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult edit(@RequestBody ScmSaleCustom scmSaleCustom)
    {
        return BaseResult.success(scmSaleCustomService.updateScmSaleCustom(scmSaleCustom));
    }

    /**
     * 删除客户档案
     */
    @ApiOperation("删除销售管理-客户档案")
//    @PreAuthorize("@ss.hasPermi('scm:custom:remove')")
    @Log(title = "客户档案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(scmSaleCustomService.deleteScmSaleCustomByIds(ids));
    }

    /**
     * 查询客户对账
     */
    @PostMapping("/bill")
    public BaseResult remove(ScmSaleCustomBill scmSaleCustomBill)
    {
        if (scmSaleCustomBill.getType() == null){
            return BaseResult.error("请传入统计类型");
        }
        return BaseResult.success(scmSaleCustomService.bill(scmSaleCustomBill));
    }
}
