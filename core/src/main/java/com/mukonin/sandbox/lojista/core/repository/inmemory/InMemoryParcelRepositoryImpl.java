package com.mukonin.sandbox.lojista.core.repository.inmemory;

import com.mukonin.sandbox.lojista.core.entity.Parcel;
import com.mukonin.sandbox.lojista.core.repository.ParcelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Provides in-memory implementation for {@link ParcelRepository}
 */
@Repository
@Slf4j
public class InMemoryParcelRepositoryImpl implements ParcelRepository {

    private static List<Parcel> parcels;

    static {
        parcels = Arrays.asList(
                new Parcel(1, "111111111", LocalDate.now(), 1),
                new Parcel(2, "222222222", LocalDate.now(), 2),
                new Parcel(3, "333333333", LocalDate.now(), 3),
                new Parcel(4, "444444444", LocalDate.now(), 4),
                new Parcel(5, "555555555", LocalDate.now(), 5),
                new Parcel(6, "666666666", LocalDate.now(), 6)
        );
    }

    @Override
    public Optional<Parcel> findByTrackingNumber(String trackingNumber) {
        return parcels.stream().filter(parcel -> trackingNumber.equals(parcel.getTrackingNumber())).findFirst();
    }

    @Override
    public Optional<Parcel> findById(Integer id) {
        return parcels.stream().filter(parcel -> id.equals(parcel.getId())).findFirst();

    }

    @Override
    public List<Parcel> findParcelByClientId(Integer clientId) {
        return parcels.stream().filter(parcel -> clientId.equals(parcel.getClientId())).collect(Collectors.toList());

    }

    @Override
    public List<Parcel> getAll() {
        return parcels;
    }

    @Override
    public void addParcel(Parcel parcel) {
        parcels.add(parcel);
    }

    @Override
    public void updateParcel(Parcel parcel) {
        if (parcel == null) {
            log.error("Record null can not be updated");
            return;
        }
        boolean isRemoved = parcels.removeIf(parcel1 -> parcel.getId().equals(parcel1.getId()));
        if (isRemoved) {
            parcels.add(parcel);
        } else {
            log.error("Cannot update non-existent parcel with id [{}]", parcel.getId());
        }
    }

    @Override
    public void deleteParcel(Integer id) {
        parcels.removeIf(parcel -> id.equals(parcel.getId()));

    }
}
