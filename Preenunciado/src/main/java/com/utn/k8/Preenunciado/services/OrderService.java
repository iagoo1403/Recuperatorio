package com.utn.k8.Preenunciado.services;

import com.utn.k8.Preenunciado.dtos.OrderDTO;
import com.utn.k8.Preenunciado.entidades.Order;
import com.utn.k8.Preenunciado.excepciones.ResourceNotFoundException;
import com.utn.k8.Preenunciado.excepciones.ResourseConflictException;
import com.utn.k8.Preenunciado.mapppers.OrderMapper;
import com.utn.k8.Preenunciado.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    public Order getById(Long id){
        Order order = orderRepository.findById(id)
                .orElse(null);

        return order;
    }

    public Order save(OrderDTO orderDTO){
        if(getById(orderDTO.getOrderId()) != null){
            throw new ResourseConflictException("Order ya registrado");
        }

        Order order = orderMapper.toEntity(orderDTO);
        order.setOrderId(orderDTO.getOrderId());

        return orderRepository.save(order);
    }


    public Order update(Long id, OrderDTO orderDTO){
        Order order = getById(id);

        if(order == null){
            throw new ResourceNotFoundException("Order no registrado");
        }

        Order orderUpdate = orderMapper.toEntity(orderDTO);
        orderUpdate.setOrderId(orderUpdate.getOrderId());

        return orderRepository.save(orderUpdate);
    }

    public void delete (Long id){
        Order order = getById(id);

        if(order == null){
            throw new ResourceNotFoundException("Order no registrado");
        }

        orderRepository.delete(order);
    }
}

