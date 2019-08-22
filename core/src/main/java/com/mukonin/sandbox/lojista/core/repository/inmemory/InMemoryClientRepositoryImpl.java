package com.mukonin.sandbox.lojista.core.repository.inmemory;

import com.mukonin.sandbox.lojista.core.entity.Client;
import com.mukonin.sandbox.lojista.core.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class InMemoryClientRepositoryImpl implements ClientRepository {

    private static List<Client> clients;

    static {
        clients = new ArrayList<>(Arrays.asList(
                new Client(1, "name1", LocalDate.now(), 1),
                new Client(2, "name2", LocalDate.now(), 2),
                new Client(3, "name3", LocalDate.now(), 3),
                new Client(4, "name4", LocalDate.now(), 4)

        ));
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return clients.stream().filter(client -> id.equals(client.getId())).findFirst();
    }

    @Override
    public List<Client> getAll() {
        return clients;
    }

    @Override
    public void deleteClient(Integer id) {
        clients.removeIf(client -> id.equals(client.getId()));
    }

    @Override
    public void addClient(Client client) {
        clients.add(client);
    }

    @Override
    public void updateClient(Client client) {
        if (client == null) {
            log.error("Record null can not be updated");
            return;
        }
        boolean isRemoved = clients.removeIf(client1 -> client.getId().equals(client1.getId()));
        if (isRemoved) {
            clients.add(client);
        } else {
            log.error("Cannot update non-existent contact with id [{}]", client.getId());
        }
    }
}
