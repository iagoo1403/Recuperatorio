package com.utn.k8.Preenunciado.controllers;


import com.utn.k8.Preenunciado.dtos.CustomerDTO;
import com.utn.k8.Preenunciado.entidades.Customer;
import com.utn.k8.Preenunciado.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable String id){
        Customer customer = customerService.getById(id);

        if(customer != null){
            return ResponseEntity.ok(customer);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll(){
        List<Customer> customers = customerService.getAll();

        return ResponseEntity.ok(customers);
    }

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody CustomerDTO customerDTO){
        Customer customer = customerService.save(customerDTO);
        return  ResponseEntity.ok(customer);
    }

    @PutMapping("{id}")
    ResponseEntity<Customer> update(@PathVariable String id,@RequestBody CustomerDTO customerDTO){
        Customer customer = customerService.update(id, customerDTO);

        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}