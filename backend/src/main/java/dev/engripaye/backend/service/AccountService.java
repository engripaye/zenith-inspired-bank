package dev.engripaye.backend.service;

import dev.engripaye.backend.model.Account;
import dev.engripaye.backend.model.User;
import dev.engripaye.backend.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account createAccount(User user){
        String accountNumber = "10" + System.currentTimeMillis();

        return accountRepository.save(new Account())
    }
}
