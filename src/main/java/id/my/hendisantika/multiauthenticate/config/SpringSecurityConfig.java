package id.my.hendisantika.multiauthenticate.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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
 * Time: 07.05
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

    public final APIAuthenticationErrEntrypoint apiAuthenticationErrEntrypoint;

    @Value("${internal.api-key}")
    private String internalApiKey;

}
