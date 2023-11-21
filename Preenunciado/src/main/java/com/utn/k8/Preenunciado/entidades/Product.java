package com.utn.k8.Preenunciado.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @Column(name = "ProductId")
    private Long productId;

    @Column(name = "ProductName")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "SupplierID")
    private Supplier supplierId;

    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category categoryId;

    @Column(name = "QuantityPerUnit")
    private String quantityPerUnit;

    @Column(name = "UnitPrice")
    private Double unitPrice;

    @Column(name = "UnitsInStock")
    private Integer unitsInStock;

    @Column(name = "UnitsOnOrder")
    private Integer unitsOnOrder;

    @Column(name = "ReorderLevel")
    private Integer reorderLevel;

    @Column(name = "Discontinued")
    private String discontinued;
}