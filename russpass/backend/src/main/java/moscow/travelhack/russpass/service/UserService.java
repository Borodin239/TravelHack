package moscow.travelhack.russpass.service;

import moscow.travelhack.russpass.domain.User;
import moscow.travelhack.russpass.form.RegisterRequest;
import moscow.travelhack.russpass.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByLoginAndPassword(String login, String password) {
        return login == null || password == null ? null : userRepository.findByLoginAndPassword(login, password);
    }

    public User findById(Long id) {
        return id == null ? null : userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAllByOrderByIdDesc();
    }

    public Boolean exists(String login) {
        return userRepository.existsByLogin(login);
    }

    public User register(RegisterRequest registerRequest) {
        User user = new User();
        user.setLogin(registerRequest.getLogin());
        user.setName(registerRequest.getName());
        user.setAdmin(false);
        userRepository.save(user);
        userRepository.updatePasswordSha(user.getId(), user.getLogin(), registerRequest.getPassword());
        return user;
    }
}