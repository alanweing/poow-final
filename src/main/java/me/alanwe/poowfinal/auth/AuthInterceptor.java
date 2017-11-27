package me.alanwe.poowfinal.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class Auth extends HandlerInterceptorAdapter {

    public Auth() {}

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response,
                             final Object handle) throws Exception {
        System.out.println("this is a test");
        // true if the execution chain should proceed with the next interceptor or the handler itself.
        // Else, DispatcherServlet assumes that this interceptor has already dealt with the response itself.
        // Called before the handler execution, returns a boolean value, “true” : continue the handler
        // execution chain; “false”, stop the execution chain and return it.
        return true;
    }

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response,
                           final Object handler, final ModelAndView modelAndView) {
        // Called after the handler execution, allow manipulate the ModelAndView object before render it to view page.
    }
}
