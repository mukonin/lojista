package com.mukonin.sandbox.lojista.core.repository;

import com.mukonin.sandbox.lojista.core.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Describes repository operations for {@link User}
 */
public interface UserRepository {
    Optional<User> findByName(String name);

    List<User> findAll();

}
