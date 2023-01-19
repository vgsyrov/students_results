package com.journal.academicperformance.adapters.restapi;

import com.journal.academicperformance.app.ResultService;
import com.journal.academicperformance.domain.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/list")
    public Iterable<Result> getResultList() {
        return resultService.findAll();
    }

    @GetMapping("/findByPerson/{perosnId}")
    public Iterable<Result> findResultByPersonId(@PathVariable String perosnId) {
        return resultService.findResultsByPersonId(perosnId);
    }

    @GetMapping("/findByLesson/{id}")
    public Iterable<Result> findResultByLessonId(@PathVariable String id) {
        return resultService.findResultsByLessonId(id);
    }


}
