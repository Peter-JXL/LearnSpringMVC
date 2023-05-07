package com.peterjxl.controller;


import com.peterjxl.domain.Account;
import com.peterjxl.domain.User2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 演示请求参数绑定
 */
@Controller
@RequestMapping(path = "/param")
public class ParamController {

    /**
     * 演示请求参数绑定
     * @return
     */
    @RequestMapping(path = "/testParam")
    public String testParam(String username, String password) {
        System.out.println("testParam");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return "success";
    }

    @RequestMapping(path = "/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("saveAccount");
        System.out.println(account);
        return "success";
    }

    @RequestMapping(path = "/saveAccount2")
    public String saveAccount2(Account account) {
        System.out.println("saveAccount2");
        System.out.println(account);
        return "success";
    }

    @RequestMapping(path = "/saveAccount3")
    public String saveAccount3(Account account) {
        System.out.println("saveAccount3");
        System.out.println(account);
        return "success";
    }


    /**
     * 自定义类型转换器
     * @param user2
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User2 user2) {
        System.out.println("saveUser");
        System.out.println(user2);
        return "success";
    }
}
