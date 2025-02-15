package com.microservices.authentication.service.impl;

import com.microservices.authentication.common.enums.ApiStatus;
import com.microservices.authentication.dto.payload.request.*;
import com.microservices.authentication.dto.payload.response.ApiResponse;
import com.microservices.authentication.service.AuthService;
import com.microservices.authentication.util.MessageUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import java.sql.Timestamp;
import java.time.Instant;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final MessageUtil messageUtil;

    @Override
    public ApiResponse register(RegistrationRequest request, ServerWebExchange exchange) {
        return ApiResponse.builder()
                .timestamp(Timestamp.from(Instant.now()))
                .path(exchange.getRequest().getPath().toString())
                .status(ApiStatus.SUCCESS.getCode())
                .success(true)
                .message(messageUtil.getMessage(ApiStatus.SUCCESS.getMessageKey(),
                        exchange.getRequest().getPath().toString())
                ).build();
    }

    @Override
    public ApiResponse login(LoginRequest request, ServerWebExchange exchange) {
        return ApiResponse.builder()
                .timestamp(Timestamp.from(Instant.now()))
                .path(exchange.getRequest().getPath().toString())
                .status(ApiStatus.SUCCESS.getCode())
                .success(true)
                .message(messageUtil.getMessage(ApiStatus.SUCCESS.getMessageKey(),
                        exchange.getRequest().getPath().toString())
                ).build();
    }

    @Override
    public ApiResponse logout(ServerWebExchange exchange) {
        return ApiResponse.builder()
                .timestamp(Timestamp.from(Instant.now()))
                .path(exchange.getRequest().getPath().toString())
                .status(ApiStatus.SUCCESS.getCode())
                .success(true)
                .message(messageUtil.getMessage(ApiStatus.SUCCESS.getMessageKey(),
                        exchange.getRequest().getPath().toString())
                ).build();
    }

    @Override
    public ApiResponse resetPassword(String email, ServerWebExchange exchange) {
        return ApiResponse.builder()
                .timestamp(Timestamp.from(Instant.now()))
                .path(exchange.getRequest().getPath().toString())
                .status(ApiStatus.SUCCESS.getCode())
                .success(true)
                .message(messageUtil.getMessage(ApiStatus.SUCCESS.getMessageKey(),
                        exchange.getRequest().getPath().toString())
                ).build();
    }
}
