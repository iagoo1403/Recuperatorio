package com.utn.k8.Preenunciado.services;


import com.utn.k8.Preenunciado.dtos.ProductDTO;
import com.utn.k8.Preenunciado.entidades.Product;
import com.utn.k8.Preenunciado.excepciones.ResourceNotFoundException;
import com.utn.k8.Preenunciado.excepciones.ResourseConflictException;
import com.utn.k8.Preenunciado.mapppers.ProductMapper;
import com.utn.k8.Preenunciado.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getById(Long id){
        Product product  = productRepository.findById(id)
                .orElse(null);

        return product;
    }
    public Product save(ProductDTO productDTO){
        if(getById(productDTO.getProductId()) != null){
            throw new ResourseConflictException("Product ya registrado");
        }

        Product product = productMapper.toEntity(productDTO);
        product.setProductId(productDTO.getProductId());

        return productRepository.save(product);
    }

    public Product update(Long id, ProductDTO productDTO){
        Product product = getById(id);

        if(product == null){
            throw new ResourceNotFoundException("Product no registrado");
        }

        Product productUpdate = productMapper.toEntity(productDTO);
        productUpdate.setProductId(productUpdate.getProductId());

        return productRepository.save(productUpdate);
    }

    public void delete (Long id){
        Product product = getById(id);

        if(product == null){
            throw new ResourceNotFoundException("Product no registrado");
        }

        productRepository.delete(product);
    }

}