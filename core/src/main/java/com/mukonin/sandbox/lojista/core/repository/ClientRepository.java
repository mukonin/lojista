package com.mukonin.sandbox.lojista.core.repository;

import com.mukonin.sandbox.lojista.core.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Optional<Client> findById(Integer id);

    List<Client> getAll();

    void deleteClient(Integer id);

    void addClient(Client client);

    void updateClient(Client client);

}
