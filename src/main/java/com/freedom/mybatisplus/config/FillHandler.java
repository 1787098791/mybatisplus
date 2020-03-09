package com.freedom.mybatisplus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author ：wujie
 * @date ：Created in 2020/1/31 17:58
 * @description：填充字段
 * @version:
 */
@Component
public class FillHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createdBy","root",metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updatedBy","root",metaObject);

    }
}
