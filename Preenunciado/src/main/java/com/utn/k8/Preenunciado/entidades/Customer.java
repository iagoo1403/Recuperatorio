package com.utn.k8.Preenunciado.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Customers")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @Column(name = "CustomerId")
    private String customerId;
    //@Column(name = "CustomerID")
    //@GeneratedValue(generator = "customers")
    //@TableGenerator(name = "Customers", table = "sqlite_sequence",
            //pkColumnName = "name", valueColumnName = "seq",
            //pkColumnValue="CustomerId",
            //initialValue=1, allocationSize=1)
    //private long storeId;

    @Column(name = "CompanyName")
    private String companyName;

    @Column(name = "ContactName")
    private String contactName;

    @Column(name = "ContactTitle")
    private String contactTitle;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "Region")
    private String region;

    @Column(name = "PostalCode")
    private String postalCode;

    @Column(name = "Country")
    private String country;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Fax")
    private String fax;
}

