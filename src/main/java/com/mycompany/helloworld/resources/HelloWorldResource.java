package com.mycompany.helloworld.resources;

import com.mycompany.helloworld.api.HelloWorld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String defaultMessage;
    private final AtomicLong counter;

    public HelloWorldResource(String defaultMessage) {
        this.defaultMessage = defaultMessage;
        this.counter = new AtomicLong();
    }

    @GET
    public HelloWorld sayHello() {
        return new HelloWorld(counter.incrementAndGet(), defaultMessage);
    }
}
