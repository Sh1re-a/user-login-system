package se.shirwac.user.login.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.shirwac.user.login.system.test.selenium.SeleniumWebAutomation;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		SeleniumWebAutomation x = new SeleniumWebAutomation();
		x.runWebTest();
	}

}
