package com.api.client_crud.domain.repository;

import com.api.client_crud.domain.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
