package hasa.hafia;

import hasa.hafia.entites.Roles;
import hasa.hafia.entites.Users;
import hasa.hafia.repository.RoleRepository;
import hasa.hafia.repository.UserRepository;
import hasa.hafia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmploiIsiApplication implements CommandLineRunner {
	@Autowired private UserService userService;
	@Autowired private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmploiIsiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Users user = new Users();
		user.setNom("Diallo Boubacar");
		user.setUsername("bbtanou");
		user.setPassword("tanou");
		Roles role = new Roles();
		role.setLibelle("ROLE_DEMANDEUR");
		role.setUsers(user);
		user.getRoles().add(role);
		userService.create(user);

	}
}
