package com.freedom.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.freedom.mybatisplus.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PersonMapper extends BaseMapper<Person> {

    int insertPerson(Person person);

    int insertList(List<Person> list);

    List<Person> selectByName(String name);
}
