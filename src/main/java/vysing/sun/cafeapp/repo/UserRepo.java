package vysing.sun.cafeapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vysing.sun.cafeapp.model.users;

@Repository
public interface UserRepo extends JpaRepository<users, Long> {
    users findByLogin(String login);

    
}
