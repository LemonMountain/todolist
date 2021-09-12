package mountain.lemon.todolist.controller;

import java.security.MessageDigest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mountain.lemon.todolist.model.Account;
import mountain.lemon.todolist.service.AccountService;

@Controller 
public class Main {

    @Autowired
    AccountService accountService;

    @GetMapping String main() { return "Main"; }

    @GetMapping("signup") String signup() { return "signup"; }

    @PostMapping("signup")
    String signup(Account account, Model model) {
        accountService.save(account);
        model.addAttribute("url", "/");
        model.addAttribute("message", "회원가입이 완료되었습니다.");
        return "signup";
    }

    @GetMapping("login") 
    String login(HttpSession session, Model model) { 
        boolean isLogined = session.getAttribute("account") != null;
        model.addAttribute("url", "/");
        model.addAttribute("message", "이미 로그인 되어 있습니다.");
        return isLogined ? "message" : "login";
    }

    @PostMapping("login") 
    String Login(HttpSession session, Account account, Model model) {
        try {
            String userInputPassword = account.getPassword();
            account = accountService.getAccount(account);
            if (!userInputPassword.equalsIgnoreCase(account.getPassword()))
                throw new Exception("비밀번호가 다릅니다.");
            session.setAttribute("account", account);
            model.addAttribute("url", "/");
            model.addAttribute("message", "로그인 되었습니다.");
        }
        catch (Exception e) {
            model.addAttribute("url", "/login");
            model.addAttribute("message", e.getLocalizedMessage());
        }
        return "message";
    }

    @GetMapping("logout")
    String logout(HttpSession session, Model model) {
        session.invalidate();
        model.addAttribute("url", "/");
        model.addAttribute("message", "로그아웃... 성공적");
        return "message";
    }

    @GetMapping("message") String message() { return "message"; }
}
