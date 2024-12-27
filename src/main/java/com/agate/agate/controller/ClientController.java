package com.agate.agate.controller;

import com.agate.agate.repository.Entity.Client;
import com.agate.agate.service.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Client")
@Tag(name = "clients", description = "For Clients")
public class ClientController {

    ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping()
    public void addClient(@RequestBody Client client ){
        clientService.setClient(client);

    }

    @PutMapping("{id}")
    public void updateClient(@PathVariable("id") int id, @RequestBody Client client){
        clientService.updateClient(id, client);
    }

    @PutMapping("by/{name}")
    public void updateByName(@PathVariable("name") String name, @RequestBody Client client) {
        clientService.updateByName(name, client);
    }

    @GetMapping()
    public List<Client> getAllClients(){
        return clientService.findAllClients();
    }

    @GetMapping("{id}")
    public Optional<Client> getById(@PathVariable("id") int id){
        return clientService.findClientById(id);
    }

    @DeleteMapping()
    public void deleteClients() {
        clientService.deleteClients();
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable ("id") int id) {
        clientService.deleteClient(id);
    }

}
