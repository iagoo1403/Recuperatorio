package parcial_backend.recuperatorio.dtos;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice_itemDTO {
    private Long invoiceId;
    private Long trackId;
    private Double unitPrice;
    private Integer quantity;
    private Long invoiceLineId;

}
