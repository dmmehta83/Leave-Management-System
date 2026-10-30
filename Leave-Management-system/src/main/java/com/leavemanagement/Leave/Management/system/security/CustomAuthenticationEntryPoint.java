package com.leavemanagement.Leave.Management.system.security;


import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationEntryPoint
        implements AuthenticationEntryPoint {

    @Override
    public void commence(
    		
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException)
            throws IOException {
    	System.out.println("DEBUG: CustomAuthenticationEntryPoint called");
    	System.out.println("DEBUG Request URI: " + request.getRequestURI());
    	System.out.println("DEBUG Failure reason: " + authException.getMessage());

        response.setStatus(
                HttpServletResponse.SC_UNAUTHORIZED
        );

        response.setContentType("application/json");

        response.getWriter().write(
                "{\"error\":\"Authentication required\"}"
        );
    }
}



