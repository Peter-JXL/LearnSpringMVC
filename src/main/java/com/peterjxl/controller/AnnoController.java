package com.peterjxl.controller;

import com.peterjxl.domain.User;
import com.peterjxl.domain.User2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 演示常用的注解
 */

@Controller
@RequestMapping(path = "/anno")
@SessionAttributes(value = {"msg"}) // 把msg=王小美存入到session域对象中
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name", required = true)String username) {
        System.out.println("testRequestParam");
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("testRequestBody");
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id) {
        System.out.println("testPathVariable");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头的值
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println("testPathVariable");
        System.out.println(header);
        return "success";
    }

    /**
     * 获取Cookie的值
     * @param cookieValue
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println("testCookieValue");
        System.out.println(cookieValue);
        return "success";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User2 user) {
        System.out.println("testModelAttribute");
        System.out.println(user);
        return "success";
    }

    /**
     * 该方法会先执行
     * @param uname
     * @return
     */
//    @ModelAttribute
//    public User2 showUser(String uname) {
//        System.out.println("showUser");
//        // 通过用户名查询数据库（模拟）
//        User2 user = new User2();
//        user.setUname(uname);
//        user.setAge(20);
//        user.setDate(new Date());
//        return user;
//    }

    @ModelAttribute
    public void showUser(String uname, Map<String, User2> map) {
        System.out.println("showUser");
        // 通过用户名查询数据库（模拟）
        User2 user = new User2();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc", user);
    }

    @RequestMapping("/testSessionAttribute")
    public String getSessionAttribute(Model model) {
        System.out.println("getSessionAttribute");
        model.addAttribute("msg", "王小美");
        return "success3";
    }

    @RequestMapping("/testGetSessionAttribute")
    public String testGetSessionAttribute(ModelMap model) {
        System.out.println("testGetSessionAttribute");
        String msg = (String) model.get("msg");
        System.out.println(msg);
        return "success3";
    }

    @RequestMapping("/testDelSessionAttribute")
    public String testDeleteSessionAttribute(SessionStatus status) {
        System.out.println("testDeleteSessionAttribute");
        status.setComplete();   // 删除session域对象中的msg
        return "success3";
    }
}
