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
import java.util.List;

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

        account.setBalance(account.getBalance().subtract(amount));
        accountRepository.save(account);

        Transaction transaction = new Transaction(
                null,
                "Cash Withdrawal",
                amount,
                LocalDateTime.now(),
                TransactionType.DEBIT,
                account
        );

        transactionRepository.save(transaction);
    }

    // TRANSFER

    public void transfer(Account from, Account to, BigDecimal amount){

        if(from.getBalance().compareTo(amount) < 0){
            throw new IllegalStateException("Insufficient balance");
        }


        // Debit Sender
        from.setBalance(from.getBalance().subtract(amount));
        accountRepository.save(from);


        transactionRepository.save(new Transaction(
                null,
                "Transfer to " + to.getAccountNumber(),
                amount,
                LocalDateTime.now(),
                TransactionType.DEBIT,
                from
        ));

        // credit receiver
        to.setBalance(to.getBalance().add(amount));
        accountRepository.save(to);

        transactionRepository.save(new Transaction(
                null,
                "Transfer from " + from.getAccountNumber(),
                amount,
                LocalDateTime.now(),
                TransactionType.CREDIT,
                to
        ));
    }

    // GET TRANSACTION HISTORY
    public List<Transaction> getTransactionHistory(Account account){
        return transactionRepository.findByAccountId(account.getId());
    }

}
