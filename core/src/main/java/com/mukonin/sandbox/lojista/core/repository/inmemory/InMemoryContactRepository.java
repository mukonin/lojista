package com.mukonin.sandbox.lojista.core.repository.inmemory;

import com.mukonin.sandbox.lojista.core.entity.Contact;
import com.mukonin.sandbox.lojista.core.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class InMemoryContactRepository implements ContactRepository {

    private static List<Contact> contacts;

    static {
        contacts = new ArrayList<>(Arrays.asList(
                new Contact(1, "address1", "phone1"),
                new Contact(2, "address2", "phone2"),
                new Contact(3, "address3", "phone3"),
                new Contact(4, "address4", "phone4"),
                new Contact(5, "address5", "phone5"),
                new Contact(6, "address6", "phone6"),
                new Contact(7, "address7", "phone7")
        ));
    }

    @Override
    public Optional<Contact> findById(Integer id) {
        return contacts.stream().filter(contact -> id.equals(contact.getId())).findFirst();
    }

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void deleteContact(Integer id) {
        contacts.removeIf(contact1 -> id.equals(contact1.getId()));
    }

    @Override
    public void updateContact(Contact contact) {
        if (contact == null) {
            log.error("Record null can not be updated");
            return;
        }
        boolean isRemoved = contacts.removeIf(contact1 -> contact.getId().equals(contact1.getId()));
        if (isRemoved) {
            contacts.add(contact);
        } else {
            log.error("Cannot update non-existent contact with id [{}]", contact.getId());
        }
    }
}
