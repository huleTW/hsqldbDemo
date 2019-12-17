package com.hule.springboot.flyway.flywaytest;

import com.intuit.karate.netty.FeatureServer;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class KarateNettyTest {

    @Autowired
    private UserClient userClient;

    private FeatureServer server;

    @Before
    public void setUp() throws Exception {
        File file = new File(getClass().getClassLoader().getResource("user-mock.feature").getFile());
        server = FeatureServer.start(file, 9009, false, new HashMap<>());
    }

    @Test
    public void test_payment() {
        User user = userClient.getUser("id");
        assertEquals(user.getId(), "id");
        assertEquals(user.getFirstName(), "hu");
        assertEquals(user.getLastName(), "le");
        assertEquals(user.getCareer(), "Engineer");
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }
}
