package vysing.sun.cafeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vysing.sun.cafeapp.exception.DrinkNotFoundException;
import vysing.sun.cafeapp.model.Receipt;
import vysing.sun.cafeapp.repo.ReceiptRepo;

@Service
public class ReceiptService {
    private final ReceiptRepo receiptRepo;

    @Autowired
    public ReceiptService(ReceiptRepo receiptRepo) {
        this.receiptRepo = receiptRepo;
    }

    public Receipt addReceipt(Receipt receipt){
        return receiptRepo.save(receipt);
    }

    public List<Receipt> findAllReceipt(){
        return receiptRepo.findAll();
    }

    public Receipt findReceiptById(Long id){
        return receiptRepo.findReceiptById(id).orElseThrow(() -> new DrinkNotFoundException("Drink by id " + id + " was not found."));
    }
}
