package com.ruoyi.cxy.mapper;

import java.util.List;
import com.ruoyi.cxy.domain.CxySysStudent;

/**
 * 学生信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-06-25
 */
public interface CxySysStudentMapper 
{
    /**
     * 查询学生信息
     * 
     * @param studentId 学生信息ID
     * @return 学生信息
     */
    public CxySysStudent selectCxySysStudentById(Long studentId);

    /**
     * 查询学生信息列表
     * 
     * @param cxySysStudent 学生信息
     * @return 学生信息集合
     */
    public List<CxySysStudent> selectCxySysStudentList(CxySysStudent cxySysStudent);

    /**
     * 新增学生信息
     * 
     * @param cxySysStudent 学生信息
     * @return 结果
     */
    public int insertCxySysStudent(CxySysStudent cxySysStudent);

    /**
     * 修改学生信息
     * 
     * @param cxySysStudent 学生信息
     * @return 结果
     */
    public int updateCxySysStudent(CxySysStudent cxySysStudent);

    /**
     * 删除学生信息
     * 
     * @param studentId 学生信息ID
     * @return 结果
     */
    public int deleteCxySysStudentById(Long studentId);

    /**
     * 批量删除学生信息
     * 
     * @param studentIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCxySysStudentByIds(Long[] studentIds);
}
