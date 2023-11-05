package de.htwberlin.webtech.Fitnessplan.web;

import de.htwberlin.webtech.Fitnessplan.Service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonRestController {

    private List<Person> persons;
    private final PersonService personService;


    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/api/v1/persons")
    public ResponseEntity<List<Person>> fetchPersons() {
        return ResponseEntity.ok(personService.findAll());
    }

}