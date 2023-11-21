package com.utn.k8.Preenunciado.mapppers;



import com.utn.k8.Preenunciado.dtos.SupplierDTO;
import com.utn.k8.Preenunciado.entidades.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SupplierMapper {
    @Autowired
    private ModelMapper modelMapper;

    public SupplierDTO toDto(Supplier supplier){
        return Objects.isNull(supplier) ? null : modelMapper.map(supplier, SupplierDTO.class);
    }

    public Supplier toEntity(SupplierDTO supplierDTO){
        return Objects.isNull(supplierDTO) ? null : modelMapper.map(supplierDTO, Supplier.class);
    }
}
