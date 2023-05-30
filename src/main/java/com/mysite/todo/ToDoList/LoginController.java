package com.mysite.todo.ToDoList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.mysite.todo.ToDoList.ToDoController;

import javax.persistence.criteria.CriteriaBuilder;

@Controller

public class LoginController {
    private final UserRepository userRepository;
    public LoginController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @GetMapping("/login")
    public String loginpage(){
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){
        LoginEntity user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/todo"; // 로그인 성공 시 대시보드 페이지로 리다이렉트
        } else {
            return "redirect:/login"; // 로그인 실패 시 다시 로그인 페이지로 리다이렉트
        }
    }

}
