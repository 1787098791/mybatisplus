package com.freedom.mybatisplus.service;

import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.Future;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/8 13:55
 * @description：
 * @version:
 */
public interface TestAsynService {
    Future<String> testAsyn() ;
}
