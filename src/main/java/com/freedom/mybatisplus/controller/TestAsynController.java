package com.freedom.mybatisplus.controller;

import com.freedom.mybatisplus.service.TestAsynService;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
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

    }
}
