package com.ruoyi.cxy.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.cxy.domain.CxySysStudent;
import com.ruoyi.cxy.service.ICxySysStudentService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 学生信息Controller
 * 
 * @author ruoyi
 * @date 2020-06-25
 */
@RestController
@RequestMapping("/student")
public class CxySysStudentController extends BaseController
{
    @Autowired
    private ICxySysStudentService cxySysStudentService;

    /**
     * 查询学生信息列表
     */
    @PreAuthorize("@ss.hasPermi('student:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(CxySysStudent cxySysStudent)
    {
        startPage();
        List<CxySysStudent> list = cxySysStudentService.selectCxySysStudentList(cxySysStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生信息列表
     */
    @PreAuthorize("@ss.hasPermi('student:student:export')")
    @Log(title = "学生信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public void export(HttpServletResponse response, CxySysStudent cxySysStudent) throws IOException
    {
        List<CxySysStudent> list = cxySysStudentService.selectCxySysStudentList(cxySysStudent);
        ExcelUtil<CxySysStudent> util = new ExcelUtil<CxySysStudent>(CxySysStudent.class);
         util.exportExcel(response, list, "student");
    }

    /**
     * 获取学生信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('student:student:query')")
    @GetMapping(value = "/{studentId}")
    public AjaxResult getInfo(@PathVariable("studentId") Long studentId)
    {
        return AjaxResult.success(cxySysStudentService.selectCxySysStudentById(studentId));
    }

    /**
     * 新增学生信息
     */
    @PreAuthorize("@ss.hasPermi('student:student:add')")
    @Log(title = "学生信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CxySysStudent cxySysStudent)
    {
        return toAjax(cxySysStudentService.insertCxySysStudent(cxySysStudent));
    }

    /**
     * 修改学生信息
     */
    @PreAuthorize("@ss.hasPermi('student:student:edit')")
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CxySysStudent cxySysStudent)
    {
        return toAjax(cxySysStudentService.updateCxySysStudent(cxySysStudent));
    }

    /**
     * 删除学生信息
     */
    @PreAuthorize("@ss.hasPermi('student:student:remove')")
    @Log(title = "学生信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentIds}")
    public AjaxResult remove(@PathVariable Long[] studentIds)
    {
        return toAjax(cxySysStudentService.deleteCxySysStudentByIds(studentIds));
    }
}
