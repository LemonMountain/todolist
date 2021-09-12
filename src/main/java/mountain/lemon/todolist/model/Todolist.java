package mountain.lemon.todolist.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Table(name = "todolist")
@Accessors(chain = true)
public class Todolist {
    
    private static final long serialVersionUID = 1L;

    
}
