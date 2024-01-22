package vysing.sun.cafeapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import vysing.sun.cafeapp.model.Invoices;
public interface InvoiceRepo extends JpaRepository<Invoices , Long>{

}
