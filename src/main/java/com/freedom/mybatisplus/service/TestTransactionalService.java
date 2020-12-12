package com.freedom.mybatisplus.service;

import com.freedom.mybatisplus.domain.Person;
import com.freedom.mybatisplus.domain.Son;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/17 19:25
 * @description：
 * @version:
 */
public interface TestTransactionalService {

    int test();

    int insert(Person person);

    int addSon(Son son) ;

    int addSonTest(Son son) ;

    Son getSon(Son son);

    int update() throws InterruptedException;
}
