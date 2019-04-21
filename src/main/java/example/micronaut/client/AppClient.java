package example.micronaut.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;

@Client("/")
public interface AppClient {

    @Get("/ping")
    String home(@Header String authorization);
}
