package com.freedom.mybatisplus.controller;

import com.freedom.mybatisplus.domain.Person;
import com.freedom.mybatisplus.domain.Son;
import com.freedom.mybatisplus.service.TestAsynService;
import com.freedom.mybatisplus.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/8 13:53
 * @description：
 * @version:
 */
@RestController
public class TestAsynController {

    @Resource
    private TestAsynService testAsynService;

    private static final Son son= JwtUtils.createSon();

    @Autowired
    private Son sonTwoa;

    @GetMapping("/testAsyn")
    public void testAsyn(@RequestParam("file")MultipartFile file){

        try {
            Future<String> stringAsyncResult = testAsynService.testAsyn();
            stringAsyncResult.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1");
        System.out.println(sonTwoa.getClass().getName());

    }

    @GetMapping("/testValid")
    public String testAsyn(){

        /*System.out.println(httpServletRequest.getRequestURI());
        System.out.println(httpServletRequest.getRequestURL());

        System.out.println(son.getPrice());
        System.out.println(sonTwoa.getClass().getName());
        System.out.println(son.getPrice());*/
        System.out.println(son);
        System.out.println(son.hashCode());


        return "ok";

    }

    public static void main(String[] args) {
        String path="/api/user_center/get_authorize_page";

        String substring = path.substring(path.split("/")[1].length() + path.split("/")[2].length() + 2);
        System.out.println(substring);
    }


}
