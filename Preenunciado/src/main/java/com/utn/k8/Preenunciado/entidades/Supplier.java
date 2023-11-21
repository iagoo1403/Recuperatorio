package com.utn.k8.Preenunciado.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Suppliers")
public class Supplier {
    @Id
    @Column(name = "SupplierID")
    private Long supplierId;

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

    @Column(name = "HomePage")
    private String homePage;
}
