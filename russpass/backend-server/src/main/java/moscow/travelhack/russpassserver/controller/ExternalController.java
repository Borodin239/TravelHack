package moscow.travelhack.russpassserver.controller;

import moscow.travelhack.russpassserver.repository.AccountRepository;
import moscow.travelhack.russpassserver.resource.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class ExternalController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping(value = "user_info")
    public Account getUserInfo(Principal principal) {
        Optional<Account> temp = accountRepository.findByUsername(principal.getName());
        return temp.orElse(null);
    }

}
