package com.agate.agate.service.impl;

import com.agate.agate.repository.ClientRepository;
import com.agate.agate.repository.Entity.Client;
import com.agate.agate.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public void setClient(Client client) {

        clientRepository.save(client);




    }

    @Override
    public void updateClient(int id, Client client) {
        clientRepository.findById(id).ifPresent(client1 -> {
            client1.setName(client.getName());
            client1.setAddress(client.getAddress());
            client1.setContactInformation(client.getContactInformation());
            clientRepository.save(client1);
        });
    }

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findClientById(int id) {
        if (clientRepository.findById(id).isPresent())
            return clientRepository.findById(id);
        else return Optional.empty();
    }
}