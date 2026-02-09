package dev.engripaye.backend.service;

import dev.engripaye.backend.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService {

    private final AccountRepository transactionRepository;

     // Implement transaction-related methods here, such as creating transactions, retrieving transaction history, etc.


}
