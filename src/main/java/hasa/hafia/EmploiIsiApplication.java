package hasa.hafia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import hasa.hafia.dao.IRoles;
import hasa.hafia.dao.IUsers;
import hasa.hafia.entites.Roles;
import hasa.hafia.entites.Users;

@SpringBootApplication
public class EmploiIsiApplication implements CommandLineRunner {

	@Autowired 
	private IUsers userdao;
	@Autowired
	private IRoles roledao;
	public static void main(String[] args) {
		SpringApplication.run(EmploiIsiApplication.class, args);			
	}
	@Override
	public void run(String... args) throws Exception {
		//Roles 1
		Roles roles1 = new Roles();
		roles1.setLibelle("ROLE_DEMANDEUR");
		roledao.save(roles1);
		//Roles 2
		Roles roles2 = new Roles();
		roles2.setLibelle("ROLE_RECRUTEUR");
		roledao.save(roles2);

		//Liste 1 de roles
		List<Roles> rolesList1 = new ArrayList<>();
		rolesList1.add(roles1);
		rolesList1.add(roles2);
		//Liste 2 de roles
		List<Roles> rolesList2 = new ArrayList<>();
		rolesList2.add(roles1);

		// Utilisateur
		Users user = new Users();
		user.setNom("Diallo");
		user.setPrenom("Safi");
		
		user.setEmail("safi@gmail.com");
		//crypt password
		String password = "diallo";
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//String hashedPassword = passwordEncoder.encode(password);
		//user.setPassword(hashedPassword);
		user.setPassword(password);
		user.setEtat(1);
		user.setRoles(rolesList1);
		userdao.save(user);

		// User 2
		Users users= new Users();
		users.setNom("Bah");
		users.setPrenom("Oumou");
		
		users.setEmail("oumou@gmal.com");
		//cryp password
		String pwd = "oumou123";
		//BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		//String hashedPwd = pwdEncoder.encode(pwd);
		//users.setPassword(hashedPwd);
		user.setPassword(pwd);
		users.setEtat(1);
		users.setRoles(rolesList2);
		userdao.save(users);


		List<Users> utilisateur =  userdao.findAll();

		utilisateur.forEach(p->{
			System.out.println(p.getPrenom() + "  " + p.getNom());
		});
	}
}
