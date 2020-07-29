package hasa.hafia.controller;

import hasa.hafia.entites.LoginRequest;
import hasa.hafia.entites.Users;
import hasa.hafia.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class Home {
    @Autowired LoginService service;

    @GetMapping
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()){
            UserDetails details = (UserDetails) authentication.getPrincipal();
            if (details != null) {
                Users users = new Users(details.getUsername(), details.getPassword());
                model.addAttribute("user", users);
                return "index";
            }
        }
        System.out.println("No am not authenticated");
        model.addAttribute("request", new LoginRequest());
        return "views/login/login";
    }
}
