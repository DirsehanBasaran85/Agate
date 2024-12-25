package com.agate.agate.service;

import com.agate.agate.repository.Entity.Client;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {

    void setClient(Client client);

}
