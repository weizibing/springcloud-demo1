package com.wei.customerprovider.service.impl;

import com.wei.customerprovider.dao.StudentDao;
import com.wei.customerprovider.service.StudentService;
import com.wei.goodscommon.entity.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author weizibing
 * @date 2022/5/7 9:27
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;
    @Override
    public List<Student> getStudentList() {
        return studentDao.getStudentList();
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        studentDao.deleteBatch(ids);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public void deleteById(Long id) {
        studentDao.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }
}
