package com.mukonin.sandbox.lojista.core.service;

import com.mukonin.sandbox.lojista.core.entity.DeliveryUnit;
import com.mukonin.sandbox.lojista.core.model.DeliveryUnitDTO;
import com.mukonin.sandbox.lojista.core.repository.DeliveryUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryUnitService {

    private DeliveryUnitRepository deliveryUnitRepository;

    @Autowired
    public DeliveryUnitService(DeliveryUnitRepository deliveryUnitRepository) {
        this.deliveryUnitRepository = deliveryUnitRepository;
    }

    public List<DeliveryUnit> getAll() {
        return deliveryUnitRepository.getAll();
    }


    public List<DeliveryUnitDTO> getAllAsDTO() {
        return convertToDTOList(deliveryUnitRepository.getAll());
    }


    private DeliveryUnitDTO convertToDTO(DeliveryUnit deliveryUnit) {
        return new DeliveryUnitDTO(deliveryUnit.getUnitNumber(), deliveryUnit.getOperators());
    }

    private List<DeliveryUnitDTO> convertToDTOList(List<DeliveryUnit> deliveryUnits) {
        return deliveryUnits.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


}
