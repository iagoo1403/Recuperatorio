package com.utn.k8.Preenunciado.controllers;

import com.utn.k8.Preenunciado.dtos.OrderDTO;
import com.utn.k8.Preenunciado.entidades.Order;
import com.utn.k8.Preenunciado.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id){
        Order order = orderService.getById(id);

        if(order != null){
            return ResponseEntity.ok(order);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll(){
        List<Order> orders = orderService.getAll();

        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody OrderDTO orderDTO){
        Order order = orderService.save(orderDTO);
        return  ResponseEntity.ok(order);
    }

    @PutMapping("{id}")
    ResponseEntity<Order> update(@PathVariable Long id,@RequestBody OrderDTO orderDTO){
        Order order = orderService.update(id, orderDTO);

        return ResponseEntity.ok(order);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}