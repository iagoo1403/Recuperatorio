package parcial_backend.recuperatorio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial_backend.recuperatorio.dtos.Invoice_itemDTO;
import parcial_backend.recuperatorio.entities.Invoice_item;
import parcial_backend.recuperatorio.services.Invoice_itemService;

import java.util.List;

@RestController
@RequestMapping("/api/Invoice_item")
public class Invoice_itemController {

    @Autowired
    private Invoice_itemService invoice_itemService;

    @GetMapping("/{id}")
    public ResponseEntity<Invoice_item> getById(@PathVariable Long id){
        Invoice_item invoice_item = invoice_itemService.getById(id);

        if(invoice_item != null){
            return ResponseEntity.ok(invoice_item);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Invoice_item>> getAll(){
        List<Invoice_item> invoice_items = invoice_itemService.getAll();

        return ResponseEntity.ok(invoice_items);
    }

    @PostMapping
    public ResponseEntity<Invoice_item> save(@RequestBody Invoice_itemDTO invoiceItemDTO){
        Invoice_item invoice_item = invoice_itemService.save(invoiceItemDTO);
        return ResponseEntity.ok(invoice_item);
    }

    @PutMapping("{id}")
    ResponseEntity<Invoice_item> update(@PathVariable Long id, @RequestBody Invoice_itemDTO invoiceItemDTO){
        Invoice_item invoice_item = invoice_itemService.update(id, invoiceItemDTO);

        return ResponseEntity.ok(invoice_item);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        invoice_itemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
