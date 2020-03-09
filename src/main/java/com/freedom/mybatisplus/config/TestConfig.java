package com.freedom.mybatisplus.config;


import com.free.testone.domain.Persons;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author ：wujie
 * @date ：Created in 2019/12/21 10:38
 * @description：测试config加载
 * @version: 1.0.0
 */
@Configuration
public class TestConfig {

    @Bean
    public Persons person(){

        System.out.println("加载：2");
           return new Persons();

    }

    @Bean
    public Persons person3(){

        System.out.println("加载：3");
        return new Persons();

    }

}
