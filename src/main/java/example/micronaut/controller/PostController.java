package example.micronaut.controller;

import example.micronaut.domain.PostRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.validation.Validated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

@Secured("isAuthenticated()")
@Validated
@Controller("/")
public class PostController {

    private static final Logger LOG = LoggerFactory.getLogger(PostController.class);

    @Post("/numbers")
    String postIt(@Valid PostRequest request) {
        LOG.info("post request uno = {} dos = {}", request.getUno(), request.getDos());
        return "Good";
    }
}
