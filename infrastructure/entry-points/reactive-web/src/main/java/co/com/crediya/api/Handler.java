package co.com.crediya.api;


import co.com.crediya.api.dto.AuthUserDTO;
import co.com.crediya.api.mapper.AuthUserDTOMapper;
import co.com.crediya.model.exception.ValidationException;
import co.com.crediya.usecase.user.AuthUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Handler {

    private final AuthUserUseCase authUserUseCase;
    private final AuthUserDTOMapper authUserDTOMapper;
    private final Validator validator;

    public Mono<ServerResponse> authenticate(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(AuthUserDTO.class)
                .doOnNext(this::validate)
                .map(authUserDTOMapper::toModel)
                .flatMap(authUserUseCase::authenticateUser)
                .map(authUserDTOMapper::toResponse)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    private void validate(AuthUserDTO authUserDTO) {
        BindingResult errors = new BeanPropertyBindingResult(authUserDTO, AuthUserDTO.class.getName());
        validator.validate(authUserDTO, errors);
        if (errors.hasErrors()) {
            List<String> messages = errors.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            throw new ValidationException(messages);
        }
    }
}
