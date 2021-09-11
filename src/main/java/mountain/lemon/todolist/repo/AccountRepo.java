package mountain.lemon.todolist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import mountain.lemon.todolist.entity.Account;
@Repository
public interface AccountRepo extends JpaRepository<Account, String>{
    
}
