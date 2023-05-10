package com.peterjxl.controller;


import com.peterjxl.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/textException")
    public String textException() throws Exception {
        System.out.println("UserController.textException()");

        // 模拟异常
        try {
            int i = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("出现错误");
        }
        return "success";
    }

}
