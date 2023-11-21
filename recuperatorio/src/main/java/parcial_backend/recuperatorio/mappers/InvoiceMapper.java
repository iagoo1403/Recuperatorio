package parcial_backend.recuperatorio.mappers;

import parcial_backend.recuperatorio.dtos.InvoiceDTO;
import parcial_backend.recuperatorio.entities.Invoice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class InvoiceMapper {
    @Autowired
    private ModelMapper modelMapper;

    public InvoiceDTO toDto(Invoice invoice){
        return Objects.isNull(invoice) ? null : modelMapper.map(invoice, InvoiceDTO.class);
    }

    public Invoice toEntity(InvoiceDTO invoiceDTO){
        return Objects.isNull(invoiceDTO) ? null : modelMapper.map(invoiceDTO, Invoice.class);
    }
}