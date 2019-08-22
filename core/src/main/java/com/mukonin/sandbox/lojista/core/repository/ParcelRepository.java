package com.mukonin.sandbox.lojista.core.repository;

import com.mukonin.sandbox.lojista.core.entity.Parcel;

import java.util.List;
import java.util.Optional;

public interface ParcelRepository {

    Optional<Parcel> findByTrackingNumber(String trackingNumber);

    Optional<Parcel> findById(Integer id);

    List<Parcel> findParcelByClientId(Integer clientId);

    List<Parcel> getAll();

    void addParcel(Parcel parcel);

    void updateParcel(Parcel parcel);

    void deleteParcel(Integer id);
}
