package com.mukonin.sandbox.lojista.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Intended to represent Client entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer contactId;
}
