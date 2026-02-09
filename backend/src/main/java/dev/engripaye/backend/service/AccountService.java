package dev.engripaye.backend.service;

import dev.engripaye.backend.model.Account;
import dev.engripaye.backend.model.User;
import dev.engripaye.backend.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account createAccount(User user){

        Account account = new Account();
        account.setUser(user);
        account.setAccountNumber(generateAccountNumber());
        account.setBalance(new BigDecimal("12000000.00"));

        return accountRepository.save(account);
    }

    private String generateAccountNumber(){
        return "10" + UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 10);
    }
}
