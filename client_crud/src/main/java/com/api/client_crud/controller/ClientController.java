package com.api.client_crud.controller;

import java.util.List;

import javax.validation.Valid;

import com.api.client_crud.domain.entity.Client;
import com.api.client_crud.domain.service.ClientService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> insertClient(@Valid @RequestBody Client client) {
        this.clientService.saveClient(client);
        return new ResponseEntity<Client>(this.clientService.getClientById(client.getId()), HttpStatus.CREATED);
    }

    @GetMapping({ "/{id}" })
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return new ResponseEntity<Client>(this.clientService.getClientById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> allClients = this.clientService.getAllClients();
        return new ResponseEntity<>(allClients, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        this.clientService.updatClient(id, client);
        return new ResponseEntity<Client>(this.clientService.getClientById(id), HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        this.clientService.deleteClient(id);
        return new ResponseEntity<Client>(HttpStatus.ACCEPTED);
    }
}
