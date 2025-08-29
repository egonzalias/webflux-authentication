package co.com.crediya.model.user.gateways;

import co.com.crediya.model.user.AuthUser;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<Void> authenticateUser(AuthUser authUser);
}
