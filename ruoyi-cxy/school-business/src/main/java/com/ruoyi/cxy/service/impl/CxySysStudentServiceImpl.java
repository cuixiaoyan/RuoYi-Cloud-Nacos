package com.ruoyi.cxy.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cxy.mapper.CxySysStudentMapper;
import com.ruoyi.cxy.domain.CxySysStudent;
import com.ruoyi.cxy.service.ICxySysStudentService;

/**
 * 学生信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-06-25
 */
@Service
public class CxySysStudentServiceImpl implements ICxySysStudentService 
{
    @Autowired
    private CxySysStudentMapper cxySysStudentMapper;

    /**
     * 查询学生信息
     * 
     * @param studentId 学生信息ID
     * @return 学生信息
     */
    @Override
    public CxySysStudent selectCxySysStudentById(Long studentId)
    {
        return cxySysStudentMapper.selectCxySysStudentById(studentId);
    }

    /**
     * 查询学生信息列表
     * 
     * @param cxySysStudent 学生信息
     * @return 学生信息
     */
    @Override
    public List<CxySysStudent> selectCxySysStudentList(CxySysStudent cxySysStudent)
    {
        return cxySysStudentMapper.selectCxySysStudentList(cxySysStudent);
    }

    /**
     * 新增学生信息
     * 
     * @param cxySysStudent 学生信息
     * @return 结果
     */
    @Override
    public int insertCxySysStudent(CxySysStudent cxySysStudent)
    {
        return cxySysStudentMapper.insertCxySysStudent(cxySysStudent);
    }

    /**
     * 修改学生信息
     * 
     * @param cxySysStudent 学生信息
     * @return 结果
     */
    @Override
    public int updateCxySysStudent(CxySysStudent cxySysStudent)
    {
        return cxySysStudentMapper.updateCxySysStudent(cxySysStudent);
    }

    /**
     * 批量删除学生信息
     * 
     * @param studentIds 需要删除的学生信息ID
     * @return 结果
     */
    @Override
    public int deleteCxySysStudentByIds(Long[] studentIds)
    {
        return cxySysStudentMapper.deleteCxySysStudentByIds(studentIds);
    }

    /**
     * 删除学生信息信息
     * 
     * @param studentId 学生信息ID
     * @return 结果
     */
    @Override
    public int deleteCxySysStudentById(Long studentId)
    {
        return cxySysStudentMapper.deleteCxySysStudentById(studentId);
    }
}
