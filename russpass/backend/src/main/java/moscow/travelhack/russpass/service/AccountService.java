package moscow.travelhack.russpass.service;

import moscow.travelhack.russpass.repository.AccountRepository;
import moscow.travelhack.russpass.resource.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    Optional<Account> find(final String name) {
        return accountRepository.findByUsername(name);
    }
}
