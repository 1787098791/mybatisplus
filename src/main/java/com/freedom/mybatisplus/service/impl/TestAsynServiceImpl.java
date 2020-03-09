package com.freedom.mybatisplus.service.impl;

import com.freedom.mybatisplus.service.TestAsynService;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/8 13:55
 * @description：
 * @version:
 */
@Service
public class TestAsynServiceImpl implements TestAsynService {

    @Resource
    private RedisTemplate redisTemplate;


    @Async
    @Override
    public Future<String> testAsyn(){
       int i=1/0;
        AsyncResult<String> ok = new AsyncResult<>("ok");

        return (Future<String>)ok;
    }



}
