package com.api.client_crud.domain.service;

import java.util.ArrayList;
import java.util.List;

import com.api.client_crud.domain.entity.Client;
import com.api.client_crud.domain.repository.ClientRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClientService {
    ClientRepository clientRepository;

    public List<Client> getAllClients() {
        List<Client> allClients = new ArrayList<>();
        this.clientRepository.findAll().forEach(allClients::add);
        return allClients;
    }

    public Client saveClient(Client client) {
        return this.clientRepository.save(client);
    }

    public Client getClientById(Long id) {
        return this.clientRepository.findById(id).get();
    }

    public Client updatClient(Long id, Client client) {
        Client resClient = this.clientRepository.findById(id).get();
        if (!this.clientRepository.findById(id).isEmpty()) {
            resClient.setCpf(client.getCpf());
            resClient.setNome(client.getNome());
            resClient.setSexo(client.getSexo());
            resClient.setDataNascimento(client.getDataNascimento());
            this.clientRepository.save(resClient);
        }
        return resClient;
    }

    public void deleteClient(Long id) {
        this.clientRepository.deleteById(id);
    }
}
