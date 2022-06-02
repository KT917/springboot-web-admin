package com.example.boot05webadmin;

import com.example.boot05webadmin.bean.User;
import com.example.boot05webadmin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        Integer integer = jdbcTemplate.queryForObject("select count(*) from account", int.class);
        System.out.println("记录总数："+integer);
        log.info("数据源类型:{}"+dataSource.getClass());
    }

    @Autowired
    UserMapper userMapper;
    @Test
    void testUserMapper(){
        User user = userMapper.selectById(1);
        log.info("用户信息："+user);
    }

}
