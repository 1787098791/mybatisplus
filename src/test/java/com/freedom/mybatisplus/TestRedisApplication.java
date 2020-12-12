package com.freedom.mybatisplus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freedom.mybatisplus.domain.Cat;
import com.freedom.mybatisplus.domain.Dog;
import com.freedom.mybatisplus.domain.Person;
import com.freedom.mybatisplus.domain.Son;
//import com.freedom.mybatisplus.mapper.PersonMapper;
import com.freedom.mybatisplus.service.PersonService;
import com.freedom.mybatisplus.utils.JwtUtils;
import com.freedom.mybatisplus.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/13 14:22
 * @description：
 * @version:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisApplication {

   @Resource
   private RedisUtil redisUtil;

   @Resource
   private RedisTemplate redisTemplate;

  /* @Resource
   private PersonMapper personMapper;*/

   @Resource
   private JwtUtils jwtUtils;

   @Resource
   private Dog dog;

   @Resource
   private Cat cat;

   @Resource
   private PersonService personService;



    @Test
    public void test() throws InterruptedException {
        /*boolean set = redisUtil.set("gs", "freedom", 5);
        Object gs = redisUtil.get("gs");
        System.out.println(gs.toString());
        Thread.sleep(6000);
        Object gs1 = redisUtil.get("gs");
        System.out.println(gs1);*/



     /*   redisUtil.expire("key",5);
        Double score = redisTemplate.opsForZSet().score("key", "free");
        System.out.println(score);
        Thread.sleep(5000);
        System.out.println(redisTemplate.opsForZSet().score("key","free"));*/

        Person person = new Person();
        person.setName("aaa");
        redisTemplate.opsForValue().set("222",person,10, TimeUnit.SECONDS);
       Person person2=(Person) redisTemplate.opsForValue().get("222");
        System.out.println(person2);


    }

    @Test
    public void testJWT() throws InterruptedException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id","001");
        map.put("name","小明");
        String token = JwtUtils.createJavaWebToken(map);
        System.out.println(token);
        //eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoi5bCP5piOIiwiaWQiOiIwMDEiLCJleHAiOjE1NzcxODAzODd9.-xijxdrqhnzC7udu0VTBuPWmvHTdAQUmYeblzkF2-M4
        Map<String, Object> stringObjectMap = JwtUtils.parserJavaWebToken(token);
        System.out.println(stringObjectMap);
    }

    @Test
    public void testMybatis(){
        /*Person person = new Person();
        person.setName("saber");
        person.setAge(20);
        int insert = personMapper.insert(person);*/
        Person person1 = new Person();
        person1.setName("saberlily");
        person1.setId("14cd00fbad27f07444f4ce8105bf38be");
        //int i = personMapper.updateById(person1);
    }

    @Test
    public void testJackson() throws IOException {
        String string = new ObjectMapper().writeValueAsString(new Son());
        System.out.println(string);
        Object o = new ObjectMapper().readValue(string, Object.class);
        System.out.println(o);

    }

    @Test
    public void test7(){
        dog.call();
    }

    @Test
    public void test8(){
        personService.testListener();
    }
}
