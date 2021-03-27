package moscow.travelhack.russpass.resource;

import moscow.travelhack.russpass.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Struct;

@Service
public class CustomUserDetails implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository.findByUsername(username)
                .map(account -> new User(account.getUsername(),
                        passwordEncoder.encode(account.getPassword()),
                        true,
                        true,
                        true,
                        true,
                        AuthorityUtils.createAuthorityList("write", "read")))
                .orElseThrow(() -> new UsernameNotFoundException("not found"));
    }

}
