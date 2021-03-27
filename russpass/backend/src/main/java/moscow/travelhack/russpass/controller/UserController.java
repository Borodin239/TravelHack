package moscow.travelhack.russpass.controller;

import moscow.travelhack.russpass.domain.User;
import moscow.travelhack.russpass.exceptions.ValidationException;
import moscow.travelhack.russpass.form.RegisterRequest;
import moscow.travelhack.russpass.form.validator.UserCredentialsRegisterValidator;
import moscow.travelhack.russpass.service.JwtService;
import moscow.travelhack.russpass.service.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    private final JwtService jwtService;
    private final UserService userService;
    private final UserCredentialsRegisterValidator validator;

    public UserController(JwtService jwtService, UserService userService,
                          UserCredentialsRegisterValidator validator) {
        this.jwtService = jwtService;
        this.userService = userService;
        this.validator = validator;
    }

    @InitBinder("registerRequest")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @GetMapping("/api/1/users/auth")
    public User findUserByJwt(@RequestParam String jwt) {
        return jwtService.find(jwt);
    }

    @GetMapping("api/1/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/api/1/users")
    public User register(@RequestBody @Valid RegisterRequest registerRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }
        return userService.register(registerRequest);
    }
}