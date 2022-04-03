package se.shirwac.user.login.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;


@SpringBootApplication
@EntityScan(basePackages = "se.shirwac.user.login.system.*")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
