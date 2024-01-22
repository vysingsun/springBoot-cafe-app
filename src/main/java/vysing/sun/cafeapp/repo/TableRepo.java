package vysing.sun.cafeapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import vysing.sun.cafeapp.model.Tables_management;

public interface TableRepo extends JpaRepository<Tables_management, Long>{
    @Transactional
    void deleteTablesById(Long id);

    Optional<Tables_management> findTablesById(Long id);
}
