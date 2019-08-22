package com.mukonin.sandbox.lojista.core.repository;

import com.mukonin.sandbox.lojista.core.entity.Contact;

import java.util.Optional;

public interface ContactRepository {

    Optional<Contact> findById(Integer id);

    void addContact(Contact contact);

    void deleteContact(Integer id);

    void updateContact(Contact contact);

}
