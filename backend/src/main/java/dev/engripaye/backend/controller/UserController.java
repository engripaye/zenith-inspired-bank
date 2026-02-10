package dev.engripaye.backend.controller;

import dev.engripaye.backend.model.User;
import dev.engripaye.backend.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String openAccountPage(){
        return "login";
    }

    @PostMapping("/open-account")
    public String openAccount(@RequestParam String fullname,
                              @RequestParam String email,
                              HttpSession session){
        User user = userService.register(fullname, email);
        session.setAttribute("user", user);

        return "redirect:/account/create";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}
