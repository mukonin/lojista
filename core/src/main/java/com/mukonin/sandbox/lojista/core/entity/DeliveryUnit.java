package com.mukonin.sandbox.lojista.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Intended to represent DeliveryUnit entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryUnit {
    private Integer id;
    private String unitNumber;
    private List<Integer> parcels;
}
