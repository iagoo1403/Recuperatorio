package com.utn.k8.Preenunciado.controllers;

import com.utn.k8.Preenunciado.dtos.CategoryDTO;
import com.utn.k8.Preenunciado.dtos.ProductDTO;
import com.utn.k8.Preenunciado.entidades.Category;
import com.utn.k8.Preenunciado.entidades.Product;
import com.utn.k8.Preenunciado.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        Product product = productService.getById(id);

        if(product != null){
            return ResponseEntity.ok(product);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productService.getAll();

        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductDTO productDTO){
        Product product = productService.save(productDTO);
        return  ResponseEntity.ok(product);
    }

    @PutMapping("{id}")
    ResponseEntity<Product> update(@PathVariable Long id,@RequestBody ProductDTO productDTO){
        Product product = productService.update(id, productDTO);

        return ResponseEntity.ok(product);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

