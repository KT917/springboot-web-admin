package com.example.boot05webadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

@MapperScan("com.example.boot05webadmin.mapper")  //简化，其他的接口就可以不用标注@Mapper注解
@SpringBootApplication
public class Boot05WebAdminApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Boot05WebAdminApplication.class, args);

        ConfigurableEnvironment environment = run.getEnvironment();

        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();

        Map<String, Object> systemProperties = environment.getSystemProperties();

        System.out.println(systemEnvironment);
        System.out.println(systemProperties);


    }

}
