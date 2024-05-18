package io.github.gldiazcardenas.dropwizard.microservice.client;

import io.github.gldiazcardenas.dropwizard.microservice.model.HelloWorld;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

/**
 * @author gldiazcardenas, 18/05/24.
 */
@Path("/hello-world")
public interface HelloWorldClient {

    @GET
    HelloWorld greeting(@QueryParam("name") String name);

}
