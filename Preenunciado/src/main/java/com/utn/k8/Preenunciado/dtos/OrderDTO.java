package com.utn.k8.Preenunciado.dtos;


import com.utn.k8.Preenunciado.entidades.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long orderId;
    private Customer customerId;
    private Long employeeId;
    private LocalDateTime orderDate;
    private LocalDateTime requiredDate;
    private LocalDateTime shippedDate;
    private Integer shipVia;
    private double freight;
    private String shipName;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;
}