package com.mukonin.sandbox.lojista.core.repository;

import com.mukonin.sandbox.lojista.core.entity.DeliveryUnit;

import java.util.List;
import java.util.Optional;

public interface DeliveryUnitRepository {
    Optional<DeliveryUnit> getDeliveryUnitById(Integer id);

    List<DeliveryUnit> getAll();

    void addDeliveryUnit(DeliveryUnit deliveryUnit);

    void deleteDeliveryUnit(Integer id);

    void updateDeliveryUnit(DeliveryUnit deliveryUnit);

}
