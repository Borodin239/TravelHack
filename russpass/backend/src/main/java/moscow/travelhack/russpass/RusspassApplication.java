package moscow.travelhack.russpass;

import moscow.travelhack.russpass.repository.AccountRepository;
import moscow.travelhack.russpass.resource.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import java.util.Optional;

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
		Optional<Account> temp = accountRepository.findByUsername("mail@yandex.ru");
		temp.ifPresent(account -> System.out.println(account.getName()));
		System.out.println("Working...");
	}
}
