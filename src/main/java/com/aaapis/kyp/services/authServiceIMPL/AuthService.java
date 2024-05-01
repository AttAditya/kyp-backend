package com.aaapis.kyp.services.authServiceIMPL;

import com.aaapis.kyp.dtos.UserDTOs;
import com.aaapis.kyp.models.User;
import com.aaapis.kyp.repositories.UserRepository;
import com.aaapis.kyp.services.IAuthService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("V1AuthService")
public class AuthService implements IAuthService {

    UserRepository userRepository;

    public AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User userLogin(String username, String password) {

        System.out.println("User trying to log in" + username);
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty() || !password.equals(user.get().getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }
        System.out.println("User logged in" + user.get().getUsername());

        return user.get();
    }


    @Override
    public User userRegister(UserDTOs userDto) {

        Optional<User> existingUser = userRepository.findByUsername(userDto.getUsername());
        if (existingUser.isPresent()) {
            // User with the same username already exists
            throw new RuntimeException("Username already exists");
        }

        // If user doesn't exist, create a new one
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getUserRole());

        // Set other user properties

        // Save the user
        return userRepository.save(user);
    }

    @Override
    public User userLogout(User user) {
        return null;
    }
}
