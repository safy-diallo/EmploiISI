package hasa.hafia.controller;

import hasa.hafia.entites.Users;
import hasa.hafia.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String home(){
        //todo...
        return "views/users";
    }

    @PostMapping
    public String create(Users users){
        Users saved = service.create(users);
        //todo...
        return "views/users";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, Users users){
        Users updated = service.update(id, users);
        //todo...
        return "views/users";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id){
        Users found = service.findById(id);
        //todo...
        return "views/users";
    }

    @GetMapping("/list")
    public String getAll(){
        List<Users> users = service.getAll();
        //todo...
        return "views/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        //todo...
        return "views/users";
    }
}
