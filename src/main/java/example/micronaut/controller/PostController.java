package example.micronaut.controller;

import example.micronaut.domain.PostRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.annotation.Scheduled;
import io.micronaut.security.annotation.Secured;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

@Secured("isAuthenticated()")
@Validated
@Controller("/")
public class PostController {

    private static final Logger LOG = LoggerFactory.getLogger(PostController.class);

    /**
     *
     * @param request numbers
     * @return 'Good' if everything went well
     */
    @Post("/numbers")
    @Operation(summary = "returns request", description = "returns content of request body")
    @ApiResponse(responseCode = "200", description = "Ok",
            content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class)))
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    String postIt(@Valid PostRequest request) {
        LOG.info("post request uno = {} dos = {}", request.getUno(), request.getDos());
        return new StringBuilder("uno = [").append(request.getUno()).append("], dos = [").append(request.getDos()).append("]").toString();
    }
}
