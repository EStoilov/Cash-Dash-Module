package com.fib.cashdashmodule.security;


import com.fib.cashdashmodule.appconfig.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ApiKeyValidationFilter implements Filter {

    @Value("${api.key}")
    private String validApiKey;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String apiKey = request.getHeader(Constants.API_KEY_HEADER);
        if (apiKey == null || !apiKey.equals(validApiKey)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(Constants.RESPONSE_MESSAGE_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(request, response);
    }
}
