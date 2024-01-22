package vysing.sun.cafeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vysing.sun.cafeapp.model.Invoices;
import vysing.sun.cafeapp.repo.InvoiceRepo;

@Service
public class InvoiceService {
    private final InvoiceRepo invoiceRepo;

    @Autowired
    public InvoiceService(InvoiceRepo invoiceRepo) {
        this.invoiceRepo = invoiceRepo;
    }

    public Invoices addInvoices(Invoices invoices){
        return invoiceRepo.save(invoices);
    }
    
    public List<Invoices> findAllInvoice(){
        return invoiceRepo.findAll();
    }

    public Invoices findInvoiceById(Long id){
        return invoiceRepo.findById(id).get();
    }
}
