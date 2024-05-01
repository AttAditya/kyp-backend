package com.aaapis.kyp.repositories;

import com.aaapis.kyp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    @Override
    User save(User user);
}
