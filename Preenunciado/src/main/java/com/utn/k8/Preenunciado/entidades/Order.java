package com.utn.k8.Preenunciado.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "OrderID")
    private Long orderId;
    //@Column(name = "orderId")
    //@GeneratedValue(generator = "orders")
    //@TableGenerator(name = "orders", table = "sqlite_sequence",
            //pkColumnName = "name", pkColumnValue = "seq", valueColumnName = "OrderID")
    //private long orderId;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;


    @Column(name = "EmployeeID")
    private Long employeeId;

    @Column(name = "OrderDate")
    private String orderDate;

    @Column(name = "RequiredDate")
    private String requiredDate;

    @Column(name = "ShippedDate")
    private String shippedDate;

    @Column(name = "ShipVia")
    private Integer shipVia;

    @Column(name = "Freight")
    private double freight;

    @Column(name = "ShipName")
    private String shipName;

    @Column(name = "ShipCity")
    private String shipCity;

    @Column(name = "ShipRegion")
    private String shipRegion;

    @Column(name = "ShipPostalCode")
    private String shipPostalCode;

    @Column(name = "ShipCountry")
    private String shipCountry;
}
