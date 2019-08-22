package com.mukonin.sandbox.lojista.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Intended to represent Client entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Integer id;
    private String name;
    private LocalDate birthDate;
    private Integer contactId;
}
