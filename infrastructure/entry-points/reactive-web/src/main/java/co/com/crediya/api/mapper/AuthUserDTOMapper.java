package co.com.crediya.api.mapper;

import co.com.crediya.api.dto.AuthUserDTO;
import co.com.crediya.api.dto.AuthUserResponseDTO;
import co.com.crediya.model.user.AuthUser;
import co.com.crediya.model.user.AuthUserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthUserDTOMapper {
    AuthUserResponseDTO toResponse(AuthUserResponse authUserResponse);
    AuthUser toModel(AuthUserDTO authUserDTO);
}
