package dev.engripaye.backend.service;

import dev.engripaye.backend.model.User;
import dev.engripaye.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User register(String fullname, String email){

        User user = new User();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setBalance(new BigDecimal("12000000.00"));

        return userRepository.save(user);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email).orElse(null);
    }
}
