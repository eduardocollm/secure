package example.micronaut.controller

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class PostControllerSpec extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    @Shared
    @AutoCleanup
    HttpClient client = embeddedServer.applicationContext.createBean(HttpClient, embeddedServer.getURL())

    def 'should throw a bad request exception'() {
        given:
        def httpRequest = HttpRequest.POST("/numbers", "{ \"dos\": \"hola\" }").basicAuth("sherlock", "password")

        when: 'making a call with an invalid request'
        client.toBlocking().retrieve(httpRequest)

        then: 'bad_request exception thrown'
        HttpClientResponseException e = thrown()
        HttpStatus.BAD_REQUEST == e.status
        'request.uno: uno cannot be null' == e.message

    }
}
