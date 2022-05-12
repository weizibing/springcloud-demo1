package com.wei.customerui.service;


import com.wei.customerui.service.impl.CustomerUIServiceImpl;
import com.wei.goodscommon.entity.Student;
import com.wei.goodscommon.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author weizibing
 * @date 2022/5/9 9:31
 */
@FeignClient(value = "customer-provider", fallback = CustomerUIServiceImpl.class)
public interface CustomerUIService {
    @RequestMapping("provider/test")
    void testGoodProvider();

    @GetMapping("provider/list")
    List<Student> getStudentList();

    @GetMapping("provider")
    ResultVo getStudentById(@RequestParam("id") Long id);

    @DeleteMapping("provider")
    void deleteById(@RequestParam("id") Long id);

    @PostMapping("provider")
    ResultVo addStudent(@RequestBody Student student);

    @PutMapping("provider")
    void updateStudent(@RequestBody Student student);
}
