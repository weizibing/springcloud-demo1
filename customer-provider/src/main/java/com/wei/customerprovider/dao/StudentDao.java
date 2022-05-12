package com.wei.customerprovider.dao;
import com.wei.goodscommon.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author weizibing
 * @date 2022/5/7 9:37
 */
public interface StudentDao {
    List<Student> getStudentList();

    void addStudent(Student student);

    void deleteBatch(@Param("ids") Long[] ids);

    Student getStudentById(Long id);

    void deleteById(Long id);

    void updateStudent(Student student);
}
