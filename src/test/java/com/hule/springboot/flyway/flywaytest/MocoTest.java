package com.hule.springboot.flyway.flywaytest;

import com.github.dreamhead.moco.junit.MocoJunitRunner;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class MocoTest {
    @Autowired
    private UserClient userClient;

    @Rule
    public MocoJunitRunner runner = MocoJunitRunner.jsonRestRunner(9009, getClass().getClassLoader().getResource("user-mock.json").getFile());

    @Test
    public void test_user() {
        User user = userClient.getUser("id");
        assertEquals(user.getId(), "id");
        assertEquals(user.getFirstName(), "hu");
        assertEquals(user.getLastName(), "le");
        assertEquals(user.getCareer(), "Engineer");
    }
}
