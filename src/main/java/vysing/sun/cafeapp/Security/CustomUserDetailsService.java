package vysing.sun.cafeapp.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import vysing.sun.cafeapp.model.users;
import vysing.sun.cafeapp.repo.UserRepo;

public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepo empRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println(username);
    users emp = empRepo.findByLogin(username);
    if (emp == null) {
      throw new UsernameNotFoundException("No user found for the given username");
    }
    return new CustomUserDetails(emp);
  }

}
