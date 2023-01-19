package com.journal.personalinfosvc.personalinformation.adapters.resapi;


import com.journal.personalinfosvc.personalinformation.domain.Person;
import com.journal.personalinfosvc.personalinformation.app.PersonService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class PersonController {

    final private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/list")
    public Iterable<Person> getPersonList() {
        return personService.getPersonList();
    }

    @GetMapping("/find/{personId}")
    public Person findPersonById(@PathVariable String personId) {
        return personService.findPersonById(personId);
    }

}
