package com.freedom.mybatisplus.service.impl;

import com.freedom.mybatisplus.domain.Person;
//import com.freedom.mybatisplus.mapper.PersonMapper;
import com.freedom.mybatisplus.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author ：wujie
 * @date ：Created in 2020/5/2 15:41
 * @description：
 * @version:
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private ApplicationEventPublisher publisher;

    /*@Resource
    private PersonMapper personMapper;*/

    /*@Transactional(rollbackFor = Exception.class)
    @Override
    public int addPerson(Person person) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                personMapper.insert(person);
            }
        }).start();
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }*/

    @Override
    public int addPerson(Person person) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testListener() {

        for (int i=0;i<5;i++){

            publisher.publishEvent(i);

        }

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
