package com.mukonin.sandbox.lojista.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Intended to represent Parcel entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parcel {
    private Integer id;
    private String trackingNumber;
    private LocalDate dateOfDelivery;
    private Integer clientId;
}
