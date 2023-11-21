package parcial_backend.recuperatorio.mappers;

import parcial_backend.recuperatorio.dtos.CustomerDTO;
import parcial_backend.recuperatorio.entities.Customer;
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
