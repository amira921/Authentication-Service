package com.microservices.authentication.dto;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class UserDTO {
    private String email;
    private String password;
    private String username;
    private Date createdAt;
    private boolean activationEmailSent;
    private boolean accountActive;
}
