package com.utn.k8.Preenunciado.controllers;


import com.utn.k8.Preenunciado.dtos.SupplierDTO;
import com.utn.k8.Preenunciado.entidades.Supplier;
import com.utn.k8.Preenunciado.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getById(@PathVariable Long id){
        Supplier supplier = supplierService.getById(id);

        if(supplier != null){
            return ResponseEntity.ok(supplier);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAll(){
        List<Supplier> suppliers = supplierService.getAll();

        return ResponseEntity.ok(suppliers);
    }

    @PostMapping
    public ResponseEntity<Supplier> save(@RequestBody SupplierDTO supplierDTO){
        Supplier supplier = supplierService.save(supplierDTO);
        return  ResponseEntity.ok(supplier);
    }

    @PutMapping("{id}")
    ResponseEntity<Supplier> update(@PathVariable Long id,@RequestBody SupplierDTO supplierDTO){
        Supplier supplier = supplierService.update(id, supplierDTO);

        return ResponseEntity.ok(supplier);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        supplierService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

