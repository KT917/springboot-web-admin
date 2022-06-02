package com.example.boot05webadmin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.boot05webadmin.bean.User;
import com.example.boot05webadmin.exception.UserToManyException;
import com.example.boot05webadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class tableController {
    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1")int pn, Model model) {
//        List<User> users = Arrays.asList(new User("tom", "123"),
//                new User("tom01", "123"),
//                new User("tom03", "123"));
//        model.addAttribute("users",users);
//        if (users.size()>2){
//            throw  new UserToManyException();
//        }
//        List<User> list = userService.list();
//        model.addAttribute("users",list);

        //分页查询数据
        Page<User> userPage = new Page<>(pn, 2);

        //分页查询结果
        Page<User> page = userService.page(userPage, null);

        model.addAttribute("page",page);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id")Long id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes redirectAttributes){
        userService.removeById(id);
        redirectAttributes.addAttribute("pn",pn);
            return "redirect:/dynamic_table";
    }
}
