package org.acme;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import javax.ws.rs.core.Response;


@Path("/hello")
public class GreetingResource {

    @Inject
    DemoProducer producer;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response hello(String message) {
        producer.sendMessageToKafka(message);
        return Response.accepted().build();
    }
}