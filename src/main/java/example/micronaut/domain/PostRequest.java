package example.micronaut.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {

    @NotNull(message = "uno cannot be null")
    private String uno;

    private String dos;

}
