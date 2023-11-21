package com.utn.k8.Preenunciado.services;

import com.utn.k8.Preenunciado.entidades.OrderDetail;
import com.utn.k8.Preenunciado.mapppers.OrderDetailMapper;
import com.utn.k8.Preenunciado.repositories.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    public List<OrderDetail> getAll(){
        return orderDetailRepository.findAll();
    }

    public OrderDetail getById(Long orderId, Long productId){
        OrderDetail orderDetail = orderDetailRepository.findById(orderId)
                .orElse(null);

        return orderDetail;
    }


}

