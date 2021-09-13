package mountain.lemon.todolist.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class UserInterceptor implements HandlerInterceptor {
  
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    boolean isLogin = request.getSession().getAttribute("account") != null;
    if (!isLogin) {
      response.sendRedirect("/login");
      return false;
    }
    return HandlerInterceptor.super.preHandle(request, response, handler);
  }
}
