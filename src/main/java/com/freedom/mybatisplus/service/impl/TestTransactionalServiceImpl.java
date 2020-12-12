package com.freedom.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.freedom.mybatisplus.domain.Person;
import com.freedom.mybatisplus.domain.Son;
//import com.freedom.mybatisplus.mapper.PersonMapper;
import com.freedom.mybatisplus.mapper.SonMapper;
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
    /*@Resource
    private PersonMapper personMapper;*/

    @Resource
    private SonMapper sonMapper;


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
       // int i = personMapper.insert(person);
        int a=1/0;
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addSon(Son son)  {

       sonMapper.insert(son);

        String name = son.getName();
        Integer age = son.getAge();
        Son son1 = new Son();
        son1.setName(name);
        son1.setAge(age);
        QueryWrapper<Son> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.setEntity(son1);
        Son son2 = sonMapper.selectOne(objectQueryWrapper);
        System.out.println("++++++++"+son2+"++++++++");
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i=1/0;


        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addSonTest(Son son) {
        sonMapper.insert(son);
        return 0;
    }

    @Override
    public Son getSon(Son son) {
        String name = son.getName();
        Integer age = son.getAge();
        Son son1 = new Son();
        son1.setName(name);
        son1.setAge(age);
        QueryWrapper<Son> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.setEntity(son1);

        return sonMapper.selectOne(objectQueryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update() throws InterruptedException {

        Son son1 = new Son();

        son1.setId(7);
        son1.setName("23333");
        son1.setAge(20);
        sonMapper.updateById(son1);

        Thread.sleep(600000);

        Son son2 = new Son();

        son2.setId(9);
        son2.setName("55555");
        son2.setAge(25);
        sonMapper.updateById(son2);


        return 0;
    }
}
