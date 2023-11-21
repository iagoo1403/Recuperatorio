package com.utn.k8.Preenunciado.repositories;

import com.utn.k8.Preenunciado.entidades.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
