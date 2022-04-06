package ntnu.idatt2105.backend.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SessionAuthExceptionEntryPoint sessionAuthExceptionEntryPoint;

    @Autowired
    private SessionAuthRequestFilter sessionAuthRequestFilter;

    static CorsConfiguration corsConfiguration(HttpServletRequest request) {
        CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowedOrigins(List.of("*"));
        cors.setAllowedMethods(List.of("GET", "POST", "PUT", "OPTIONS"));
        cors.setAllowedHeaders(List.of("*"));
        return cors;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource(SecurityConfig::corsConfiguration).and()
                .csrf().disable()
                .authorizeRequests().antMatchers("/session/**").permitAll()
                .antMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .anyRequest().authenticated().and()
                .exceptionHandling().authenticationEntryPoint(sessionAuthExceptionEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

        http.addFilterBefore(sessionAuthRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
