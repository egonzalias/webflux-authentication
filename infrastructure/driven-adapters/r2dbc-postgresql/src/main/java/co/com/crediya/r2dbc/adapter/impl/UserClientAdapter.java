package co.com.crediya.r2dbc.adapter.impl;

import co.com.crediya.r2dbc.config.GenericRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserClientAdapter {

    private final GenericRestClient restClient;

    @Value("${services.user-ms.url}")
    private String userMsUrl;

    @Value("${services.user-ms.endpoints.find-by-email}")
    private String findByEmailPath;

    /*public Mono<UserResponse> getUserByEmail(String email) {
        return restClient.get(userMsUrl + "/users/email/{email}", UserResponse.class, email);
    }*/
}
