package com.wei.goodsui.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wei.goodscommon.entity.Student;
import com.wei.goodscommon.vo.ResultVo;
import com.wei.goodsui.service.GoodsUIService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author weizibing
 * @date 2022/5/9 9:31
 */
@Service
public class GoodsUIServiceImpl implements GoodsUIService {
    @Resource
    private RestTemplate restTemplate;

    @Override
    public void testGoodProvider() {
        String object = restTemplate.getForObject("http://goods-provider/provider/test", String.class);
        System.out.println(object);
    }

    @Override
    public List<Student> getStudentList() {
        Student[] object = restTemplate.getForObject("http://goods-provider/provider/list", Student[].class);
        return Arrays.asList(object);
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "fallBackStudent", commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    }
    )
    public ResultVo getStudentById(Long id) {
        ResultVo object = restTemplate.getForObject("http://goods-provider/provider/"+id, ResultVo.class);
        return object;
    }
    // 通过 ribbon 实现的服务降级效果
    public ResultVo fallBackStudent(Long id) {
        return ResultVo.error("服务降级返回提示信息");
    }

    @Override
    public ResultVo addStudent(Student student) {
        ResultVo object = restTemplate.postForObject("http://goods-provider/provider/", student, ResultVo.class);
        return object;
    }

    @Override
    public void deleteById(Long id) {
        restTemplate.delete("http://goods-provider/provider/"+id);
    }

    @Override
    public void updateStudent(Student student) {
        restTemplate.put("http://goods-provider/provider/", student);
    }
}
