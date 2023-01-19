package com.journal.resultscontrolapigateway.adapters.restclients;

import com.journal.resultscontrolapigateway.domain.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${pi.service.name}", url = "${pi.service.url}")
@EnableAsync
public interface PersonalInfoClient {

    @GetMapping("/find/{id}")
    Person findPersonById(@PathVariable String id);

    @GetMapping("/list")
    List<Person> getPersonalInfoNB();
}
