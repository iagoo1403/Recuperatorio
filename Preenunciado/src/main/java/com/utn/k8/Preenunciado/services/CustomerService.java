package com.utn.k8.Preenunciado.services;

import com.utn.k8.Preenunciado.dtos.CustomerDTO;
import com.utn.k8.Preenunciado.entidades.Customer;
import com.utn.k8.Preenunciado.excepciones.ResourceNotFoundException;
import com.utn.k8.Preenunciado.excepciones.ResourseConflictException;
import com.utn.k8.Preenunciado.mapppers.CustomerMapper;
import com.utn.k8.Preenunciado.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Customer getById(String id){
        Customer customer = customerRepository.findById(id)
                .orElse(null);

        return customer;
    }
    public Customer save(CustomerDTO customerDTO){
        if(getById(customerDTO.getCustomerId().toUpperCase()) != null){
            throw new ResourseConflictException("Customer ya registrado");
        }

        Customer customer = customerMapper.toEntity(customerDTO);
        customer.setCustomerId(customerDTO.getCustomerId().toUpperCase());

        return customerRepository.save(customer);
    }



    public Customer update(String id, CustomerDTO customerDTO){
        Customer customer = getById(id.toUpperCase());

        if(customer == null){
            throw new ResourceNotFoundException("Customer no registrado");
        }

        Customer customerUpdate = customerMapper.toEntity(customerDTO);
        customerUpdate.setCustomerId(customerUpdate.getCustomerId().toUpperCase());

        return customerRepository.save(customerUpdate);
    }

    public void delete (String id){
        Customer customer = getById(id);

        if(customer == null){
            throw new ResourceNotFoundException("Customer no registrado");
        }

        customerRepository.delete(customer);
    }
}