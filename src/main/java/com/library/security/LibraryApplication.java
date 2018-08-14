package com.library.security;

import com.library.security.model.Role;
import com.library.security.model.Roles;
import com.library.security.model.Users;
import com.library.security.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LibraryApplication {

	@Autowired
	UsersRepository usersRepository;

	public static void main(String[] args) {

		SpringApplication.run(LibraryApplication.class, args);

	/*	Role adminrole = new Role();
		adminrole.setRole("ADMIN");
		usersRepository.save(adminrole);

		Role userrole = new Role();
		adminrole.setRole("USER");
		usersRepository.save(userrole);


		Users newUser = new Users();
		newUser.setName("Sucheta");
		newUser.setEmail("sucheta.dambalkar@gmail.com");
		newUser.setActive(1);
		newUser.setPassword("sucheta");
		Set roles = new HashSet();
		roles.add("ADMIN");
		//roles.add(Roles.ADMIN);
		newUser.setRoles(roles);
		usersRepository.save(newUser);
*/



	}
}
