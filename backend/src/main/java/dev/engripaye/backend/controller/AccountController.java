package dev.engripaye.backend.controller;

import dev.engripaye.backend.model.Account;
import dev.engripaye.backend.model.User;
import dev.engripaye.backend.service.AccountService;
import dev.engripaye.backend.service.TransactionService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final TransactionService transactionService;

    @GetMapping("/create")
    public String createAccount(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null) return "redirect:/open-account";

        Account account = accountService.createAccount(user);
        session.setAttribute("account", account);

        return "redirect:/account/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model){

        Account account = (Account) session.getAttribute("account");
        if (account == null) return "redirect:/open-account";


    }

}
