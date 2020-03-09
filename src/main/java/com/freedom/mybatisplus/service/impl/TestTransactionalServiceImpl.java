package com.freedom.mybatisplus.service.impl;

import com.freedom.mybatisplus.domain.Person;
import com.freedom.mybatisplus.mapper.PersonMapper;
import com.freedom.mybatisplus.service.TestTransactionalService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/17 19:26
 * @description：
 * @version:
 */
@Service
public class TestTransactionalServiceImpl implements TestTransactionalService {
    @Resource
    private PersonMapper personMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public int test() {
        Person person = new Person();
        person.setAge(20);
        person.setName("freedom");
        insert(person);
        return 0;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(Person person) {
        int i = personMapper.insert(person);
        int a=1/0;
        return i;
    }
}
