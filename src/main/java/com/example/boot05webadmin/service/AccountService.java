package com.example.boot05webadmin.service;

import com.example.boot05webadmin.bean.Account;
import com.example.boot05webadmin.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAcctByid(int id){
        return  accountMapper.getAcct(id);
    }

}
