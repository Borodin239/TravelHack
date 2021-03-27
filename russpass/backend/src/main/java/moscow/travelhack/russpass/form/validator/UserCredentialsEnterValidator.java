package moscow.travelhack.russpass.form.validator;

import moscow.travelhack.russpass.form.UserCredentials;
import moscow.travelhack.russpass.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;

@Component
public class UserCredentialsEnterValidator implements Validator {
    private final UserService userService;

    public UserCredentialsEnterValidator(UserService userService) {
        this.userService = userService;
    }

    public boolean supports(@NotNull Class<?> clazz) {
        return UserCredentials.class.equals(clazz);
    }

    public void validate(@NotNull Object target, Errors errors) {
        if (!errors.hasErrors()) {
            UserCredentials enterForm = (UserCredentials) target;
            if (userService.findByLoginAndPassword(enterForm.getLogin(), enterForm.getPassword()) == null) {
                errors.rejectValue("password", "password.invalid-login-or-password", "Invalid login or password");
            }
        }
    }
}