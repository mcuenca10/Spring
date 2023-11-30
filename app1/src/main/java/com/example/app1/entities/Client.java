package com.example.app1.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@ToString()
@EqualsAndHashCode(of = {"id"})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter private int id;
    @Setter @Getter private String name;

    public int getCodigo(){
        return id;
    }
    public Client(String name) {
        this.name = name;
    }
}
