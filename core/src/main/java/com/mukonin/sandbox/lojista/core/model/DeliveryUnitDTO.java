package com.mukonin.sandbox.lojista.core.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryUnitDTO {
    private String deliveryNumber;
    private List<String> operators;

}
