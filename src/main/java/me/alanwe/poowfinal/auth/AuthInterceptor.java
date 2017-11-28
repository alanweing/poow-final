package me.alanwe.poowfinal.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Configuration
public class AuthInterceptor extends HandlerInterceptorAdapter {

    public static final String USER_TAG = "user";

    private static String[] AUTHORIZED_URIS = new String[] {
            "login",
            "user/create"
    };

    public AuthInterceptor() {}

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response,
                             final Object handle) throws Exception {
        final String requestedUri = request.getRequestURI().replaceFirst("/", "");
        if (requestedUri.contains("resources") || Arrays.stream(AUTHORIZED_URIS).anyMatch(requestedUri::equals))
            return true;
        final HttpSession session = request.getSession(false);
        // if session is null, the user is not logged
        if (session == null || session.getAttribute(USER_TAG) == null) {
            response.sendRedirect("/login");
            return false;
        } else if (request.getRequestURI().equals("/login"))
            return true;
//        final String token = (String) session.getAttribute(AUTH_TOKEN_TAG);
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
