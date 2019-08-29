package com.mukonin.sandbox.lojista.core.model;

import com.mukonin.sandbox.lojista.core.entity.Parcel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
/**
 * Intended to represent Data Transfer Object for {@link Parcel} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParcelDTO {
    private int id;
    private String trackingNumber;
    private LocalDate dateOfDelivery;
    private String clientLastName;
    private String clientPhoneNumber;
}
