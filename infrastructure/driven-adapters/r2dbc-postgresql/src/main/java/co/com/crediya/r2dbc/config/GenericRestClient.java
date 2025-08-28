package co.com.crediya.r2dbc.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class GenericRestClient {

    private final WebClient webClient;

    public <T> Mono<T> get(String uri, Class<T> responseType, Object... uriVariables) {
        return webClient.get()
                .uri(uri, uriVariables)
                .retrieve()
                .bodyToMono(responseType);
    }

    public <T, R> Mono<R> post(String uri, T body, Class<R> responseType) {
        return webClient.post()
                .uri(uri)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(responseType);
    }

    public <T, R> Mono<R> put(String uri, T body, Class<R> responseType, Object... uriVariables) {
        return webClient.put()
                .uri(uri, uriVariables)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(responseType);
    }

    public Mono<Void> delete(String uri, Object... uriVariables) {
        return webClient.delete()
                .uri(uri, uriVariables)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
