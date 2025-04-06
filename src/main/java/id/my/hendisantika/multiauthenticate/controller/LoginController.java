package id.my.hendisantika.multiauthenticate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : multi-authenticate
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 06/04/25
 * Time: 07.08
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @GetMapping
    public String loginPage() {
        log.info("Login page");
        return "login";
    }
}
