package co.com.crediya.api.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AuthUserResponseDTO {
    private String jwtToken;
    private Instant expiresAt;
    private String email;
    private String password;
    private String role;
}
