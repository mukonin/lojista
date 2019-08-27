package com.mukonin.sandbox.lojista.core.repository.inmemory;

import com.mukonin.sandbox.lojista.core.entity.Role;
import com.mukonin.sandbox.lojista.core.entity.User;
import com.mukonin.sandbox.lojista.core.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class InMemoryUserRepositoryImpl implements UserRepository {

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

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findByName(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }
}
