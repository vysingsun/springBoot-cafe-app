package vysing.sun.cafeapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import vysing.sun.cafeapp.model.Drinks;
import vysing.sun.cafeapp.model.Invoices;
import vysing.sun.cafeapp.model.Orders;
import vysing.sun.cafeapp.service.DrinkService;
import vysing.sun.cafeapp.service.FoodService;
import vysing.sun.cafeapp.service.InvoiceService;
import vysing.sun.cafeapp.service.OrdersService;

@Controller
public class drinkSelection {
    private DrinkService drinkService;
    private FoodService foodService;
    private OrdersService ordersService;
    private InvoiceService invoiceService;

    public drinkSelection(DrinkService drinkService, FoodService foodService, OrdersService ordersService, InvoiceService invoiceService) {
        super();
        this.drinkService = drinkService;
        this.foodService = foodService;
        this.ordersService = ordersService;
        this.invoiceService = invoiceService;
    }

    @GetMapping("/cashier")
    public String listProduct(Model model){
        model.addAttribute("drinks", drinkService.findAllDrinks());
        model.addAttribute("foods", foodService.findAllFoods());
        model.addAttribute("orders", ordersService.findAllOrders());
        model.addAttribute("newOrder", new Orders());
        return "drinkSelection";
    }  


    @PostMapping("/drinkSelection")
    public String saveOrders(@ModelAttribute("orders") Orders orders){
        ordersService.addOrders(orders);
        return "redirect:/cashier";
    }

    @GetMapping("/drinkSelection/delete/{id}")
    public String deleteOrder(@PathVariable Long id, Model model){
        ordersService.deleteOrdersById(id);
        return "redirect:/cashier";
    }

    // Invoice Controller
    @GetMapping("/invoice/setTable")
    public String setTableToInvoice(Model model){
        Invoices invoices = new Invoices();
        model.addAttribute("invoice", invoices);
        return "tables";
    }

    @PostMapping("/calculate")
    public String saveTableInvoice(@ModelAttribute("invoice") Invoices invoices){
        invoiceService.addInvoices(invoices);
        return "redirect:/calculate";
    }
    // new edit function delete all order
    @GetMapping("/drinkSelection/deleteAllOrder")
    public String deleteAllOrder(){
        ordersService.deleteAllOrder();
        return "redirect:/cashier";
    }
}
