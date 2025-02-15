package com.microservices.authentication.service;


import com.microservices.authentication.dto.payload.request.LoginRequest;
import com.microservices.authentication.dto.payload.request.RegistrationRequest;
import com.microservices.authentication.dto.payload.response.ApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;

@Service
public interface AuthService {
    ApiResponse register(RegistrationRequest request, ServerWebExchange exchange);
    ApiResponse login(LoginRequest request, ServerWebExchange exchange);
    ApiResponse logout(ServerWebExchange exchange);
    ApiResponse resetPassword(String email, ServerWebExchange exchange);
}
