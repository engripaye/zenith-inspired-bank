package dev.engripaye.backend.service;

import dev.engripaye.backend.model.User;
import dev.engripaye.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User register(String fullname, String email){
        return userRepository.save(new User(null, fullname, email, "1,200,200"));
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email).orElse(null);
    }
}
