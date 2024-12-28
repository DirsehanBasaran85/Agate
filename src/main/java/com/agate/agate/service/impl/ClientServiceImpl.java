package com.agate.agate.service.impl;

import com.agate.agate.repository.CampaignRepository;
import com.agate.agate.repository.ClientRepository;
import com.agate.agate.repository.Entity.Campaign;
import com.agate.agate.repository.Entity.Client;
import com.agate.agate.service.ClientService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;
    CampaignRepository campaignRepository;

    public ClientServiceImpl(ClientRepository clientRepository, CampaignRepository campaignRepository){
        this.clientRepository = clientRepository;
        this.campaignRepository = campaignRepository;
    }

    @Override
    public void setClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    @Transactional
    public void updateClient(int id, Client client) {
        clientRepository.findById(id).ifPresent(client1 -> {
            client1.setName(client.getName());
            client1.setAddress(client.getAddress());
            client1.setContactInformation(client.getContactInformation());
            clientRepository.save(client1);
        });
    }

    @Override
    public void updateByName(String name, Client client) {
        clientRepository.findByName(name).ifPresent(client1 -> {
            client1.setName(client.getName());
            client1.setAddress(client.getAddress());
            client1.setContactInformation((client.getContactInformation()));
            clientRepository.save(client1);
        });
    }

    @Override
    public void assignCampaign(int clientId, int campaignId) {
        clientRepository.findById(campaignId).ifPresent(client -> {
            campaignRepository.findById(campaignId).ifPresent(campaign -> {
                List<Campaign> campaignList = new ArrayList<>();
                campaignList.add(campaign);
                client.setCampaign(campaignList);
                campaignRepository.save(campaign);
            });
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

    @Override
    public void deleteClients() {
        clientRepository.deleteAll();
    }

    @Override
    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }

}