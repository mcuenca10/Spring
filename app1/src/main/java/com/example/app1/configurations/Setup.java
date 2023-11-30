package com.example.app1.configurations;

import com.example.app1.repositories.ClientRepository;
import com.example.app1.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Setup {
    @Autowired
    private ClientRepository repo;
    @Bean
    public CommandLineRunner init(){
        return args -> {
            System.out.println("Inicialización base de datos");
            repo.save(new Client("Pedro"));
            repo.save(new Client("Juan"));
            repo.save(new Client("Ana"));
            System.out.println(repo.findAll());
        };
    }
}
