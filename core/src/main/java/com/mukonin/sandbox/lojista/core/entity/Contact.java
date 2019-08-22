package com.mukonin.sandbox.lojista.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Intended to represent Contact entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private Integer id;
    private String phoneNumber;
    private String address;
}
