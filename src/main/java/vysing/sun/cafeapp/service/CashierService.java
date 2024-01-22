package vysing.sun.cafeapp.service;

import java.sql.Date;
import java.util.Base64;
import java.util.Calendar;
// import java.util.Date;
import java.util.List;

// import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import vysing.sun.cafeapp.exception.DrinkNotFoundException;
import vysing.sun.cafeapp.model.user_type;
import vysing.sun.cafeapp.model.users;
import vysing.sun.cafeapp.repo.CashierRepo;

@Service
public class CashierService {
    private final CashierRepo cashierRepo;

    @Autowired
    public CashierService(CashierRepo cashierRepo){
        this.cashierRepo = cashierRepo;
    }

    public users addCashier(MultipartFile file, users usr, Date date_of_birth){
        // calculate age of cashier
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();
        // input date of birth
        birthDate.setTime(date_of_birth);
        System.out.println("Hii : " + date_of_birth);

        int age = 0;
        age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        System.out.println("Hii : " + age);
        
        // set type cashier
        user_type type = new user_type();
        type.setId(2);
        usr.setUser_type_id(type);

        usr.setDate_of_birth(date_of_birth);
        usr.setAge(age);

        try {
            usr.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        return cashierRepo.save(usr);
    }

    public List<users> findAllCashiers(){
        return cashierRepo.findAll();
    }

    public users updateCashiers(MultipartFile file, users usr, Date date_of_birth){
        // calculate age of cashier
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();
        // input date of birth
        birthDate.setTime(date_of_birth);
        System.out.println("Hii : " + date_of_birth);

        int age = 0;
        age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        System.out.println("Hii : " + age);
        
        // set type cashier
        user_type type = new user_type();
        type.setId(2);
        usr.setUser_type_id(type);

        usr.setDate_of_birth(date_of_birth);
        usr.setAge(age);
        
        try {
            usr.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (Exception e) {
            // TODO: handle exception
        }
        return cashierRepo.save(usr);
    }

    public users findCashiersById(Long id){
        return cashierRepo.findCashiersById(id).orElseThrow(() -> new DrinkNotFoundException("Drink by id " + id + " was not found."));
    }

    public void deleteCashiersById(Long id){
        cashierRepo.deleteCashiersById(id);
    }
}
