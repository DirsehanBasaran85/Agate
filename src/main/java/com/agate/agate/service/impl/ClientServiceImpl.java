package com.agate.agate.service.impl;

import com.agate.agate.repository.ClientRepository;
import com.agate.agate.repository.Entity.Client;
import com.agate.agate.service.ClientService;

public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void setClient(Client client) {

        clientRepository.save(client);

    }

}
