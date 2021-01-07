package com.mycompany.helloworld;

import org.junit.*;
import io.dropwizard.testing.junit.DropwizardAppRule;
import io.dropwizard.testing.ResourceHelpers;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Client;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldIntegrationTest {

    @ClassRule
    public static final DropwizardAppRule<HelloWorldConfiguration> RULE =
            new DropwizardAppRule<HelloWorldConfiguration>(HelloWorldApplication.class, ResourceHelpers.resourceFilePath("config.yml"));

    @Test
    public void TestGetRequestOnHomeURL() {
        Client client = RULE.client();
        Response response = client.target(
                String.format("http://localhost:%d", RULE.getLocalPort()))
                .request().get();
        assertThat(response.getStatus()).isEqualTo(200);
        Map data = response.readEntity(Map.class);
        assertThat(data.get("id")).isEqualTo(1);
        assertThat((data.get("content"))).isEqualTo("Hello World!");
    }

}