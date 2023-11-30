package com.example.app1.repositories;

import com.example.app1.entities.Client;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path ="rest", collectionResourceRel = "clients")
public interface ClientRestRepository extends JpaRepository<Client, Integer> {
    List<Client> findAllByName(String name);
}



