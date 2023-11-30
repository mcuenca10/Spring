package com.example.app1.controllers;

import com.example.app1.entities.Client;
import com.example.app1.repositories.ClientRepository;
import com.example.app1.services.ClientService;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "client")
public class ClientController {
    @Autowired
    private ClientRepository repoClient;

    private  ClientService clientService;

    private ClientController(ClientService service){
        this.clientService=service;
    }

    @GetMapping(path = "") // .../client
    public List<Client> all() {
        return repoClient.findAll();
    }

    @GetMapping(path = "{id:\\d{1,5}}") // GET: /client/:id
    public Client select(@PathVariable("id") int codigo) {
        return repoClient.findById(codigo).orElse(null);
    }

    @PostMapping(path = "")  //POST: /client
    public ResponseEntity<Client> insert(@RequestBody Client client) {
       client.setId(-1);
        var c = repoClient.save(client);
        return ResponseEntity.ok(c);
    }

    @PutMapping(path = "")  //PUT: /client
    public ResponseEntity<Void> update(@RequestBody Client client) {
        if (!repoClient.existsById(client.getId())) {
            return ResponseEntity.notFound().build();
        }
        repoClient.save(client);
        return ResponseEntity.ok(null);
    }
    @PatchMapping(path = "")  //PATCH: /client
    public ResponseEntity<Void> patch(@RequestBody Client client) {
        try {
            clientService.patch(client);
        }catch (RuntimeException ex){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
   @DeleteMapping (path = "", params = "id}")//DELETE /client?id=1
    public void delete(@RequestParam(defaultValue = "0") int  id){

        repoClient.deleteById(id);
    }


}
