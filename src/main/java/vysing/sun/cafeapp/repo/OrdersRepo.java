package vysing.sun.cafeapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import vysing.sun.cafeapp.model.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Long>{
    @Transactional
    void deleteOrdersById(Long id);

    Optional<Orders> findOrdersById(Long id);

    // vysing.sun.cafeapp.service.Orders save(vysing.sun.cafeapp.service.Orders orders);
}
