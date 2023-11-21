package parcial_backend.recuperatorio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcial_backend.recuperatorio.dtos.CustomerDTO;
import parcial_backend.recuperatorio.entities.Customer;
import parcial_backend.recuperatorio.exceptions.ResourseConflictException;
import parcial_backend.recuperatorio.exceptions.ResourseNotFoundException;
import parcial_backend.recuperatorio.mappers.CustomerMapper;
import parcial_backend.recuperatorio.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElse(null);

        return customer;
    }

    public Customer save(CustomerDTO customerDTO) {
        if (getById(customerDTO.getCustomerId()) != null) {
            throw new ResourseConflictException("Customer ya registrado");
        }

        Customer customer = customerMapper.toEntity(customerDTO);
        customer.setCustomerId(customerDTO.getCustomerId());

        return customerRepository.save(customer);
    }

    public Customer update(Long id, CustomerDTO customerDTO) {
        Customer customer = getById(id);

        if (customer == null) {
            throw new ResourseNotFoundException("Customer no registrado");
        }

        Customer customerUpdate = customerMapper.toEntity(customerDTO);
        customerUpdate.setCustomerId(customerUpdate.getCustomerId());

        return customerRepository.save(customerUpdate);
    }

    public void delete(Long id) {
        Customer customer = getById(id);

        if (customer == null) {
            throw new ResourseNotFoundException("Customer no registrado");
        }

        customerRepository.delete(customer);
    }
}
