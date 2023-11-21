package parcial_backend.recuperatorio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Invoices")
public class Invoice {
    @Id
    @Column(name = "InvoiceId")
    private Long invoiceId;

    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customerId;

    @Column(name = "InvoiceDate")
    private LocalDateTime invoiceDate;

    @Column(name = "BillingAddress")
    private String billingAddress;

    @Column(name = "BillingCity")
    private String billingCity;

    @Column(name = "BillingState")
    private String billingState;

    @Column(name = "BillingCountry")
    private String billingCountry;

    @Column(name = "BillingPostalCode")
    private String billingPostalCode;

    @Column(name = "Total")
    private Double total;


}
