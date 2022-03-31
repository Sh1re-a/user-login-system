package se.shirwac.user.login.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.shirwac.user.login.system.webtest.WebTest;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		WebTest x = new WebTest();
		x.runWebTest();
	}

}
