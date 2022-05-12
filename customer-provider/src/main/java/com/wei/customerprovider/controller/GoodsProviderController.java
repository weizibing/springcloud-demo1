package com.wei.customerprovider.controller;

import com.wei.customerprovider.service.StudentService;
import com.wei.goodscommon.entity.Student;
import com.wei.goodscommon.vo.ResultVo;
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
    @GetMapping()
//    @ApiOperation(value = "根据id查询学生信息", notes = "注意事项")
//    @ApiImplicitParam(example = "0", paramType = "path", name = "id",
//            value = "要查询的学生id", required = true, dataType = "Long")
    // paramType 取值 ： header query(url?id=1) path()
    public ResultVo getStudent(@RequestParam("id") Long id){
        // id=10 服务熔断测试
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
    @DeleteMapping()
    public void deleteStudent(@RequestParam("id") Long id){
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
}
