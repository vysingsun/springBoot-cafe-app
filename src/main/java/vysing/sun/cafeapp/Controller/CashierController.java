package vysing.sun.cafeapp.Controller;

import java.sql.Date;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vysing.sun.cafeapp.model.user_type;
import vysing.sun.cafeapp.model.users;
import vysing.sun.cafeapp.service.CashierService;

@Controller
public class CashierController {
    private CashierService cashierService;

    public CashierController(CashierService cashierService) {
        super();
        this.cashierService = cashierService;
    }

    // still can't use
    // @GetMapping("/cashiers")
    // public String listCashier(Model model){
    // model.addAttribute("cashiers", cashierService.findAllCashiers());
    // return "drinks";
    // }

    @GetMapping("/cashiers/newCashiers")
    public String createNewCashiers(Model model) {
        users usr = new users();
        model.addAttribute("cashiers", usr);
        return "newCashiers";
    }

    @PostMapping("/cashiers")
    public String saveCashiers(@ModelAttribute("cashiers") users usr, @RequestParam("file") MultipartFile file, @RequestParam("date") Date date_of_birth) throws IOException{
        cashierService.addCashier(file, usr, date_of_birth);
        return "redirect:/admin";
    }

    @GetMapping("/cashiers/edit/{id}")
    public String editCashiers(@PathVariable Long id, Model model) {
        model.addAttribute("cashiers", cashierService.findCashiersById(id));
        return "edit_cashiers";
    }

    @PostMapping("/cashiers/{id}")
    public String updateCashiers(@PathVariable Long id, @ModelAttribute("cashier") users usr,
            @RequestParam("file") MultipartFile file, @RequestParam("date") Date date_of_birth) {
        users existingCashiers = cashierService.findCashiersById(id);

        existingCashiers.setFirst_name(usr.getFirst_name());
        existingCashiers.setLast_name(usr.getLast_name());
        existingCashiers.setAge(usr.getAge());
        existingCashiers.setSex(usr.getSex());
        existingCashiers.setDate_of_birth(usr.getDate_of_birth());
        existingCashiers.setLogin(usr.getLogin());
        existingCashiers.setPassword(usr.getPassword());
        existingCashiers.setImage(usr.getImage());

        cashierService.updateCashiers(file, existingCashiers,date_of_birth);

        return "redirect:/admin";
    }

    @GetMapping("/cashiers/delete/{id}")
    public String deleteCashier(@PathVariable Long id, Model model) {
        cashierService.deleteCashiersById(id);
        return "redirect:/admin";
    }

    // findByIdTest
    // @GetMapping("/cashiers/list/{id}")
    // public String listCashiersByID(@PathVariable Long id, Model model){
    // model.addAttribute("cas", cashierService.findCashiersById(id));
    // return "drinks";
    // }
}
