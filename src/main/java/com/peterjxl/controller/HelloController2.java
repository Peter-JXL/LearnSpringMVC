package com.peterjxl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/user")
public class HelloController2 {

    @RequestMapping(
            value = "/hello",
            method = {RequestMethod.GET, RequestMethod.POST},
            params = {"username"},
            headers = {"Accept"}
    )
    public String sayHello() {
        System.out.println("Hello, RequestMapping!");
        return "success2";
    }
}
