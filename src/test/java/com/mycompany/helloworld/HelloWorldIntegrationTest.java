package com.mycompany.helloworld;

//import com.mycompany.helloworld.HelloWorldConfiguration;
//import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.*;
import io.dropwizard.testing.junit.DropwizardAppRule;
import io.dropwizard.testing.ResourceHelpers;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Client;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldIntegrationTest {

    @ClassRule
    public static final DropwizardAppRule<HelloWorldConfiguration> RULE =
            new DropwizardAppRule<HelloWorldConfiguration>(HelloWorldApplication.class, ResourceHelpers.resourceFilePath("config.yml"));

    @Test
    public void loginHandlerRedirectsAfterPost() {
        Client client = RULE.client();
        Response response = client.target(
                String.format("http://localhost:%d", RULE.getLocalPort()))
                .request().get();
        assertThat(response.getStatus()).isEqualTo(200);
    }
}