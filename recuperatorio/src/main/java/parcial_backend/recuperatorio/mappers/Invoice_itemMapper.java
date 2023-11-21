package parcial_backend.recuperatorio.mappers;

import parcial_backend.recuperatorio.dtos.Invoice_itemDTO;
import parcial_backend.recuperatorio.entities.Invoice_item;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class Invoice_itemMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Invoice_itemDTO toDto(Invoice_item invoice_item){
        return Objects.isNull(invoice_item) ? null : modelMapper.map(invoice_item, Invoice_itemDTO.class);
    }

    public Invoice_item toEntity(Invoice_itemDTO invoice_itemDTO){
        return Objects.isNull(invoice_itemDTO) ? null : modelMapper.map(invoice_itemDTO, Invoice_item.class);
    }
}