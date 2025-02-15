package com.microservices.authentication.service;

import com.microservices.authentication.dto.UserDTO;
import com.microservices.authentication.dto.payload.response.ApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import java.util.List;

@Service
public interface UserService {
    ApiResponse<List<UserDTO>>  getAllUsers(ServerWebExchange exchange);
    ApiResponse<UserDTO> getUser(String email, ServerWebExchange exchange);
    ApiResponse<List<UserDTO>>  getActivateAccounts(ServerWebExchange exchange);
    ApiResponse<List<UserDTO>>  getInactiveAccounts(ServerWebExchange exchange);
}
