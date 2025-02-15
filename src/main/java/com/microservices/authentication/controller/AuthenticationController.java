package com.microservices.authentication.controller;

import com.microservices.authentication.dto.payload.request.LoginRequest;
import com.microservices.authentication.dto.payload.request.RegistrationRequest;
import com.microservices.authentication.dto.payload.response.ApiResponse;
import com.microservices.authentication.service.AuthService;
import com.microservices.authentication.validation.ValidEmail;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/auth")
@AllArgsConstructor
public class AuthenticationController {
    private final AuthService authService;

    @PostMapping("/register")
    public Mono<ResponseEntity<ApiResponse>> register(@Valid @RequestBody RegistrationRequest request,
                                                      ServerWebExchange exchange) {
        return Mono.just(ResponseEntity
                .status(HttpStatus.OK.value())
                .body(authService.register(request, exchange))
        );
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<ApiResponse>> login(@Valid @RequestBody LoginRequest request,
                                                   ServerWebExchange exchange) {
        return Mono.just(ResponseEntity
                .status(HttpStatus.OK.value())
                .body(authService.login(request, exchange))
        );
    }

    @PostMapping("/logout")
    public Mono<ResponseEntity<ApiResponse>> logout(ServerWebExchange exchange) {
        return Mono.just(ResponseEntity
                .status(HttpStatus.OK.value())
                .body(authService.logout(exchange))
        );
    }

    @PostMapping("/reset-password/{email}")
    public Mono<ResponseEntity<ApiResponse>> resetPassword(@ValidEmail @PathVariable String email,
                                                           ServerWebExchange exchange) {
        return Mono.just(ResponseEntity
                .status(HttpStatus.OK.value())
                .body(authService.resetPassword(email, exchange))
        );
    }
}
