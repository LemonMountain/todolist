package mountain.lemon.todolist.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Responser {

  private final static String MESSAGE_VIEW_NAME = "message";

  /**
   * 별도 메세지 페이지에서 결과를 출력해준 후 url로 이동시켜줍니다.
   * @param message
   * @param url
   * @return message가 출력되는 view(html) name
   */
  public static String alert(String url, String message) {
    // 현재 진행중인 컨트롤러의 해당 Request를 찾아 모델 세팅
    HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
    request.setAttribute("url", url != null ? url : "/");
    request.setAttribute("message", message);
    return MESSAGE_VIEW_NAME;
  }
}
