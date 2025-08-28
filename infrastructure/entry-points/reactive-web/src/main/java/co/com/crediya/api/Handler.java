package co.com.crediya.api;


import co.com.crediya.api.dto.AuthUserDTO;
import co.com.crediya.api.mapper.AuthUserDTOMapper;
import co.com.crediya.model.exception.ValidationException;
import co.com.crediya.usecase.user.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
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

    private final UserUseCase userUseCase;
    private final AuthUserDTOMapper authUserDTOMapper;
    private final Validator validator;

    public Mono<ServerResponse> loginUser(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(AuthUserDTO.class)
                .doOnNext(this::validate)
                .map(authUserDTOMapper::toModel)
                .flatMap(userUseCase::authenticateUser)
                .then(ServerResponse.status(HttpStatus.CREATED).build());
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
