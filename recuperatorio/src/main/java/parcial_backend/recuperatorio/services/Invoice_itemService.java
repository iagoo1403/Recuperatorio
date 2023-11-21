package parcial_backend.recuperatorio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcial_backend.recuperatorio.dtos.Invoice_itemDTO;
import parcial_backend.recuperatorio.entities.Invoice_item;
import parcial_backend.recuperatorio.exceptions.ResourseConflictException;
import parcial_backend.recuperatorio.exceptions.ResourseNotFoundException;
import parcial_backend.recuperatorio.mappers.Invoice_itemMapper;
import parcial_backend.recuperatorio.repository.Invoice_itemRepository;

import java.util.List;

@Service
public class Invoice_itemService {
    @Autowired
    private Invoice_itemRepository invoice_itemRepository;

    @Autowired
    private Invoice_itemMapper invoice_itemMapper;

    public List<Invoice_item> getAll() {
        return invoice_itemRepository.findAll();
    }

    public Invoice_item getById(Long id) {
        Invoice_item invoice_item = invoice_itemRepository.findById(id)
                .orElse(null);

        return invoice_item;
    }

    public Invoice_item save(Invoice_itemDTO invoice_itemDTO) {
        if (getById(invoice_itemDTO.getInvoiceLineId()) != null) {
            throw new ResourseConflictException("Invoice_item ya registrado");
        }

        Invoice_item invoice_item = invoice_itemMapper.toEntity(invoice_itemDTO);
        invoice_item.setInvoiceLineId(invoice_itemDTO.getInvoiceLineId());

        return invoice_itemRepository.save(invoice_item);
    }

    public Invoice_item update(Long id, Invoice_itemDTO invoice_itemDTO) {
        Invoice_item invoice_item = getById(id);

        if (invoice_item == null) {
            throw new ResourseNotFoundException("Invoice_item no registrado");
        }

        Invoice_item invoice_itemUpdate = invoice_itemMapper.toEntity(invoice_itemDTO);
        invoice_itemUpdate.setInvoiceLineId(invoice_itemUpdate.getInvoiceLineId());

        return invoice_itemRepository.save(invoice_itemUpdate);
    }

    public void delete(Long id) {
        Invoice_item invoice_item = getById(id);

        if (invoice_item == null) {
            throw new ResourseNotFoundException("Invoice_item no registrado");
        }

        invoice_itemRepository.delete(invoice_item);
    }
}
