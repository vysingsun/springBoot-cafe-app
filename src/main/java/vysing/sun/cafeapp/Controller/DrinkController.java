package vysing.sun.cafeapp.Controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vysing.sun.cafeapp.model.Drinks;
import vysing.sun.cafeapp.service.CashierService;
import vysing.sun.cafeapp.service.DrinkService;
import vysing.sun.cafeapp.service.FoodService;

@Controller
public class DrinkController {
    
    private DrinkService drinkService;
    private FoodService foodService;
    private CashierService cashierService;

    

    public DrinkController(DrinkService drinkService ,FoodService foodService, CashierService cashierService){
        super();
        this.drinkService = drinkService;
        this.foodService =foodService;
        this.cashierService = cashierService;
    }
    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mnv = new ModelAndView("login");
        return mnv;
    }

    // @GetMapping("/admin")
    // public String listDrinks(Model model ,String email, String password){
        
    //         model.addAttribute("drinks", drinkService.findAllDrinks());
    //         model.addAttribute("foods", foodService.findAllFoods());
    //         model.addAttribute("cashiers", cashierService.findAllCashiers());
    //         return "drinks";
        
        
    // }

    @GetMapping("/admin")
    public String listDrinks(Model model){
        model.addAttribute("drinks", drinkService.findAllDrinks());
        model.addAttribute("foods", foodService.findAllFoods());
        model.addAttribute("cashiers", cashierService.findAllCashiers());
        return "drinks";
    }

    @GetMapping("/drinks/newDrinks")
    public String createNewDrinks(Model model){
        Drinks drinks = new Drinks();
        model.addAttribute("drinks", drinks);
        return "newDrinks";
    }

    @PostMapping("/drinks")
    public String saveDrink(@ModelAttribute("drink") Drinks drinks ,@RequestParam("file") MultipartFile file) throws IOException{
        drinkService.addDrink(file, drinks);
        return "redirect:/admin";
    }

    @GetMapping("/drinks/edit/{id}")
    public String editDrinks(@PathVariable Long id, Model model){
        model.addAttribute("drinks",drinkService.findDrinksById(id));
        return "edit_Drinks";
    }

    @PostMapping("/drinks/{id}")
    public String updateDrink(@PathVariable Long id, @ModelAttribute("drink") Drinks drinks, @RequestParam("file") MultipartFile file){
        Drinks existingDrink = drinkService.findDrinksById(id);
        existingDrink.setCategory_code(drinks.getCategory_code());
        existingDrink.setCategory_name(drinks.getCategory_name());
        existingDrink.setCategory(drinks.getCategory());
        existingDrink.setPrice(drinks.getPrice());
        existingDrink.setNote(drinks.getNote());
        drinkService.updateDrinks(file, existingDrink);

        return "redirect:/admin";
    }

    @GetMapping("/drinks/delete/{id}")
    public String deleteDrink(@PathVariable Long id, Model model) {
        drinkService.deleteDrinks(id);
        return "redirect:/admin";
    }

    // findByIdTest
    // @GetMapping("/drinks/{id}")
    // public String listDrinksByID(@PathVariable Long id, Model model){
    //     model.addAttribute("drinks", drinkService.findDrinksById(id));
    //     return "redirect:/drinks";
    // }
}
