package vysing.sun.cafeapp.service;

import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import vysing.sun.cafeapp.exception.DrinkNotFoundException;
import vysing.sun.cafeapp.model.Foods;
import vysing.sun.cafeapp.repo.FoodRepo;

@Service
public class FoodService {
    private final FoodRepo foodRepo;

    @Autowired
    public FoodService(FoodRepo foodRepo) {
        this.foodRepo = foodRepo;
    }

    public Foods addFood(MultipartFile file, Foods foods) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if (filename.contains("..")) {
            System.out.println("Not");

        }
        try {
            foods.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (Exception e) {
            // TODO: handle exception
        }
        return foodRepo.save(foods);
    }

    public List<Foods> findAllFoods() {
        return foodRepo.findAll();
    }

    public Foods updateFood(MultipartFile file, Foods foods) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if (filename.contains("..")) {
            System.out.println("Not");

        }
        try {
            foods.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (Exception e) {
            // TODO: handle exception
        }
        return foodRepo.save(foods);
    }

    public Foods findFoodById(Long id) {
        return foodRepo.findFoodsById(id)
                .orElseThrow(() -> new DrinkNotFoundException("Drink by id " + id + " was not found."));
    }

    public void deleteFoodsById(Long id) {
        foodRepo.deleteFoodsById(id);
    }
}
