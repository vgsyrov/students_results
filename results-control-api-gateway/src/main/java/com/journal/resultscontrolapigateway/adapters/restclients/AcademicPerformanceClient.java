package com.journal.resultscontrolapigateway.adapters.restclients;


import com.journal.resultscontrolapigateway.domain.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${ap.service.name}", url = "${ap.service.url}")
public interface AcademicPerformanceClient {

    @GetMapping("/list")
    List<Result> getResultList();

    @GetMapping("/findByPerson/{personId}")
    List<Result>  findResultByPersonId(@PathVariable String personId);

    @GetMapping("/findByLesson/{lessonId}")
    List<Result> findResultByLessonId(@PathVariable String lessonId);


}
