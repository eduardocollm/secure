package example.micronaut.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Controller
@Secured("isAuthenticated()")
public class PingController {

    @Get("/ping")
    @Operation(description = "ping endpoint for health checks")
    @ApiResponse(description = "Success", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class)))
    public String ping(HttpRequest request) {
        return "ok";
    }
}
