package example.micronaut;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "secured_api-v1",
                version = "0.0.1",
                description = "Example secured API using Micronaut"
        )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}