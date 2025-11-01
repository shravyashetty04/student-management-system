
package com.example.studentmanagementsystem.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // Allow access to the login page and static resources (CSS, JS)
                        .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                        // Secure all other requests
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        // Use this as the URL for our custom login page
                        .loginPage("/login")
                        // This is the URL the form will POST to for processing
                        .loginProcessingUrl("/login")
                        // On successful login, redirect to "/welcome"
                        .defaultSuccessUrl("/welcome", true)
                        // On failed login, redirect back to "/login?error=true"
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        // Configure logout URL
                        .logoutUrl("/logout")
                        // On successful logout, redirect to "/login?logout=true"
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                );

        return http.build();
    }
}