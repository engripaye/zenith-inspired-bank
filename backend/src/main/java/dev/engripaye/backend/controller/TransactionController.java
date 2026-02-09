package dev.engripaye.backend.controller;


import dev.engripaye.backend.model.Account;
import dev.engripaye.backend.service.TransactionService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/deposit")
    public String deposit(@RequestParam BigDecimal amount, HttpSession httpSession){

        Account account = (Account) httpSession.getAttribute("account");
        transactionService.deposit(account, amount);

        return "redirect:/account/dashboard";

    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam BigDecimal amount, HttpSession httpSession){
        Account account = (Account) httpSession.getAttribute("account");
        transactionService.withdraw(account, amount);

        return "redirect:/account/dashboard";
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam BigDecimal amount,
                           @RequestParam Account receiver,
                           HttpSession session){
        Account sender = (Account) session.getAttribute("account");
        transactionService.transfer(sender, receiver, amount);

        return "redirect:/account/dashboard";
    }


}
