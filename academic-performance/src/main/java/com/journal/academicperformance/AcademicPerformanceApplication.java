package com.journal.academicperformance;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableJpaRepositories
@RestController
@SpringBootApplication
@EnableRabbit
public class AcademicPerformanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademicPerformanceApplication.class, args);
	}

	@GetMapping("/ping")
	public String sayHello(@RequestParam(value = "value", defaultValue = "ok") String name) {
		return String.format("AP return %s!", name);
	}

}
