package com.journal.personalinfosvc.personalinformation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @Column(name = "PERSONID", nullable = false)
    private String personId;

    @Column(name = "FULLNAME", nullable = false)
    private String fullName;

    public Person() { }

    public Person(String personId, String fullName) {
        this.personId = personId;
        this.fullName = fullName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personId.equals(person.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId);
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId='" + personId + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
