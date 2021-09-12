package mountain.lemon.todolist.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import mountain.lemon.todolist.model.Account;
public interface AccountRepo extends JpaRepository<Account, String> {

}
