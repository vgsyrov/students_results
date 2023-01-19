package com.journal.personalinfosvc.personalinformation;


import com.journal.personalinfosvc.personalinformation.domain.Person;
import com.journal.personalinfosvc.personalinformation.adapters.database.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class PersonalInformationApplicationTests {

    @Autowired
    private PersonRepository repository;

    @Test
    public void testGetByIdFromDb() {
        repository.save(new Person("id", "do"));
        Person person = repository.findPersonByPersonId("id");
        assertThat(person.getPersonId()).isEqualTo("id");
    }

    @Test
    public void findByUsernameWhenNoUserShouldReturnNull() throws Exception {
        this.repository.save(new Person("personId_1","donald"));
        Person user = this.repository.findPersonByPersonId("fakeUser");
        assertThat(user).isNull();
    }
}
