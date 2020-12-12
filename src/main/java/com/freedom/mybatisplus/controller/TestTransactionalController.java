package com.freedom.mybatisplus.controller;

import com.freedom.mybatisplus.domain.Person;
import com.freedom.mybatisplus.domain.Son;
import com.freedom.mybatisplus.service.PersonService;
import com.freedom.mybatisplus.service.TestTransactionalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ApplicationPath;
import java.util.Date;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/17 19:33
 * @description：
 * @version:
 */
@RestController
public class TestTransactionalController {

    @Resource
    private TestTransactionalService testTransactionalService;

    @Resource
    private PersonService personService;

    @RequestMapping("/testMain")
    public String test(){
        //int test = testTransactionalService.test();
        System.out.println(2333333);
        return "/Main.html";
    }

    @GetMapping("/testPerson")
    public Person testPerson(){
        Person person = new Person();
        person.setName("freedom");
        person.setTime(new Date());
        return person;
    }

    @PostMapping("insert_son")
    public String addSon(@RequestBody Son son){
        testTransactionalService.addSon(son);
        return "ok";
    }

    @PostMapping("insert_son_test")
    public String addSonTest(@RequestBody Son son){
        testTransactionalService.addSonTest(son);
        return "ok";
    }

    @PostMapping("son")
    public Son getSon(@RequestBody Son son){
       return testTransactionalService.getSon(son);

    }

    @GetMapping("/test")
    public void testTransaction(){
        System.out.println(testTransactionalService);

    }

    @GetMapping("/update_son")
    public void updateSon() throws InterruptedException {
        testTransactionalService.update();
    }




}
