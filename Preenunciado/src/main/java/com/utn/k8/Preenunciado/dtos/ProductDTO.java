package com.utn.k8.Preenunciado.dtos;


import com.utn.k8.Preenunciado.entidades.Category;
import com.utn.k8.Preenunciado.entidades.Supplier;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long productId;
    private String productName;
    private Supplier supplierId;
    private Category categoryId;
    private String quatityPerUnit;
    private double unitPrice;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private String discontinued;
}