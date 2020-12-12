package com.freedom.mybatisplus.service;

import com.freedom.mybatisplus.domain.Person;

/**
 * @author ：wujie
 * @date ：Created in 2020/5/2 15:41
 * @description：
 * @version:
 */
public interface PersonService {

    int addPerson(Person person);

    void testListener();
}
