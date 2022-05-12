package com.wei.goodsprovider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wei.goodscommon.entity.Student;
import com.wei.goodscommon.vo.ResultVo;
import com.wei.goodsprovider.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author weizibing
 * @date 2022/5/9 9:37
 */
@RestController
@RequestMapping("/provider")
public class GoodsProviderController {
    @RequestMapping("/test")
    public String test(){
        System.out.println("进入了provider");
        return "给ui返回的数据";
    }

    @Resource
    private StudentService studentService;
    @GetMapping("/list")
    public List<Student> getStudentList(){
        List<Student> studentList = studentService.getStudentList();
        return studentList;
//        return ResultVo.success(studentList);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
//    @ApiOperation(value = "根据id查询学生信息", notes = "注意事项")
//    @ApiImplicitParam(example = "0", paramType = "path", name = "id",
//            value = "要查询的学生id", required = true, dataType = "Long")
    // paramType 取值 ： header query(url?id=1) path()
    public ResultVo getStudent(@PathVariable("id") Long id){
        // id=10 则测试熔断器
        if(id==10L){
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Student student = studentService.getStudentById(id);
        return ResultVo.success(student);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.deleteById(id);
    }

    /**
     * 添加
     * @param student
     * @return
     */
    @PostMapping()
    public ResultVo addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return ResultVo.success(null);
    }

    /**
     * 修改
     * @param student
     * @return
     */
    @PutMapping()
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }


    @HystrixCommand(fallbackMethod = "fallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 开启熔断器
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 次数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"), // 错误率
    })
    @RequestMapping("/test_hystrix")
    public String testHystrix(@RequestParam("num") int num){
        int n = (int)Math.floor(Math.random()*100);
        int result = n/num;
        return "服务正常返回：" + n + "/" + num + "=" + result;
    }
    public String fallBack(@RequestParam("num") int num){
        return "服务降级响应 num为0";
    }
}
