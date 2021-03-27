package moscow.travelhack.russpass.resource;

import org.springframework.stereotype.Controller;
import org.springframework.security.core.userdetails.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class RestResource {
    public ResponseEntity<UserProfile> profile()
    {
        //Build some dummy data to return for testing
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername() + "@howtodoinjava.com";

        UserProfile profile = new UserProfile();
        profile.setName(user.getUsername());
        profile.setEmail(email);

        return ResponseEntity.ok(profile);
    }
}
