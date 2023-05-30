package com.mysite.todo.ToDoList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <LoginEntity,Long> {
    LoginEntity findByUsername(String username);

}
