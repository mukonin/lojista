package com.mukonin.sandbox.lojista.core.repository.inmemory;

import com.mukonin.sandbox.lojista.core.entity.DeliveryUnit;
import com.mukonin.sandbox.lojista.core.repository.DeliveryUnitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Provides in-memory implementation for {@link DeliveryUnitRepository}
 */
@Repository
@Slf4j
public class InMemoryDeliveryUnitRepositoryImpl implements DeliveryUnitRepository {

    private static List<DeliveryUnit> deliveryUnits;

    static {
        deliveryUnits = new ArrayList<>(Arrays.asList(
                new DeliveryUnit(1, "Unit1", Arrays.asList(1, 2, 3)),
                new DeliveryUnit(2, "Unit2", Collections.singletonList(4)),
                new DeliveryUnit(3, "Unit3", Arrays.asList(5, 6))
        ));
    }

    @Override
    public Optional<DeliveryUnit> getDeliveryUnitById(Integer id) {
        return deliveryUnits.stream().filter(deliveryUnit -> id.equals(deliveryUnit.getId())).findFirst();
    }

    @Override
    public List<DeliveryUnit> getAll() {
        return deliveryUnits;
    }

    @Override
    public void addDeliveryUnit(DeliveryUnit deliveryUnit) {
        deliveryUnits.add(deliveryUnit);
    }

    @Override
    public void deleteDeliveryUnit(Integer id) {
        deliveryUnits.removeIf(deliveryUnit -> id.equals(deliveryUnit.getId()));
    }

    @Override
    public void updateDeliveryUnit(DeliveryUnit deliveryUnit) {
        if (deliveryUnit == null) {
            log.error("Record null can not be updated");
            return;
        }
        boolean isRemoved = deliveryUnits.removeIf(deliveryUnit1 -> deliveryUnit.getId().equals(deliveryUnit1.getId()));
        if (isRemoved) {
            deliveryUnits.add(deliveryUnit);
        } else {
            log.error("Cannot update non-existent contact with id [{}]", deliveryUnit.getId());
        }
    }
}
