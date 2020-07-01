package hasa.hafia.service;

import hasa.hafia.entites.Users;
import hasa.hafia.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Users create(Users user){
        //todo...
        return repository.save(user);
    }

    @Transactional
    public Users update(Long id, Users user){
        Users existing = findById(id);
        //todo...
        return repository.save(existing);
    }

    public Users findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("ce utilisateur n'existe pas"));
    }

    public Users getByUsername(String username){
        return repository.getByUsername(username).orElseThrow(() -> new RuntimeException("ce nom d'utilisateur n'exsite pas"));
    }

    @Transactional
    public void delete(Long id){
        if (!repository.existsById(id))
            throw new RuntimeException("ce utilisateur n'existe pas");
        repository.deleteById(id);
    }

    public List<Users> getAll(){
        return repository.findAll();
    }
}
