package com.agate.agate.service;

import com.agate.agate.repository.Entity.Client;

import java.util.List;
import java.util.Optional;


public interface ClientService {

    void setClient(Client client);

    void updateClient(int id, Client client);

    List<Client> findAllClients();

    Optional<Client> findClientById(int id);


}