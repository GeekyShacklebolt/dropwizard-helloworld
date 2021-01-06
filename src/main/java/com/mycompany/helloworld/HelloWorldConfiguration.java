package com.mycompany.helloworld;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class HelloWorldConfiguration extends Configuration {
    @NotEmpty
    private String defaultMessage = "Hello World!";

    @JsonProperty
    public String getDefaultMessage() {
        return defaultMessage;
    }

    @JsonProperty
    public void setDefaultMessage(String message) {
        this.defaultMessage = message;
    }
}
