package hasa.hafia.service;

import hasa.hafia.entites.Users;
import hasa.hafia.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class LoginService {
    private final UserRepository repository;

    public LoginService(UserRepository repository) {
        this.repository = repository;
    }

    public String login(String username, String password){
        //todo.....
        return "redirection selon le role de l'utilisateur";
    }

    public String logout() {
        //todo...
        return "redirection apres traitement du logout";
    }
}
