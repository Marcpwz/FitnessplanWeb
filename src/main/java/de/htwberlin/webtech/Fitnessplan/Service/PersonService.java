package de.htwberlin.webtech.Fitnessplan.Service;

import de.htwberlin.webtech.Fitnessplan.persistence.PersonEntity;
import de.htwberlin.webtech.Fitnessplan.persistence.PersonRepository;
import de.htwberlin.webtech.Fitnessplan.web.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        List<PersonEntity> persons = personRepository.findAll();
        return persons.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

}
