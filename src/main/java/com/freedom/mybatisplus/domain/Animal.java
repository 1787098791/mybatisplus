package com.freedom.mybatisplus.domain;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：wujie
 * @date ：Created in 2020/7/30 17:17
 * @description：
 * @version:
 */
public abstract class Animal {

    @Transactional(rollbackFor = Exception.class)
    public void call(){
        System.out.println(this.getClass().getName());
        test();
    }

    public abstract void test();
}
