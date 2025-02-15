package com.microservices.authentication.dto.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationRequest {
    @Pattern(regexp = "^(?=.*@)(?=.*\\.)[A-Za-z0-9._%+-]{12,}@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Please enter a valid e-mail address")
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!_-])(?=\\S+$).{8,}$",
            message = "Password must not be empty and must contain at least one digit, one lowercase letter, one uppercase letter, " +
                    "one special character, and be at least 8 characters long")
    private String password;

    @NotBlank(message = "Please enter a valid username")
    private String username;
}
