package com.wei.goodsui.service;

import com.wei.goodscommon.entity.Student;
import com.wei.goodscommon.vo.ResultVo;

import java.util.List;

/**
 * @author weizibing
 * @date 2022/5/9 9:31
 */
public interface GoodsUIService {
    void testGoodProvider();

    List<Student> getStudentList();

    ResultVo getStudentById(Long id);

    void deleteById(Long id);

    ResultVo addStudent(Student student);

    void updateStudent(Student student);
}
