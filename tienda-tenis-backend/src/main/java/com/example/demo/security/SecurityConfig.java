package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	   @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .csrf().disable() // Deshabilitar CSRF si estás trabajando con APIs
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(
            		"/api/productos/ver_todos",
            		"/api/productos/buscar",
            		"/api/usuarios/guardar"
            		).permitAll()
            .anyRequest().authenticated()
        )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID") // Elimina la cookie de sesión al cerrar sesión
                .permitAll() // Permitir acceso al endpoint de logout sin autenticación
            ).httpBasic();
        return http.build();
    }

}
