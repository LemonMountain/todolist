package mountain.lemon.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import mountain.lemon.todolist.entity.Account;
import mountain.lemon.todolist.service.AccountService;

@Controller 
public class HomeController {

    @Autowired
    AccountService service;

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("info")
    public String info(Account account, Model model) {
        model.addAttribute("account", account);
        service.save(account);
        return "info";
    }

    @GetMapping("mypage")
    String mypage(String email, Model model) throws Exception {
        model.addAttribute("account", service.getAccount(email));
        return "mypage";
    }
}
