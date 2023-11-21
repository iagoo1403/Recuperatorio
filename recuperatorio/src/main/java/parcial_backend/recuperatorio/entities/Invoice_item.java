package parcial_backend.recuperatorio.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Invoices_item")
public class Invoice_item {
    @Id
    @Column(name = "InvoiceLineId")
    private Long invoiceLineId;

    @ManyToOne
    @JoinColumn(name = "InvoiceId")
    private Invoice invoiceId;

    @ManyToOne
    @JoinColumn(name = "TrackId")
    private Track trackId;

    @Column(name = "UnitPrice")
    private Double unitPrice;

    @Column(name = "Quantity")
    private Integer quantity;

}
