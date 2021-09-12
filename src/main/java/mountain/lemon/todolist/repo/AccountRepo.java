package mountain.lemon.todolist.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import mountain.lemon.todolist.model.Account;
public interface AccountRepo extends JpaRepository<Account, String> {

}
