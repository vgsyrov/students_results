package com.journal.resultscontrolapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@RestController
public class ResultsControlApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResultsControlApiGatewayApplication.class, args);
	}

	@GetMapping("/ping")
	public String ping(@RequestParam(value = "value", defaultValue = "ok") String name) {
		return String.format("API return %s!", name);
	}
}
