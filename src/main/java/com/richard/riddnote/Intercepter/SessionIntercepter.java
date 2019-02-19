package com.richard.riddnote.Intercepter;


import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionIntercepter implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if("/login".equals(request.getRequestURI()))
        {
            //
            // 只放行"/login"
            //
            return true;
        }
        if("/register".equals(request.getRequestURI()))
        {
            //
            // 放行"/register"
            //
            return true;
        }

        if(request.getSession().getAttribute("uid")==null)
        {
            //
            // 未登录用户
            //
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

}
