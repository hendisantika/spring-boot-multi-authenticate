package id.my.hendisantika.multiauthenticate.config.sample2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : multi-authenticate
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 06/04/25
 * Time: 07.36
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ApiKeyAuthExtractor {

    @Value("${application.security.api-key}")
    private String apiKey;
}
