package com.wei.goodscommon.entity;

/**
 * @author weizibing
 * @date 2022/5/7 9:22
 */
//@ApiModel(value = "学生对象", description = "学生对象属性")
public class Student {
//    @ApiModelProperty(value = "学生id", dataType = "Long", example = "0")
    private Long studentId;
//    @ApiModelProperty(value = "学生姓名", dataType = "String", required = true, example = "wei")
    private String studentName;
    private String studentEmail;
    private Integer age;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", age=" + age +
                '}';
    }
}
