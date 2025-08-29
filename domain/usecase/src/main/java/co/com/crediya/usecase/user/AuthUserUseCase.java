package co.com.crediya.usecase.user;

import co.com.crediya.model.user.AuthUser;
import co.com.crediya.model.user.AuthUserResponse;
import co.com.crediya.model.user.gateways.PasswordService;
import co.com.crediya.model.user.gateways.UserClient;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AuthUserUseCase {

    //private final UserRepository repository;
    private final PasswordService passwordService;
    private final UserClient userClient;

    public Mono<AuthUserResponse> authenticateUser(AuthUser authUser){
        return userClient.authenticate(authUser);
    }
}
