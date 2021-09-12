package mountain.lemon.todolist.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import mountain.lemon.todolist.model.Account;
import mountain.lemon.todolist.service.AccountService;
import mountain.lemon.todolist.utils.Responser;

@Controller 
public class Main {

    @Autowired
    AccountService accountService;

    @GetMapping String main() { return "Main"; }

    @GetMapping("signup") String signup() { return "signup"; }

    @PostMapping("signup")
    String signup(Account account, Model model) {
        accountService.save(account);
        return Responser.alert("/", "회원가입이 완료되었습니다.");
    }

    @GetMapping("login") 
    String login(HttpSession session, Model model) { 
        boolean isLogined = session.getAttribute("account") != null;
        return isLogined ? Responser.alert("/", "넌 이미 로그인 되어있다... 아직 깨닫지 못했을 뿐") : "login";
    }

    @PostMapping("login") 
    String Login(HttpSession session, Account account, Model model) {
        try {
            String userInputPassword = account.getPassword();
            account = accountService.getAccount(account);
            if (!userInputPassword.equalsIgnoreCase(account.getPassword()))
                throw new Exception("비밀번호가 다릅니다.");
            session.setAttribute("account", account);
            return Responser.alert("/", "로그인 되었습니다.");
        }
        catch (Exception e) {
            return Responser.alert("login", e.getLocalizedMessage());
        }
    }

    @GetMapping("logout")
    String logout(HttpSession session, Model model) {
        session.invalidate();
        return Responser.alert("/", "로그아웃... 성공적");
    }

    @GetMapping("message") String message() { return "message"; }
}
