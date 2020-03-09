package com.freedom.mybatisplus.config;

import com.freedom.mybatisplus.controller.TestJerseyController;
import com.freedom.mybatisplus.controller.TestTransactionalController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/8 18:35
 * @description：
 * @version:
 */
@Component
public class JerseyConfig extends ResourceConfig {

    JerseyConfig(){
        //打成jar包启动时会出现FileNotFound
        //packages("com.freedom");
        register(TestJerseyController.class);
        register(TestTransactionalController.class);
    }
}
