package io.chooco13.yellowid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by chooco13 on 2016. 12. 17..
 */
@SpringBootApplication
@EnableAutoConfiguration
public class PikaSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(PikaSpringBootApplication.class, args);
    }
}
