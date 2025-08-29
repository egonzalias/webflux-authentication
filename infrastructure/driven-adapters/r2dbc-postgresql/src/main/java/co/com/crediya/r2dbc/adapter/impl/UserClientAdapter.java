package co.com.crediya.r2dbc.adapter.impl;

import co.com.crediya.model.user.AuthUser;
import co.com.crediya.model.user.AuthUserResponse;
import co.com.crediya.model.user.gateways.UserClient;
import co.com.crediya.r2dbc.config.GenericRestClient;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserClientAdapter implements UserClient {

    private final GenericRestClient restClient;
    private final ObjectMapper objectMapper;

    @Value("${services.user-ms.url}")
    private String userMsUrl;

    @Value("${services.user-ms.endpoints.find-by-email}")
    private String findByEmailPath;

    @Override
    public Mono<AuthUserResponse> authenticate(AuthUser authUser) {
        return restClient.post(userMsUrl+findByEmailPath, authUser, AuthUserResponse.class)
                .doOnNext(response ->
                    System.out.println("EGR:"+response)
                )
                .doOnError(error ->{
                    System.out.println("error:"+error.getMessage());
                });

        //return null;
    }

    /*public Mono<UserResponse> getUserByEmail(String email) {
        return restClient.get(userMsUrl + "/users/email/{email}", UserResponse.class, email);
    }*/
}
