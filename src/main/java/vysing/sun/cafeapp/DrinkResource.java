package vysing.sun.cafeapp;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vysing.sun.cafeapp.model.Drinks;
import vysing.sun.cafeapp.service.DrinkService;

@RestController
@RequestMapping("/Drinks")
public class DrinkResource {
    private final DrinkService drinkService;

    public DrinkResource(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Drinks>> getAllDrinks() {
        List<Drinks> drinks = drinkService.findAllDrinks();
        return new ResponseEntity<>(drinks, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Drinks> getDrinksById(@PathVariable("id") Long id) {
        Drinks drinks = drinkService.findDrinksById(id);
        return new ResponseEntity<>(drinks, HttpStatus.OK);
    }

    // @PostMapping("/add")
    // public ResponseEntity<Drinks> addDrink(@RequestBody Drinks drinks) {
    //     Drinks newDrinks = drinkService.addDrink(drinks);
    //     return new ResponseEntity<>(newDrinks, HttpStatus.CREATED);
    // }

    // @PutMapping("/update")
    // public ResponseEntity<Drinks> updateDrink(@RequestBody Drinks drinks) {
    //     Drinks updateDrinks = drinkService.updateDrinks(drinks);
    //     return new ResponseEntity<>(updateDrinks, HttpStatus.OK);
    // }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDrink(@PathVariable("id") Long id) {
        drinkService.deleteDrinks(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
