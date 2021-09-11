package mountain.lemon.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mountain.lemon.todolist.entity.Account;
import mountain.lemon.todolist.repo.AccountRepo;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    public Account getAccount(String email) throws Exception {
        return accountRepo.findById(email).orElseThrow(() ->
            new Exception("존재하지 않는 계정이다."));
    }
}
