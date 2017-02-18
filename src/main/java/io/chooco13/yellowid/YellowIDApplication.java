package io.chooco13.yellowid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class YellowIDApplication {
    public static void main(String[] args) {
        SpringApplication.run(YellowIDApplication.class, args);
    }
}
