package io.datawire.labs.hellospring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

    private final long start = System.currentTimeMillis();

    @Value("${BUILD_PROFILE:local}")
    private String buildProfile;

    @GetMapping("/")
    public String sayHello() {
        long millis = System.currentTimeMillis() - start;
        String uptime = String.format("%02d:%02d",
                                      TimeUnit.MILLISECONDS.toMinutes(millis),
                                      TimeUnit.MILLISECONDS.toSeconds(millis) -
                                      TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        return String.format("Hello Naveen, Spring! (up %s, %s)", uptime, buildProfile);
    }

    @GetMapping("/hello")
    public String sayHelloNaveen() {
        return String.format("Hello Naveen, Am running fine No worries.. feature commit-2!!");
    }
}
