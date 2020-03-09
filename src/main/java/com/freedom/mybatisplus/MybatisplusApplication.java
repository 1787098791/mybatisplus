package com.freedom.mybatisplus;

import com.free.testone.domain.Persons;
import com.freedom.mybatisplus.controller.TestTransactionalController;
import com.freedom.mybatisplus.domain.Person;
import com.freedom.mybatisplus.service.TestAsynService;
import com.freedom.mybatisplus.service.TestTransactionalService;
import com.freedom.mybatisplus.service.impl.TestAsynServiceImpl;
import com.freedom.mybatisplus.service.impl.TestTransactionalServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

@MapperScan("com.freedom.mybatisplus.mapper")
@SpringBootApplication(scanBasePackages = {"com.*"})
@EnableAsync(proxyTargetClass = true)

//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MybatisplusApplication {

    @Resource
    private TestAsynServiceImpl testAsynServiceImpl;

    @Resource
    private TestTransactionalService testTransactionalServiceImpl;

    @Resource
    private Persons person;





    public static void main(String[] args) {
        SpringApplication.run(MybatisplusApplication.class, args);
    }


/*    @Bean
    public Person person4(){
        System.out.println("****"+testAsynServiceImpl.getClass());
        System.out.println("****"+testTransactionalServiceImpl.getClass());

        return new Person();
    }*/


}
