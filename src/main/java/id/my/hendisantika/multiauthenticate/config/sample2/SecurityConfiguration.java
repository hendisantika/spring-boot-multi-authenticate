package id.my.hendisantika.multiauthenticate.config.sample2;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Created by IntelliJ IDEA.
 * Project : multi-authenticate
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 06/04/25
 * Time: 07.37
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final ApiKeyAuthFilter authFilter;
    private final UnauthorizedHandler unauthorizedHandler;
}
