package com.journal.personalinfosvc.personalinformation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableJpaRepositories
@SpringBootApplication
@RestController
public class PersonalInformationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalInformationApplication.class, args);
    }

    @GetMapping("/ping")
    public String sayHello(@RequestParam(value = "value", defaultValue = "ok") String name) {
        return String.format("PI return %s!", name);
    }

}
