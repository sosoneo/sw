package com.sosoneo.interceptor;

import com.sosoneo.Utils.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * Created by sosoneo on 2017/11/28.
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 该方法将在Controller处理之前进行调用，return false则请求中止
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,  HttpServletResponse httpServletResponse, Object o) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) o;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(LoginCheck.class)) {
            // 使用@LoginCheck注解，则进行登录验证
            HttpSession session = httpServletRequest.getSession();
            String user = (String) session.getAttribute("username");
            if (user != null) {
                return true;
            }
            // 不符合条件的跳转到登录界面
            httpServletResponse.sendRedirect("/admin/login");
            // 解决重定向登录界面在iframe页面显示不在top页面显示的问题
//            PrintWriter out = httpServletResponse.getWriter();
//            out.println("<html>");
//            out.println("<script>");
//            out.println("window.open('/admin/login', '_top')");
//            out.println("</script>");
//            out.println("</html>");
            return false;
        }
        return true;
    }
    /**
     * Controller处理之后，ModelAndView返回之前调用这个方法
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 在ModelAndView视图渲染之后调用这个方法，一般此方法用于清理资源
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
