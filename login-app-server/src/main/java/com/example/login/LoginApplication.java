package com.example.login;

import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.example.login.model.Role;
import com.example.login.model.RoleName;
import com.example.login.repository.RoleRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EntityScan(basePackageClasses = { LoginApplication.class, Jsr310JpaConverters.class })
public class LoginApplication {

	@Autowired
	private RoleRepository roleRepository;

	@PostConstruct
	public void init() {
		Boolean userRoleExists = roleRepository.findByName(RoleName.ROLE_USER).isPresent();
		Boolean userAdminExists = roleRepository.findByName(RoleName.ROLE_ADMIN).isPresent();

		if (!userRoleExists) {
			Role r = new Role();
			r.setName(RoleName.ROLE_USER);
			roleRepository.save(r);
		}

		if (!userAdminExists) {
			Role r = new Role();
			r.setName(RoleName.ROLE_ADMIN);
			roleRepository.save(r);
		}

		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}
}
