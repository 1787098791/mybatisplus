package com.freedom.mybatisplus.service;

import com.freedom.mybatisplus.domain.Person;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/17 19:25
 * @description：
 * @version:
 */
public interface TestTransactionalService {

    int test();

    int insert(Person person);
}
