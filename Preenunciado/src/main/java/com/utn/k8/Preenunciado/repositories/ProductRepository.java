package com.utn.k8.Preenunciado.repositories;

import com.utn.k8.Preenunciado.entidades.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}