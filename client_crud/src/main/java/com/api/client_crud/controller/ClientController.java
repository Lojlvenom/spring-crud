package com.api.client_crud.controller;

import java.util.List;

import javax.validation.Valid;

import com.api.client_crud.domain.dto.ClientDto;
import com.api.client_crud.domain.dto.ResponseDto;
import com.api.client_crud.domain.entity.Client;
import com.api.client_crud.domain.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;


    @PostMapping //http://localhost:8080/client/
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto saveUser(@Valid @RequestBody Client client) {
      return clientService.saveClient(client);
    }
  
    @GetMapping(value = "/list") // http://localhost:8080/client/list
    public List<ClientDto> getAllUser() {
      return clientService.getAllClients();
    }
  
    @GetMapping(value = "/{id}")
    public ClientDto getUserById(@Valid @PathVariable Long id) {
      return clientService.getClientById(id);
    }
  
    @PutMapping
    public ResponseDto updateUser(@Valid @RequestBody Client client) {
      return clientService.updateClient(client);
    }
  
    @DeleteMapping(value = "/{id}")
    public ResponseDto deleteUser(@Valid @PathVariable Long id) {
      return clientService.deleteClient(id);
    }

}
