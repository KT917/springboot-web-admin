package com.example.boot05webadmin.controller;

import com.example.boot05webadmin.bean.Account;
import com.example.boot05webadmin.bean.City;
import com.example.boot05webadmin.bean.User;
import com.example.boot05webadmin.service.AccountService;
import com.example.boot05webadmin.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    /**
     * 登入页
     *
     * @return
     */
    @GetMapping(value = {"/", "login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (!StringUtils.isEmpty(user.getUsername()) && StringUtils.hasLength(user.getPassword())) {
            session.setAttribute("loginUser", user);
            return "redirect:/main.html";  //登入成功重定向  防止表单重复提交
        } else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }
    }

    /**
     * 去main页面
     *
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null) {
//        int a=1/0;
        return "main";
//        } else {
//            model.addAttribute("msg","请重新登入");
//            return "login";
//        }
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("sql")
    public String queryFromDb() {
        Integer integer = jdbcTemplate.queryForObject("select count(*) from account", int.class);
        return integer.toString();
    }

    @Autowired
    AccountService accountService;

    @ResponseBody
    @GetMapping("/acct")
    public Account getById(@RequestParam("id") int id) {
        return accountService.getAcctByid(id);
    }

    @Autowired
    CityService cityService;

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") int id) {
        cityService.saveCity(new City(null,"bb","bb","bb"));
        return cityService.getCityById(id);
    }

}
