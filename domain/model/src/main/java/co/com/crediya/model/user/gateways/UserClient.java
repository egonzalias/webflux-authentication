package co.com.crediya.model.user.gateways;

import co.com.crediya.model.user.AuthUser;
import co.com.crediya.model.user.AuthUserResponse;
import reactor.core.publisher.Mono;

public interface UserClient {
    Mono<AuthUserResponse> authenticate(AuthUser authUser);
}
