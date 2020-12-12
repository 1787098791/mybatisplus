package com.freedom.mybatisplus.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/5 11:17
 * @description：测试excel导入学生类
 * @version: 1.0.0
 */
public class Student implements Serializable {

    @Size(min=2,max=10,message = "长度错误")
    private String name;
    @Max(value = 200,message = "大小错误")
    @Min(value = 10,message = "大小错误")
    private Integer age;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
