package com.wei.customerui.service.impl;

import com.wei.customerui.service.CustomerUIService;
import com.wei.goodscommon.entity.Student;
import com.wei.goodscommon.vo.ResultVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author weizibing
 * @date 2022/5/9 17:49
 */
@Component
public class CustomerUIServiceImpl implements CustomerUIService {
    @Override
    public void testGoodProvider() {

    }

    @Override
    public List<Student> getStudentList() {
        return null;
    }

    // 服务熔断
    @Override
    public ResultVo getStudentById(Long id) {
        return ResultVo.error("feign服务降级响应");
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public ResultVo addStudent(Student student) {
        return null;
    }

    @Override
    public void updateStudent(Student student) {

    }
}
