package com.mysite.todo.ToDoList;
import javax.persistence.*;
import lombok.Setter;
import lombok.Getter;




@Entity
@Getter
@Setter

public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginEntity(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    private String password;
}
