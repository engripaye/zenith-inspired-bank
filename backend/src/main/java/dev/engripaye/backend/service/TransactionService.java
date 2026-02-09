package dev.engripaye.backend.service;

import dev.engripaye.backend.model.Account;
import dev.engripaye.backend.model.Transaction;
import dev.engripaye.backend.model.TransactionType;
import dev.engripaye.backend.repository.AccountRepository;
import dev.engripaye.backend.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
     // Implement transaction-related methods here, such as creating transactions, retrieving transaction history, etc.


    // DEPOSIT

    public void deposit(Account account, BigDecimal amount){
        account.setBalance(account.getBalance().add(amount));

        accountRepository.save(account);

        Transaction transaction = new Transaction(
                null,
                "cash Deposit",
                amount,
                LocalDateTime.now(),
                TransactionType.CREDIT,
                account
        );

        transactionRepository.save(transaction);
    }

    // WITHDRAW
    public void withdraw(Account account, BigDecimal amount){
        if(account.getBalance().compareTo(amount) < 0){
            throw new IllegalStateException("Insufficient balance");
        }
    }
}
