package com.utn.k8.Preenunciado.dtos;

import com.utn.k8.Preenunciado.entidades.Order;
import com.utn.k8.Preenunciado.entidades.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {
    private Order orderId;
    private Product productId;
    private double unitPrice;
    private Integer quantity;
    private double discount;
}