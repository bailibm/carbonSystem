package com.zhonghui.procurementManagement.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.domain.AjaxResult;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.procurementManagement.domain.PmPoliciesRegulations;
import com.zhonghui.procurementManagement.service.IPmPoliciesRegulationsService;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.common.core.page.TableDataInfo;

/**
 * 政策法规Controller
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Api(tags="采购管理系统-后台-政策法规")
@RestController
@RequestMapping("/procurementManagement/PoliciesRegulations")
public class PmPoliciesRegulationsController extends BaseController
{
    @Autowired
    private IPmPoliciesRegulationsService pmPoliciesRegulationsService;

    /**
     * 查询政策法规列表
     */
    @ApiOperation("查询政策法规列表")
    @GetMapping("/list")
    public TableDataInfo<List<PmPoliciesRegulations>> list(PmPoliciesRegulations pmPoliciesRegulations)
    {
        startPage();
        List<PmPoliciesRegulations> list = pmPoliciesRegulationsService.selectPmPoliciesRegulationsList(pmPoliciesRegulations);
        return getDataTable(list);
    }

    /**
     * 获取政策法规详细信息
     */
    @ApiOperation("获取政策法规详细信息")
    @GetMapping(value = "/{listId}")
    public BaseResult<PmPoliciesRegulations> getInfo(@PathVariable("listId") Integer listId)
    {
        return BaseResult.success(pmPoliciesRegulationsService.selectPmPoliciesRegulationsByListId(listId));
    }

    /**
     * 新增政策法规
     */
    @ApiOperation("新增政策法规")
    @Log(title = "政策法规", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult<Integer> add(@RequestBody PmPoliciesRegulations pmPoliciesRegulations)
    {
        return BaseResult.success(pmPoliciesRegulationsService.insertPmPoliciesRegulations(pmPoliciesRegulations));
    }

    /**
     * 修改政策法规
     */
    @ApiOperation("修改政策法规")
    @Log(title = "政策法规", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult<Integer> edit(@RequestBody PmPoliciesRegulations pmPoliciesRegulations)
    {
        return BaseResult.success(pmPoliciesRegulationsService.updatePmPoliciesRegulations(pmPoliciesRegulations));
    }

    /**
     * 删除政策法规
     */
    @ApiOperation("删除政策法规")
    @Log(title = "政策法规", businessType = BusinessType.DELETE)
	@DeleteMapping("/{listIds}")
    public BaseResult<Integer> remove(@PathVariable Integer[] listIds)
    {
        return BaseResult.success(pmPoliciesRegulationsService.deletePmPoliciesRegulationsByListIds(listIds));
    }
}
