package example.micronaut.client

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class AppClientSpec extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    def "verify basic auth works"() {
        when:
        AppClient client = embeddedServer.applicationContext.getBean(AppClient)
        then:
        noExceptionThrown()

        when:
        String encodedCreds = "sherlock:password".bytes.encodeBase64().toString()
        String resp = client.home("Basic ${encodedCreds}")
        then:
        resp == "sherlock"
    }
}
