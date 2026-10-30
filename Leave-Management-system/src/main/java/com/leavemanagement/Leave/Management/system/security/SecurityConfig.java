package com.leavemanagement.Leave.Management.system.security;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.CommandLineRunner;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;

import com.leavemanagement.Leave.Management.system.entity.User;
import com.leavemanagement.Leave.Management.system.repository.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig {

	private final JwtAuthenticationFilter jwtAuthenticationFilter;

	private final CustomAuthenticationEntryPoint authenticationEntryPoint;
	public SecurityConfig(
	        JwtAuthenticationFilter jwtAuthenticationFilter,
	        CustomAuthenticationEntryPoint authenticationEntryPoint) {

	    this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	    this.authenticationEntryPoint = authenticationEntryPoint;
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    CommandLineRunner createTestUser(UserRepository userRepository,
                                      PasswordEncoder passwordEncoder) {
        return args -> {

            if (userRepository.findByUsername("darshan").isEmpty()) {

                User user = new User();

                user.setUsername("darshan");
                user.setPassword(passwordEncoder.encode("123456"));
                user.setRole("EMPLOYEE");

                userRepository.save(user);
            }
            if (userRepository.findByUsername("admin").isEmpty()) {

                User admin = new User();

                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole("ADMIN");

                userRepository.save(admin);
            }
        };
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    	http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session ->
            session.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS
            )
        )
        .exceptionHandling(exception -> exception
            .authenticationEntryPoint(authenticationEntryPoint)
        )
        .authorizeHttpRequests(auth -> auth
        	    .requestMatchers("/api/auth/**").permitAll()
        	    .requestMatchers("/api/departments/**").hasRole("ADMIN")
        	    .anyRequest().authenticated()
        	)
        

        .addFilterBefore(
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {

        return configuration.getAuthenticationManager();
    }
}