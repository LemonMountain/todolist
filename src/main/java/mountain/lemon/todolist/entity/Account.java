package mountain.lemon.todolist.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "account")
@Data
public class Account implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
	@Column(length = 32)
	private String email;
	
	@Column(length = 128)
	private String password;

	@Column(length = 32)
	private String nickname;
}
