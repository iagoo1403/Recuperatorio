package parcial_backend.recuperatorio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial_backend.recuperatorio.dtos.CustomerDTO;
import parcial_backend.recuperatorio.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/Customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id){
        Customer customer = customerService.getById(id);

        if(customer != null){
            return ResponseEntity.ok(customer);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll(){
        List<Customer> customer = customerService.getAll();

        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody CustomerDTO customerDTO){
        Customer customers = customerService.save(customerDTO);
        return ResponseEntity.ok(customers);
    }

    @PutMapping("{id}")
    ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        Customer customer = customerService.update(id, customerDTO);

        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
