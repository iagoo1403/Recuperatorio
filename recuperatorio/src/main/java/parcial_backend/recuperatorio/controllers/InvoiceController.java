package parcial_backend.recuperatorio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial_backend.recuperatorio.dtos.InvoiceDTO;
import parcial_backend.recuperatorio.entities.Invoice;
import parcial_backend.recuperatorio.services.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/api/Invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getById(@PathVariable Long id){
        Invoice invoice = invoiceService.getById(id);

        if(invoice != null){
            return ResponseEntity.ok(invoice);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> getAll(){
        List<Invoice> invoices = invoiceService.getAll();

        return ResponseEntity.ok(invoices);
    }

    @PostMapping
    public ResponseEntity<Invoice> save(@RequestBody InvoiceDTO invoiceDTO){
        Invoice invoice = invoiceService.save(invoiceDTO);
        return ResponseEntity.ok(invoice);
    }

    @PutMapping("{id}")
    ResponseEntity<Invoice> update(@PathVariable Long id, @RequestBody InvoiceDTO invoiceDTO){
        Invoice invoice = invoiceService.update(id, invoiceDTO);

        return ResponseEntity.ok(invoice);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        invoiceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
