
package TravelGuide.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(
                                "/", "/access-denied",
                                "/css/**", "/js/**", "/images/**"
                        ).permitAll()

                        .requestMatchers(HttpMethod.GET,
                                "/orase", "/categorii", "/atractii",
                                "/transporturi", "/trasee", "/recenzii"
                        ).permitAll()

                        .requestMatchers("/cont").hasRole("USER")

                        .requestMatchers(
                                "/administrare",
                                "/orase", "/orase/**",
                                "/categorii", "/categorii/**",
                                "/transporturi", "/transporturi/**",
                                "/atractii", "/atractii/**",
                                "/trasee", "/trasee/**",
                                "/asocieri", "/asocieri/**",
                                "/utilizatori", "/utilizatori/**"
                        ).hasRole("ADMIN")

                        .requestMatchers(
                                "/recenzii/editeaza/**",
                                "/recenzii/sterge/**"
                        ).hasRole("ADMIN")

                        .requestMatchers("/recenzii/**")
                        .hasAnyRole("USER", "ADMIN")

                        .anyRequest().authenticated()
                )

                .formLogin(Customizer.withDefaults())

                .exceptionHandling(exception ->
                        exception.accessDeniedPage("/access-denied")
                )

                .logout(logout ->
                        logout.logoutSuccessUrl("/")
                );

        return http.build();
    }
}
