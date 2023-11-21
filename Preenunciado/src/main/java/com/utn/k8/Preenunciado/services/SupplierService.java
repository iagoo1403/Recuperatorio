package com.utn.k8.Preenunciado.services;


import com.utn.k8.Preenunciado.dtos.SupplierDTO;
import com.utn.k8.Preenunciado.entidades.Supplier;
import com.utn.k8.Preenunciado.excepciones.ResourceNotFoundException;
import com.utn.k8.Preenunciado.excepciones.ResourseConflictException;
import com.utn.k8.Preenunciado.mapppers.SupplierMapper;
import com.utn.k8.Preenunciado.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private SupplierMapper supplierMapper;

    public List<Supplier> getAll(){
        return supplierRepository.findAll();
    }

    public Supplier getById(Long id){
        Supplier supplier = supplierRepository.findById(id)
                .orElse(null);

        return supplier;
    }
    public Supplier save(SupplierDTO supplierDTO){
        if(getById(supplierDTO.getSupplierId()) != null){
            throw new ResourseConflictException("supplier ya registrado");
        }

        Supplier supplier = supplierMapper.toEntity(supplierDTO);
        supplier.setSupplierId(supplierDTO.getSupplierId());

        return supplierRepository.save(supplier);
    }

    public Supplier update(Long id, SupplierDTO supplierDTO){
        Supplier supplier = getById(id);

        if(supplier == null){
            throw new ResourceNotFoundException("supplier no registrado");
        }

        Supplier supplierUpdate = supplierMapper.toEntity(supplierDTO);
        supplierUpdate.setSupplierId(supplierUpdate.getSupplierId());

        return supplierRepository.save(supplierUpdate);
    }

    public void delete (Long id){
        Supplier supplier = getById(id);

        if(supplier == null){
            throw new ResourceNotFoundException("supplier no registrado");
        }

        supplierRepository.delete(supplier);
    }

}