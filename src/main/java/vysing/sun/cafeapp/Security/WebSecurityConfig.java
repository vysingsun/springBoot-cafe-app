package vysing.sun.cafeapp.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  // private final CustomUserDetailsService uService;

  @Bean
  public UserDetailsService userDetailsService() {
    return new CustomUserDetailsService();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth -> auth
        .requestMatchers("/").permitAll()
        .requestMatchers("/admin/**").hasAnyAuthority("Admin")
        .requestMatchers("/cashier/**").hasAnyAuthority("Cashier")
        .anyRequest().authenticated());

    http.formLogin()
        .loginPage("/login")
        .usernameParameter("username")
        .successHandler(successHandler)
        .loginProcessingUrl("/login")
        .permitAll()
        .and()
        .logout().logoutUrl("/logout")
        .logoutSuccessUrl("/")
        .permitAll();
    return http.build();

  }

  @Autowired
  private LoginSuccessHandler successHandler;

}