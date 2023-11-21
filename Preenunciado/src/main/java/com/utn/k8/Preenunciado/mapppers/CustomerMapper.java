package com.utn.k8.Preenunciado.mapppers;

import com.utn.k8.Preenunciado.dtos.CustomerDTO;
import com.utn.k8.Preenunciado.entidades.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomerMapper {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerDTO toDto(Customer customer){
        return Objects.isNull(customer) ? null : modelMapper.map(customer, CustomerDTO.class);
    }

    public Customer toEntity(CustomerDTO customerDTO){
        return Objects.isNull(customerDTO) ? null : modelMapper.map(customerDTO, Customer.class);
    }
}

