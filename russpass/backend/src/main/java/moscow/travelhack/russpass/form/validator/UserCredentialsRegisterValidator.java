package moscow.travelhack.russpass.form.validator;

import moscow.travelhack.russpass.form.RegisterRequest;
import moscow.travelhack.russpass.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;

@Component
public class UserCredentialsRegisterValidator implements Validator {
    private final UserService userService;

    public UserCredentialsRegisterValidator(UserService userService) {
        this.userService = userService;
    }

    public boolean supports(@NotNull Class<?> clazz) {
        return RegisterRequest.class.equals(clazz);
    }

    public void validate(@NotNull Object target, Errors errors) {
        if (!errors.hasErrors()) {
            RegisterRequest registerForm = (RegisterRequest) target;
            if (userService.exists(registerForm.getLogin())) {
                errors.rejectValue("login", "login.already-taken", "This login is already taken");
            }
        }
    }
}