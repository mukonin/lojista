package com.mukonin.sandbox.lojista.core.repository;

import com.mukonin.sandbox.lojista.core.entity.Role;
import com.mukonin.sandbox.lojista.core.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * In-memory implementation of user repository
 */
@Repository
public class UserRepository {

    private static final Logger log = LoggerFactory.getLogger(UserRepository.class);

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private static final List<User> users;

    static {
        users = new ArrayList<>(Arrays.asList(
                new User("manager1", passwordEncoder.encode("manager"), true, Role.MANAGER),
                new User("manager2", passwordEncoder.encode("manager"), true, Role.MANAGER),
                new User("operator1", passwordEncoder.encode("operator"), true, Role.OPERATOR),
                new User("operator2", passwordEncoder.encode("operator"), true, Role.OPERATOR),
                new User("customer1", passwordEncoder.encode("customer"), true, Role.CUSTOMER),
                new User("customer2", passwordEncoder.encode("customer"), true, Role.CUSTOMER)
        ));
        log.debug("Users initialized");
    }

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }
}
