package vysing.sun.cafeapp.service;

 


import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import vysing.sun.cafeapp.exception.DrinkNotFoundException;
import vysing.sun.cafeapp.model.Drinks;
import vysing.sun.cafeapp.repo.DrinkRepo;

@Service
public class DrinkService {
    private final DrinkRepo drinkRepo;

    @Autowired
    public DrinkService(DrinkRepo drinkRepo){
        this.drinkRepo= drinkRepo;
    }

    // public Drinks addDrink(Drinks drinks){
    //     return drinkRepo.save(drinks);
    // }
    public Drinks addDrink(MultipartFile file, Drinks drinks) throws IOException {
        
        try {
            drinks.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (Exception e) {
            // TODO: handle exception
        }
        return drinkRepo.save(drinks);
    }

    public List<Drinks> findAllDrinks(){
        return drinkRepo.findAll();
    }

    public Drinks updateDrinks(MultipartFile file, Drinks drinks){
        String filename= StringUtils.cleanPath(file.getOriginalFilename());
        if(filename.contains("..")){
            System.out.println("Not");
        }
        try {
            drinks.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (Exception e) {
            // TODO: handle exception
        }
        return drinkRepo.save(drinks);
    }

    public Drinks findDrinksById(Long id){
        return drinkRepo.findDrinksById(id).orElseThrow(() -> new DrinkNotFoundException("Drink by id " + id + " was not found."));
    }

    public void deleteDrinks(Long id){
        drinkRepo.deleteDrinksById(id);
    }
}
