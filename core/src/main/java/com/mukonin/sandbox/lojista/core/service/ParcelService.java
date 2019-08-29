package com.mukonin.sandbox.lojista.core.service;

import com.mukonin.sandbox.lojista.core.entity.Client;
import com.mukonin.sandbox.lojista.core.entity.Contact;
import com.mukonin.sandbox.lojista.core.entity.Parcel;
import com.mukonin.sandbox.lojista.core.model.ParcelDTO;
import com.mukonin.sandbox.lojista.core.repository.ClientRepository;
import com.mukonin.sandbox.lojista.core.repository.ContactRepository;
import com.mukonin.sandbox.lojista.core.repository.ParcelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParcelService {
    private final ParcelRepository parcelRepository;

    private final ClientRepository clientRepository;

    private final ContactRepository contactRepository;

    public ParcelService(ParcelRepository parcelRepository, ClientRepository clientRepository, ContactRepository contactRepository) {
        this.parcelRepository = parcelRepository;
        this.clientRepository = clientRepository;
        this.contactRepository = contactRepository;
    }

    public List<Parcel> getAll() {
        return parcelRepository.getAll();
    }

    public List<ParcelDTO> getAllAsParcelDTO() {
        List<Parcel> parcelList = getAll();
        return convertIntoParcelDTO(parcelList);
    }

    private List<ParcelDTO> convertIntoParcelDTO(List<Parcel> parcelList) {
        List<ParcelDTO> parcelDTOList = new ArrayList<>();
        for (Parcel parcel : parcelList) {
            Optional<ParcelDTO> optionalParcelDTO = convertIntoParcelDTO(parcel);
            optionalParcelDTO.ifPresent(parcelDTOList::add);
        }
        return parcelDTOList;
    }

    private Optional<ParcelDTO> convertIntoParcelDTO(Parcel parcel) {
        Optional<Client> optionalClient = clientRepository.findById(parcel.getClientId());
        if (optionalClient.isPresent()) {
            Optional<Contact> optionalContact = contactRepository.findById(optionalClient.get().getId());
            if (optionalContact.isPresent()) {
                ParcelDTO parcelDTO = new ParcelDTO(parcel.getId(), parcel.getTrackingNumber(), parcel.getDateOfDelivery(),
                        optionalClient.get().getLastName(), optionalContact.get().getPhoneNumber());
                return Optional.of(parcelDTO);
            }
        }
        return Optional.empty();
    }
}
