package co.com.crediya.api.mapper;

import co.com.crediya.api.dto.AuthUserDTO;
import co.com.crediya.model.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthUserDTOMapper {
    AuthUserDTO toResponse(User user);
    User toModel(AuthUserDTO authUserDTO);
}
