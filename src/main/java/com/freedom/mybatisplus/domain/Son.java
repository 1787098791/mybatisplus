package com.freedom.mybatisplus.domain;

import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ：wujie
 * @date ：Created in 2020/6/4 22:13
 * @description：
 * @version:
 */

@TableName("son")
public class Son implements Serializable {
    public Son() {
        System.out.println("son......");
    }

    private Integer id;
    private Integer age;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Son{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    /*    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(1);

            Future<?> submit = executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(50000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        submit.get();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("2333");
            }
        });
    }*/
}
