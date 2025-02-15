package com.microservices.authentication.service.impl;

import com.microservices.authentication.common.enums.ApiStatus;
import com.microservices.authentication.dto.UserDTO;
import com.microservices.authentication.dto.payload.response.ApiResponse;
import com.microservices.authentication.service.UserService;
import com.microservices.authentication.util.MessageUtil;
import com.microservices.authentication.validation.ValidEmail;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final MessageUtil messageUtil;

    @Override
    public ApiResponse<List<UserDTO>> getAllUsers(ServerWebExchange exchange) {
        return ApiResponse.<List<UserDTO>>builder()
                .timestamp(Timestamp.from(Instant.now()))
                .path(exchange.getRequest().getPath().toString())
                .status(ApiStatus.SUCCESS.getCode())
                .success(true)
                .message(messageUtil.getMessage(ApiStatus.SUCCESS.getMessageKey(),
                        exchange.getRequest().getPath().toString())
                ).data(new ArrayList<UserDTO>())
                .build();
    }

    @Override
    public ApiResponse<UserDTO> getUser(@ValidEmail String email, ServerWebExchange exchange) {
        return ApiResponse.<UserDTO>builder()
                .timestamp(Timestamp.from(Instant.now()))
                .path(exchange.getRequest().getPath().toString())
                .status(ApiStatus.SUCCESS.getCode())
                .success(true)
                .message(messageUtil.getMessage(ApiStatus.SUCCESS.getMessageKey(),
                        exchange.getRequest().getPath().toString())
                ).data(UserDTO.builder().build())
                .build();
    }

    @Override
    public ApiResponse<List<UserDTO>> getActivateAccounts(ServerWebExchange exchange) {
        return ApiResponse.<List<UserDTO>>builder()
                .timestamp(Timestamp.from(Instant.now()))
                .path(exchange.getRequest().getPath().toString())
                .status(ApiStatus.SUCCESS.getCode())
                .success(true)
                .message(messageUtil.getMessage(ApiStatus.SUCCESS.getMessageKey(),
                        exchange.getRequest().getPath().toString())
                ).data(new ArrayList<UserDTO>())
                .build();
    }

    @Override
    public ApiResponse<List<UserDTO>> getInactiveAccounts(ServerWebExchange exchange) {
        return ApiResponse.<List<UserDTO>>builder()
                .timestamp(Timestamp.from(Instant.now()))
                .path(exchange.getRequest().getPath().toString())
                .status(ApiStatus.SUCCESS.getCode())
                .success(true)
                .message(messageUtil.getMessage(ApiStatus.SUCCESS.getMessageKey(),
                        exchange.getRequest().getPath().toString())
                ).data(new ArrayList<UserDTO>())
                .build();
    }
}
