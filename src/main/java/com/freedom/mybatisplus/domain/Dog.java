package com.freedom.mybatisplus.domain;

import org.springframework.stereotype.Service;

/**
 * @author ：wujie
 * @date ：Created in 2020/7/30 17:18
 * @description：
 * @version:
 */
@Service
public class Dog extends Animal {
    @Override
    public void test() {


        System.out.println("狗狗狗狗");
    }
}
