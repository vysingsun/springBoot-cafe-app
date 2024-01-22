package vysing.sun.cafeapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import vysing.sun.cafeapp.model.Receipt;
import vysing.sun.cafeapp.service.OrdersService;
import vysing.sun.cafeapp.service.ReceiptService;

@Controller
public class ReceiptController {
    private ReceiptService receiptService;
    private OrdersService ordersService;

    public ReceiptController(ReceiptService receiptService, OrdersService ordersService) {
        super();
        this.receiptService = receiptService;
        this.ordersService = ordersService;
    }
     
    @GetMapping("/receipt/{id}")
    public String listReceipt(@PathVariable Long id, Model model){

        model.addAttribute("receipts", receiptService.findReceiptById(id));

        model.addAttribute("orders", ordersService.findAllOrders());
        
        return "receipt";
    }

    @GetMapping("/history")
    public String ListAllReceipt(Model model){
        model.addAttribute("receipts", receiptService.findAllReceipt());
        return "history";
    }
}
