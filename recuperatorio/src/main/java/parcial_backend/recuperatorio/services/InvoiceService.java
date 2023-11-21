package parcial_backend.recuperatorio.services;

import parcial_backend.recuperatorio.dtos.InvoiceDTO;
import parcial_backend.recuperatorio.entities.Invoice;
import parcial_backend.recuperatorio.exceptions.ResourseNotFoundException;
import parcial_backend.recuperatorio.exceptions.ResourseConflictException;
import parcial_backend.recuperatorio.mappers.InvoiceMapper;
import parcial_backend.recuperatorio.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceMapper invocieMapper;


    public List<Invoice> getAll(){
        return invoiceRepository.findAll();
    }

    public Invoice getById(Long id){
        Invoice invoice = invoiceRepository.findById(id)
                .orElse(null);

        return invoice;
    }
    public Invoice save(InvoiceDTO invoiceDTO){
        if(getById(invoiceDTO.getInvoiceId()) != null){
            throw new ResourseConflictException("Invocie ya registrado");
        }

        Invoice invocie = invocieMapper.toEntity(invoiceDTO);
        invocie.setInvoiceId(invoiceDTO.getInvoiceId());

        return invoiceRepository.save(invocie);
    }

    public Invoice update(Long id, InvoiceDTO invoiceDTO){
        Invoice invoice = getById(id);

        if(invoice == null){
            throw new ResourseNotFoundException("Invoice no registrado");
        }

        Invoice invoiceUpdate = invocieMapper.toEntity(invoiceDTO);
        invoiceUpdate.setInvoiceId(invoiceUpdate.getInvoiceId());

        return invoiceRepository.save(invoiceUpdate);
    }

    public void delete (Long id){
        Invoice invoice = getById(id);

        if(invoice == null){
            throw new ResourseNotFoundException("Invoice no registrado");
        }

        invoiceRepository.delete(invoice);
    }
}