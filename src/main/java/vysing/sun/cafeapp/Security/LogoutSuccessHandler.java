// package vysing.sun.cafeapp.Security;

// import org.springframework.security.web.authentication.logout.LogoutHandler;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserCache;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// public class LogoutSuccessHandler implements LogoutHandler{
//     @Override
//     public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
//         SecurityContextHolder.clearContext();
//         try {
//             response.sendRedirect("/login");
//         } catch (Exception e) {
//             // TODO: handle exception
//             System.out.println(e.getMessage());
//         }
//     }
    
// }
