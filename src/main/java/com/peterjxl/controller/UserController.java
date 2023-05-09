package com.peterjxl.controller;

import com.peterjxl.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString() is running...");
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("王小美");
        user.setPassword("123");
        user.setAge(18);
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 请求转发一次请求，不用编写项目名称
     * 重定向是两次请求，得写上项目名字
     * 忘了的同学可以复习下JavaWeb
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid() is running...");
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);

        // 重定向，不能直接写/WEB-INF/pages/success.jsp，因为这样会被视图解析器解析
        //response.sendRedirect(request.getContextPath() + "/index.jsp");


        // 解决中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("你好, SpringMVC!");
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView() is running...");
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("咕噜咕噜滚下山真君");
        user.setPassword("123");
        user.setAge(18);

        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testForward")
    public String testForward() {
        System.out.println("testForward() is running...");
        return "forward:/WEB-INF/pages/success.jsp";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect() {
        System.out.println("testRedirect() is running...");
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求响应
     * @param body
     */
    @RequestMapping("/testAjax")
    @ResponseBody
    public User testAjax(@RequestBody User user) {
        System.out.println("testAjax() is running...");
        System.out.println(user);

        // 做响应，模拟查询数据库
        user.setUsername("王小美");
        user.setAge(19);
        return user;
    }
}
