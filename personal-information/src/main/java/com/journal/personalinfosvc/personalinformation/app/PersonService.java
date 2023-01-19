package com.journal.personalinfosvc.personalinformation.app;

import com.journal.personalinfosvc.personalinformation.domain.Person;
import com.journal.personalinfosvc.personalinformation.adapters.database.PersonRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Iterable<Person> getPersonList() {
        return personRepository.findAll();
    }

    public Person findPersonById(@PathVariable String id) {
        return personRepository.findPersonByPersonId(id);
    }
}
