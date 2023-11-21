package com.utn.k8.Preenunciado.mapppers;

import com.utn.k8.Preenunciado.dtos.OrderDetailDTO;
import com.utn.k8.Preenunciado.entidades.OrderDetail;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OrderDetailMapper {
    @Autowired
    private ModelMapper modelMapper;

    public OrderDetailDTO toDto(OrderDetail orderDetail){
        return Objects.isNull(orderDetail) ? null : modelMapper.map(orderDetail, OrderDetailDTO.class);
    }

    public OrderDetail toEntity(OrderDetailDTO orderDetailDTO){
        return Objects.isNull(orderDetailDTO) ? null : modelMapper.map(orderDetailDTO, OrderDetail.class);
    }
}