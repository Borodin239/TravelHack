package moscow.travelhack.russpassserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/public")
    public String publicHello() {
        return "public";
    }

    @GetMapping(value = "/private")
    public String privateHello() {
        return "private";
    }

}
