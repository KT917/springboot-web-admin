package com.example.boot05webadmin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("tomtom")  //若表名修改 使用@TableName使其对应
public class User {

    @TableField(exist = false)
    private  String username;
    @TableField(exist = false)
    private  String password;

    //数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;

}
