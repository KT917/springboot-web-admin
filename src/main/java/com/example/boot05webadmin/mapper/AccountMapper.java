package com.example.boot05webadmin.mapper;

import com.example.boot05webadmin.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {


    public Account getAcct(int id);


}
