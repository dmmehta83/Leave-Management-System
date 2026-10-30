package com.leavemanagement.Leave.Management.system.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import io.jsonwebtoken.JwtException;

@Component
public class JwtAuthenticationFilter
        extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            CustomUserDetailsService userDetailsService) {

        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader =
                request.getHeader("Authorization");
        System.out.println("DEBUG Authorization header: " + (authHeader == null ? "MISSING" : "PRESENT"));

        if (authHeader == null ||
                !authHeader.startsWith("Bearer ")) {

            filterChain.doFilter(request, response);
            return;
        }

        final String jwt = authHeader.substring(7);
        

        try {

            final String username = jwtService.extractUsername(jwt);
            System.out.println("DEBUG Extracted JWT username: " + username);

            if (username != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails =
                        userDetailsService.loadUserByUsername(username);
                
                System.out.println(
                	    "DEBUG User authorities: " + userDetails.getAuthorities()
                	);

                if (jwtService.isTokenValid(jwt, userDetails)) {

                	System.out.println("DEBUG JWT is valid");
                	UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities()
                            );

                    SecurityContextHolder.getContext()
                            .setAuthentication(authenticationToken);
                    System.out.println(
                    	    "DEBUG Authentication set: " +
                    	    SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
                    	);
                    
                }
                else {
                    System.out.println("DEBUG JWT is invalid");
                }
            }

        } catch (JwtException | IllegalArgumentException e) {

            System.out.println(
                "DEBUG: JWT exception caught: "
                + e.getClass().getSimpleName()
            );

            SecurityContextHolder.clearContext();

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\"error\":\"Invalid or expired JWT\"}"
            );

            return;
        }
        System.out.println(
        	    "DEBUG Before continuing: " +
        	    SecurityContextHolder.getContext().getAuthentication().getName()
        	);
        filterChain.doFilter(request, response);

    }
  }
