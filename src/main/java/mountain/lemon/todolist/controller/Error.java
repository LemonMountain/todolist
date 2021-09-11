package mountain.lemon.todolist.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Error implements ErrorController {
  
  @RequestMapping("error")
  String error(Model model) {
    model.addAttribute("url", "/");
    model.addAttribute("message", "삐빅... 에러(이)가 발생");
    return "message";
  }
}
