package co.com.crediya.model.user;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AuthUserResponse {
    private String jwtToken;
    private Instant expiresAt;
    private String email;
    private String password;
    private String role;
}
