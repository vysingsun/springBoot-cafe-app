package vysing.sun.cafeapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import vysing.sun.cafeapp.model.Foods;

public interface FoodRepo extends JpaRepository<Foods, Long>{
    @Transactional
    void deleteFoodsById(Long id);

    Optional<Foods> findFoodsById(Long id);
    
}
