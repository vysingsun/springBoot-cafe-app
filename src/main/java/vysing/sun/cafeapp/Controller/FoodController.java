package vysing.sun.cafeapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vysing.sun.cafeapp.model.Foods;
import vysing.sun.cafeapp.service.FoodService;

@Controller
public class FoodController {
    private FoodService foodService;

    public FoodController(FoodService foodService) {
        super();
        this.foodService = foodService;
    }

    // don't use
    // @GetMapping("/foods")
    // public String listFoods(Model model){
        // model.addAttribute("foods", foodService.findAllFoods());
        // if we use -> reture "drinks"
    //     return "drinks";
    // }

    @GetMapping("/foods/newFoods")
    public String createNewFoods(Model model){
        Foods foods = new Foods();
        model.addAttribute("foods", foods);
        return "newFoods";
    }

    @PostMapping("/foods")
    public String saveFoods(@ModelAttribute("foods") Foods foods,@RequestParam("file") MultipartFile file){
        foodService.addFood(file, foods);
        return "redirect:/admin";
    }
    
    @GetMapping("/foods/edit/{id}")
    public String editFoods(@PathVariable Long id, Model model){
        model.addAttribute("foods", foodService.findFoodById(id));
        return "edit_foods";
    }

    @PostMapping("/foods/{id}")
    public String updateFoods(@PathVariable Long id, @ModelAttribute("drink") Foods foods, @RequestParam("file") MultipartFile file){
        Foods existingFoods = foodService.findFoodById(id);

        existingFoods.setFood_code(foods.getFood_code());
        existingFoods.setFood_name(foods.getFood_name());
        existingFoods.setFood_category(foods.getFood_category());
        existingFoods.setImage(foods.getImage());
        existingFoods.setPrice(foods.getPrice());
        existingFoods.setNote(foods.getNote());

        foodService.updateFood(file, existingFoods);
        return "redirect:/admin";
    }

    @GetMapping("/foods/delete/{id}")
    public String deleteFoods(@PathVariable Long id, Model model){
        foodService.deleteFoodsById(id);
        return "redirect:/admin";
    }
}
