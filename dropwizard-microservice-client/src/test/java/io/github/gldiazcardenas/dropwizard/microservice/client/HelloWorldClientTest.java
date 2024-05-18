package io.github.gldiazcardenas.dropwizard.microservice.client;

import com.fasterxml.jackson.core.util.JacksonFeature;
import io.github.gldiazcardenas.dropwizard.microservice.model.HelloWorld;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;

/**
 * @author gldiazcardenas, 18/05/24.
 */
public class HelloWorldClientTest {

    public static void main(String[] arg) {
        ClientConfig cc = new ClientConfig().register(JacksonFeature.class);
        Client resource = ClientBuilder.newClient(cc);
        HelloWorldClient proxy = WebResourceFactory.newResource(HelloWorldClient.class, resource.target("http://localhost:8080"));
        HelloWorld greeting = proxy.greeting("Gabriel Diaz Cardenas");
        System.out.println(greeting.getContent());
    }

}
