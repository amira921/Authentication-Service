package com.microservices.authentication.controller;

import com.microservices.authentication.dto.payload.response.ApiResponse;
import com.microservices.authentication.service.UserService;
import com.microservices.authentication.validation.ValidEmail;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public Mono<ResponseEntity<ApiResponse>> getAllUsers(ServerWebExchange exchange) {
        ApiResponse response = userService.getAllUsers(exchange);
        return Mono.just(ResponseEntity
                .status(response.getStatus())
                .body(response)
        );
    }

    @GetMapping("users/{email}")
    public Mono<ResponseEntity<ApiResponse>> getUser(@ValidEmail @PathVariable String email, ServerWebExchange exchange) {
        ApiResponse response = userService.getUser(email, exchange);
        return Mono.just(ResponseEntity
                .status(response.getStatus())
                .body(response)
        );
    }

    @GetMapping("/accounts/active")
    public Mono<ResponseEntity<ApiResponse>> getActivateAccounts(ServerWebExchange exchange) {
        ApiResponse response = userService.getActivateAccounts(exchange);
        return Mono.just(ResponseEntity
                .status(response.getStatus())
                .body(response)
        );
    }

    @GetMapping("/accounts/inactive")
    public Mono<ResponseEntity<ApiResponse>> getInactiveAccounts(ServerWebExchange exchange) {
        ApiResponse response = userService.getInactiveAccounts(exchange);
        return Mono.just(ResponseEntity
                .status(response.getStatus())
                .body(response)
        );
    }
}
