package vysing.sun.cafeapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vysing.sun.cafeapp.model.Invoices;
import vysing.sun.cafeapp.model.Orders;
import vysing.sun.cafeapp.model.Tables_management;
import vysing.sun.cafeapp.service.InvoiceService;
import vysing.sun.cafeapp.service.OrdersService;
import vysing.sun.cafeapp.service.TableService;

@Controller
public class TableController {
    private TableService tableService;
    private InvoiceService invoiceService;
    private OrdersService ordersService;

    public TableController(TableService tableService, InvoiceService invoiceService, OrdersService ordersService) {
        super();
        this.tableService = tableService;
        this.invoiceService = invoiceService;
        this.ordersService = ordersService;
    }
    @GetMapping("/tables")
    public String listTable(Model model){
        model.addAttribute("tables", tableService.findAllTable());
        return "tables";
    }

    @GetMapping("/table/newTable")
    public String createNewTable(Model model){
        Tables_management tables_management = new Tables_management();
        model.addAttribute("tables", tables_management);
        return "newTable";
    }

    @PostMapping("/table")
    public String saveTable(@ModelAttribute("tables") Tables_management tables_management){
        tableService.addTable(tables_management);
        return "redirect:/admin";
    }
    
    @GetMapping("/table/edit/{id}")
    public String editTable(@PathVariable Long id, Model model){
        model.addAttribute("tables", tableService.findTableById(id));
        return "edit_table";
    }

    @PostMapping("/table/cashieredit/{id}")
    public String saveUpdateTables(@PathVariable Long id){
        
        Tables_management existingTable = tableService.findTableById(id);

        existingTable.setAvailability("#32d86a");

        tableService.updateTable(existingTable);
        return "redirect:/tables";
    }

    @GetMapping("/table/{id}")
    public String updateTables(@PathVariable Long id){
        Tables_management existingTable = tableService.findTableById(id);

        existingTable.setAvailability("#EC061D");

        tableService.updateTable(existingTable);

        Invoices invoice = new Invoices();
        invoice.setTable_number(tableService.findTableById(id).getNumber());

        Float price = (float) 0;
        for(Orders order: ordersService.findAllOrders()){
            price = price + (order.getPrice() * order.getQuantity());
        }
        invoice.setTotal_price(price);
        Invoices savedInvoice = invoiceService.addInvoices(invoice);

        return "redirect:/calculator/" + savedInvoice.getId(); 
        // + savedInvoice.getId();
    }

    @GetMapping("/table/delete/{id}")
    public String deleteTaable(@PathVariable Long id, Model model){
        tableService.deleteTablesById(id);
        return "redirect:/admin";
    }

}
