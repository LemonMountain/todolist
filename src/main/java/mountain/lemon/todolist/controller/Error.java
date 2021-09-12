package mountain.lemon.todolist.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mountain.lemon.todolist.utils.Responser;

@Controller
public class Error implements ErrorController {
  
  @RequestMapping("error")
  String error(Model model) { return Responser.alert("/", "삐빅... 에러(이)가 발생"); }
}
