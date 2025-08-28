package co.com.crediya.api.dto;

import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AuthUserDTO {

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico no es válido", regexp = ".+@.+\\..+")
    private String email;
    @NotBlank(message = "La clave del usuario del usuario obligatoria")
    private String password;
}
