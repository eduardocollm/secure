package example.micronaut.security

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class BasicAuthSpec extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    @Shared
    @AutoCleanup
    RxHttpClient client = embeddedServer.applicationContext.createBean(RxHttpClient, embeddedServer.getURL())

    def "basic auth should work"() {
        when: 'accessing a secured URL without authenticating should fail'
        client.toBlocking().exchange(HttpRequest.GET('/'))
        then: 'returns unauthorized error'
        HttpClientResponseException e = thrown(HttpClientResponseException)
        HttpStatus.UNAUTHORIZED == e.status

        when: 'accessing secured URL with basic auth should work'
        HttpRequest request = HttpRequest.GET('/').basicAuth("sherlock", 'password')
        HttpResponse<String> resp = client.toBlocking().exchange(request, String)
        then: 'access is granted'
        resp.status == HttpStatus.OK
        resp.body() == 'sherlock'
    }

}
