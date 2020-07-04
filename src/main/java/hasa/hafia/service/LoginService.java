package hasa.hafia.service;

import hasa.hafia.entites.LoginRequest;
import hasa.hafia.entites.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public Users login(LoginRequest request){
        Authentication authentication = new UsernamePasswordAuthenticationToken(request.getUsername(),
                request.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //todo.....
        UserDetails details = (UserDetails) authentication.getDetails();
        if (details != null)
            return new Users(details.getUsername(), details.getPassword());
        return new Users("absolument rien", "pas de mot de passe");
    }

    public String logout() {
        //todo...
        return "redirection apres traitement du logout";
    }
}
