package com.mukonin.sandbox.lojista.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Intended to represent User entity
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String username;
    private String password;
    private boolean enabled;
    private Role role;
}
