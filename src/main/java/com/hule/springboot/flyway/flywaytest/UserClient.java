package com.hule.springboot.flyway.flywaytest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {

    private String url;

    @Autowired
    public UserClient(@Value("${client.url: http://localhost}") String url) {
        this.url = url;
    }

    public User getUser(String id) {
        return new RestTemplate().getForObject(url, User.class);
    }
}
