package com.wei.goodsui.controller;

import com.wei.goodscommon.entity.Student;
import com.wei.goodscommon.vo.ResultVo;
import com.wei.goodsui.service.GoodsUIService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author weizibing
 * @date 2022/5/9 9:32
 */
@RestController
@RequestMapping("ui")
public class GoodsUIController {
    @Resource
    private GoodsUIService goodsUIService;

    @RequestMapping("/test")
    public String test(){
        goodsUIService.testGoodProvider();
        return "111";
    }

    @GetMapping("/list")
    public List<Student> getStudentList(){
        List<Student> studentList = goodsUIService.getStudentList();
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
        ResultVo resultVo = goodsUIService.getStudentById(id);
        return resultVo;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResultVo deleteStudent(@PathVariable("id") Long id){
        goodsUIService.deleteById(id);
        return ResultVo.success(null);
    }

    /**
     * 添加
     * @param student
     * @return
     */
    @PostMapping()
    public ResultVo addStudent(@RequestBody Student student){
        ResultVo resultVo = goodsUIService.addStudent(student);
        return resultVo;
    }

    /**
     * 修改
     * @param student
     * @return
     */
    @PutMapping()
    public ResultVo updateStudent(@RequestBody Student student){
        goodsUIService.updateStudent(student);
        return ResultVo.success(null);
    }
}
