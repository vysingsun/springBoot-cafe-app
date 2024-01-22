package vysing.sun.cafeapp.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

// import vysing.sun.cafeapp.model.Cashiers;
import vysing.sun.cafeapp.model.users;
public interface CashierRepo extends JpaRepository<users, Long>{
    @Transactional
    void deleteCashiersById(Long id);

    Optional<users> findCashiersById(Long id);
}
