package vysing.sun.cafeapp.Security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// import cafe.shop.testing.cafe.shop.entities.Employee;
import vysing.sun.cafeapp.model.users;

public class CustomUserDetails implements UserDetails {
  private users usr;

  public CustomUserDetails(users usr) {
  this.usr = usr;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // Set<Role> roles = user.getRoles();
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(usr.getUser_type_id().getType()));
    return authorities;
  }

  public boolean hasRole(String roleName) {
    return this.usr.hasRole(roleName);
  }

  @Override
  public String getPassword() {
    return usr.getPassword();
  }

  @Override
  public String getUsername() {
    return usr.getLogin();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
