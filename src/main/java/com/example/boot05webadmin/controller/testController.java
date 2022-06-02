package com.example.boot05webadmin.controller;


import com.example.boot05webadmin.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @Value(value = "${person.name:李四}")
    private String name;

    @Autowired
    Person person;

    @RequestMapping("/test")
    public String test(){
            return person.getClass().toString();
    }

}
