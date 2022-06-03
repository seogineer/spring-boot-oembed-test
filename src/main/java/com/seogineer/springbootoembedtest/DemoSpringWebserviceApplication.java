package com.seogineer.springbootoembedtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DemoSpringWebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringWebserviceApplication.class, args);
    }

}
