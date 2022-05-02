package com.api.client_crud.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import com.api.client_crud.domain.dto.ClientDto;
import com.api.client_crud.domain.dto.ResponseDto;
import com.api.client_crud.domain.entity.Client;
import com.api.client_crud.domain.repository.ClientRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDto responseDto;

    
    ClientRepository clientRepository;

    public ResponseDto saveClient(Client client) {
        responseDto.setId(clientRepository.save(client).getId());
        responseDto.setMessage("Cliente adicionado com sucesso");
        responseDto.setStatus(HttpStatus.OK.value());
        
        return responseDto;
    }


    public List<ClientDto> getAllClients() {
        List<ClientDto> listAllClients = clientRepository.findAll().stream()
                        .map(Client -> modelMapper.map(Client, ClientDto.class))
                        .collect(Collectors.toList());

        return listAllClients;
    }


    public ClientDto getClientById(Long id) {
        return modelMapper.map(clientRepository.findById(id).get(), ClientDto.class);
        
    }

    public ResponseDto updateClient(Client client) {
        responseDto.setId(clientRepository.save(client).getId());

        if(!clientRepository.findById(client.getId()).isEmpty()){
            clientRepository.save(client);
            responseDto.setMessage("Cliente alterado com sucesso...");
            responseDto.setId(Long.valueOf(HttpStatus.ACCEPTED.value()));
        } else {
            responseDto.setMessage("ID de usuario invalido...");
            responseDto.setId(Long.valueOf(HttpStatus.BAD_REQUEST.value()));
        }
        return responseDto;
    }

    
    public ResponseDto deleteClient(Long id) {
        responseDto.setId(id);

        if(id > 0) {
            clientRepository.deleteById(id);
            responseDto.setMessage("Cliente deletado com sucesso...");
            responseDto.setId(Long.valueOf(HttpStatus.ACCEPTED.value()));
        } else {
            responseDto.setMessage("ID de usuario invalido...");
            responseDto.setId(Long.valueOf(HttpStatus.BAD_REQUEST.value()));
        }

        return responseDto;
    }
}
