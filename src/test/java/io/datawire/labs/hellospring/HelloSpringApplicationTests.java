package io.datawire.labs.hellospring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "BUILD_PROFILE=local")
class HelloSpringApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void homeReturnsGreetingWithLocalProfile() {
        ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).startsWith("Hello Naveen, Spring! (up ").endsWith(", local)");
    }

    @Test
    void helloReturnsExistingGreeting() {
        assertThat(restTemplate.getForObject("/hello", String.class))
                .isEqualTo("Hello Naveen, Am running fine No worries.. feature commit-2!!");
    }

    @Test
    void healthReportsUp() {
        ResponseEntity<String> response = restTemplate.getForEntity("/actuator/health", String.class);
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).contains("\"status\":\"UP\"");
    }
}
