package com.peterjxl.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器类
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 预处理，controller方法执行前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor执行了...");
        return true;

//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
//        return false; // 拦截器拦截请求，不再执行controller方法
    }

    /**
     * 后处理方法，controller方法执行后，success.jsp执行前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor执行了...postHandle");
        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
    }

    /**
     * success.jsp执行后，该方法会执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor执行了...afterCompletion");
    }
}
