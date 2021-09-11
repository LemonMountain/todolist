package mountain.lemon.todolist.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

  private final UserInterceptor userInterceptor;
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry
      .addInterceptor(userInterceptor)
      .addPathPatterns("/user/**");
    WebMvcConfigurer.super.addInterceptors(registry);
  }
}
