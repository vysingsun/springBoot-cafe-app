package vysing.sun.cafeapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import vysing.sun.cafeapp.model.Drinks;

public interface DrinkRepo extends JpaRepository<Drinks, Long> {
    @Transactional
    void deleteDrinksById(Long id);

    Optional<Drinks> findDrinksById(Long id);
}