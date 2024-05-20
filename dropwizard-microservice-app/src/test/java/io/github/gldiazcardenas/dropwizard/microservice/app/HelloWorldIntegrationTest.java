package io.github.gldiazcardenas.dropwizard.microservice.app;

import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.github.gldiazcardenas.dropwizard.microservice.client.HelloWorldClient;
import io.github.gldiazcardenas.dropwizard.microservice.model.HelloWorld;
import jakarta.ws.rs.client.Client;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(DropwizardExtensionsSupport.class)
public class HelloWorldIntegrationTest {

    public static final DropwizardAppExtension<HelloWorldConfiguration> DROPWIZARD =
        new DropwizardAppExtension<>(HelloWorldApplication.class, "test-configuration.yml");

    @Test
    void testHelloWorld() {
        Client client = DROPWIZARD.client();

        HelloWorldClient proxy = WebResourceFactory.newResource(HelloWorldClient.class, client.target(String.format("http://localhost:%d", DROPWIZARD.getLocalPort())));

        HelloWorld helloWorld = proxy.greeting("Tester");

        assertThat(helloWorld).isNotNull();
        assertThat(helloWorld.getId()).isGreaterThan(0);
        assertThat(helloWorld.getContent()).isNotBlank();
        assertThat(helloWorld.getContent()).contains("Hello, Tester!");
    }

}
