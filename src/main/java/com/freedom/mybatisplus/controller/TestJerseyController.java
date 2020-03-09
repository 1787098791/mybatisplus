package com.freedom.mybatisplus.controller;

import com.freedom.mybatisplus.service.TestAsynService;

import org.apache.ibatis.annotations.Param;
import org.springframework.aop.framework.DefaultAopProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/8 18:15
 * @description：
 * @version:
 */
@Service
@Path("/")
@Consumes({"application/json; charset=UTF-8"})
@Produces({"application/json; charset=UTF-8"})
public class TestJerseyController {

    @Autowired
    private TestAsynService testAsynService;

    @GET
    @Path("/testJersey")

    public Object testJersey(){

        //System.out.println(testAsynService.getClass());

        return "ok";
    }
}
