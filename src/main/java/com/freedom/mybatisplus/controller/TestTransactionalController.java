package com.freedom.mybatisplus.controller;

import com.freedom.mybatisplus.service.TestTransactionalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.ws.rs.ApplicationPath;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/17 19:33
 * @description：
 * @version:
 */
@Controller
public class TestTransactionalController {

    /*@Resource
    private TestTransactionalService testTransactionalService;*/

    @RequestMapping("/testMain")
    public String test(){
        //int test = testTransactionalService.test();
        System.out.println(2333333);
        return "/Main.html";
    }
}
