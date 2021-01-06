package com.mycompany.helloworld.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorld {
    private long id;
    private String content;

    public HelloWorld(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
