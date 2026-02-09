package dev.engripaye.backend.repository;

import dev.engripaye.backend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {


}
