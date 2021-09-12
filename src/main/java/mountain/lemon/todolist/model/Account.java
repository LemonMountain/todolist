package mountain.lemon.todolist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import mountain.lemon.todolist.utils.SHA256;

@Entity
@Table(name = "account")
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 32)
	private String email;

	@Column(length = 128)
	private String password;

	@Column(length = 32)
	private String nickname;

	public Account setPassword(String password) {
			this.password = password.length() != 64 ? SHA256.encrypt(password) : password;
		return this;
	}
}
