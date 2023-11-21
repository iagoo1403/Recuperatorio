package com.utn.k8.Preenunciado.mapppers;


import com.utn.k8.Preenunciado.dtos.OrderDTO;
import com.utn.k8.Preenunciado.entidades.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OrderMapper {
    @Autowired
    private ModelMapper modelMapper;

    public OrderDTO toDto(Order order){
        return Objects.isNull(order) ? null : modelMapper.map(order, OrderDTO.class);
    }

    public Order toEntity(OrderDTO orderDTO){
        return Objects.isNull(orderDTO) ? null : modelMapper.map(orderDTO, Order.class);
    }
}
