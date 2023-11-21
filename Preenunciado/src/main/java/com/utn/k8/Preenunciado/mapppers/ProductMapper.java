package com.utn.k8.Preenunciado.mapppers;

import com.utn.k8.Preenunciado.dtos.ProductDTO;
import com.utn.k8.Preenunciado.entidades.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ProductDTO toDto(Product product){
        return Objects.isNull(product) ? null : modelMapper.map(product, ProductDTO.class);
    }

    public Product toEntity(ProductDTO productDTO){
        return Objects.isNull(productDTO) ? null : modelMapper.map(productDTO, Product.class);
    }
}
