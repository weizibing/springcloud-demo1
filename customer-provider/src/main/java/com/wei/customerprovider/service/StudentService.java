package com.wei.customerprovider.service;

import com.wei.goodscommon.entity.Student;

import java.util.List;

/**
 * @author weizibing
 * @date 2022/5/7 9:26
 */
public interface StudentService {
    List<Student> getStudentList();

    void addStudent(Student student);

    void deleteBatch(Long[] ids);

    Student getStudentById(Long id);

    void deleteById(Long id);

    void updateStudent(Student student);
}
