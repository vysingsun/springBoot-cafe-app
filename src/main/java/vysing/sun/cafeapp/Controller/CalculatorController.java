package vysing.sun.cafeapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import vysing.sun.cafeapp.model.Invoices;
import vysing.sun.cafeapp.model.Receipt;
import vysing.sun.cafeapp.service.InvoiceService;
import vysing.sun.cafeapp.service.ReceiptService;

@Controller
public class CalculatorController {
    private InvoiceService invoiceService;
    private ReceiptService receiptService;

    public CalculatorController(InvoiceService invoiceService, ReceiptService receiptService) {
        this.invoiceService = invoiceService;
        this.receiptService = receiptService;
    }

    @GetMapping("/calculator/{id}")
    public String calculator(Model model, @PathVariable Long id){
        Invoices invoices = invoiceService.findInvoiceById(id);
        Receipt receipt = new Receipt();
        receipt.setTotal_dollar(invoices.getTotal_price());
        receipt.setInvoice_id(invoices.getId());
        receipt.setOrder_date(invoices.getOrder_date());
        receipt.setTable_number(invoices.getTable_number());

        // receipt.getId();

        model.addAttribute("invoice", invoices);
        model.addAttribute("receipts", receipt);
        return "calculator";
    }

    @PostMapping("/receipt")
    public String saveReceipt(@ModelAttribute("receipts") Receipt receipt){
        receiptService.addReceipt(receipt);

        return "redirect:/receipt/" + receipt.getId();
    }
}
