package com.example.app1.services;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class Service1 {

    @PostConstruct
    public void init(){
        System.out.println("Se ha creado el bean");
    }
    public String algo(){
        return "Hola";
    }
}
