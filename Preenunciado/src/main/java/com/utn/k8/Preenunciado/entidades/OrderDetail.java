package com.utn.k8.Preenunciado.entidades;

import com.utn.k8.Preenunciado.entidades.pkCompuesta.OrderDetailID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Order Details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    // PK Compuesta
    @EmbeddedId
    private OrderDetailID id;

    @Column(name = "UnitPrice")
    private Double unitPrice;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Discount") // El tipo de dato dice REAL en la BD
    private Double discount;

}