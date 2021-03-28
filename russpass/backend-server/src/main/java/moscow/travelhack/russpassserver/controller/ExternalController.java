package moscow.travelhack.russpassserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequestMapping("/api")
@RestController
public class ExternalController {

    @GetMapping(value = "user_info")
    public String getUserInfo(Principal principal) {
        return principal.getName();
    }

}
