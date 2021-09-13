package mountain.lemon.todolist.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Table(name = "todolist")
@Accessors(chain = true)
@NoArgsConstructor
public class Todolist implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 150)
    private String whatido;

    @Column(columnDefinition = "Date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "email")
	private Account account;

    @Column(columnDefinition = "int default 0")
    private int checkComplete = 0;
}
