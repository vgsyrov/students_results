package com.journal.schedulecalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableJpaRepositories
@SpringBootApplication
@RestController
public class SchedulecalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulecalendarApplication.class, args);
    }

    @GetMapping("/ping")
    public String sayHello(@RequestParam(value = "value", defaultValue = "ok") String name) {

        return String.format("SC return %s!", name);
    }


}
