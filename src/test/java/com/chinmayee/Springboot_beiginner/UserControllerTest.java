package com.chinmayee.Springboot_beiginner;

import com.chinmayee.Springboot_beiginner.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldCreateUser_WhenPostJson() {
        User newUser = new User();
        newUser.setName("Alice");
        newUser.setGender("Female");
        newUser.setImage("/images/alice.png");

        ResponseEntity<User> response = restTemplate.postForEntity("/api/users", newUser, User.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(3);
        assertThat(response.getBody().getName()).isEqualTo("Alice");
        assertThat(response.getBody().getGender()).isEqualTo("Female");
        assertThat(response.getBody().getImage()).isEqualTo("/images/alice.png");
    }
}
