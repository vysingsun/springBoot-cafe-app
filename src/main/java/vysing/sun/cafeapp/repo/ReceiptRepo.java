package vysing.sun.cafeapp.repo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import vysing.sun.cafeapp.model.Receipt;

public interface ReceiptRepo extends JpaRepository<Receipt, Long>{
    Optional<Receipt> findReceiptById(Long id);
}
