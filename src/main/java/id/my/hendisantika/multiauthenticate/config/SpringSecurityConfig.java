package id.my.hendisantika.multiauthenticate.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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

    @Bean
    @Order(1)
    public SecurityFilterChain filterChainPrivate(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/api/internal/**")
                .addFilterBefore(new InternalApiKeyAuthenticationFilter(internalApiKey), ChannelProcessingFilter.class)
                .exceptionHandling((auth) -> {
                    auth.authenticationEntryPoint(apiAuthenticationErrEntrypoint);
                })
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain filterChainWebApplication(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz -> authz
                .requestMatchers("/login").permitAll()
                .requestMatchers("/**").authenticated()
                .anyRequest().authenticated()
        );

        http.formLogin(authz -> authz
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/login")
        );

        http.logout(authz -> authz
                .deleteCookies("JSESSIONID")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        );

        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

}
