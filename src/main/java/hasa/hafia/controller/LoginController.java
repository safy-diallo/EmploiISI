package hasa.hafia.controller;

import hasa.hafia.entites.LoginRequest;
import hasa.hafia.entites.Users;
import hasa.hafia.service.LoginService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private final LoginService service;
    private static final String DEFAULT_VIEW = "views/login/";

    public LoginController(LoginService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String index(Model model){
        model.addAttribute("request", new LoginRequest());
        return DEFAULT_VIEW.concat("login");
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("request") LoginRequest request, Model model){
        Users users = service.login(request);
        model.addAttribute("user", users);
        // naviguer selon le role
        return "index";
    }

    @GetMapping("/logout")
    public String logout(){
        return service.logout();
    }
}
