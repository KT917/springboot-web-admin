package com.example.boot05webadmin.mapper;

import com.example.boot05webadmin.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("SELECT*FROM city where id=#{id} ")
    public City getById(long id);

    @Insert("insert into city(`name`,`state`,`country` )values (#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void insert(City city);
}
