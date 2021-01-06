package com.mycompany.helloworld;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.helloworld.api.HelloWorld;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        final HelloWorld message = new HelloWorld(1, "Hello World!");
        assertThat(MAPPER.writeValueAsString(message))
                .isEqualTo(fixture("fixtures/helloworld.json"));
    }
}