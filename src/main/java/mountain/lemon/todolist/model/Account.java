package mountain.lemon.todolist.model;

import java.io.Serializable;
import java.util.Date;

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
@Accessors(chain = true)//컬럼명이 많으면 많을 수록 유리한 '메소드 체이닝' 메인 컨트롤러 ㄱㄱ
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 32)
	private String email;

	@Column(length = 64)
	private String password;

	@Column(length = 32)
	private String nickname;

	private Date signup;

	public Account setPassword(String password) {
			this.password = password.length() != 64 ? SHA256.encrypt(password) : password;
		return this;
	}
}
