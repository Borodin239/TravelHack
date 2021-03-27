package moscow.travelhack.russpass;

import moscow.travelhack.russpass.repository.AccountRepository;
import moscow.travelhack.russpass.resource.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAuthorizationServer

public class RusspassApplication implements CommandLineRunner {
	public static void main(String[] args) {

		SpringApplication.run(RusspassApplication.class, args);
	}

	@Autowired
	AccountRepository accountRepository;

	@Override
	public void run(String... args) throws Exception {
		accountRepository.deleteAll();
		accountRepository.save(new Account("den", "123"));

		System.out.println("Working...");
	}
}
