package com.freedom.mybatisplus.domain;

import org.springframework.stereotype.Service;

/**
 * @author ：wujie
 * @date ：Created in 2020/7/30 17:19
 * @description：
 * @version:
 */
@Service
public class Cat extends Animal {
    @Override
    public void test() {
        System.out.println("猫猫猫猫猫");
    }
}
