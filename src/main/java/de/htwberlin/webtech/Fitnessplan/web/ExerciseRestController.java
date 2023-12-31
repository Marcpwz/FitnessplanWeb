package de.htwberlin.webtech.Fitnessplan.web;

import de.htwberlin.webtech.Fitnessplan.Service.ExerciseService;
import de.htwberlin.webtech.Fitnessplan.web.api.Exercise;
import de.htwberlin.webtech.Fitnessplan.web.api.ExerciseManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ExerciseRestController {

    private List<Exercise> persons;
    private final ExerciseService exerciseService;


    public ExerciseRestController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping(path = "/api/v1/exercise")
    public ResponseEntity<List<Exercise>> fetchPersons() {
        return ResponseEntity.ok(exerciseService.findAll());
    }
    @GetMapping(path = "/api/v1/exercise/{id}")
    public ResponseEntity<Exercise> fetchPersonById(@PathVariable Long id) {
        var person = exerciseService.findById(id);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/exercise")
    public ResponseEntity<Void> createPerson(@RequestBody ExerciseManipulationRequest request) throws URISyntaxException {
        var person = exerciseService.create(request);
        URI uri = new URI("/api/v1/exercise/" + person.getId());
        return ResponseEntity.created(uri).build();
    }


    @PutMapping(path = "/api/v1/exercise/{id}")
    public ResponseEntity<Exercise> updatePerson(@PathVariable Long id, @RequestBody ExerciseManipulationRequest request) {
        var person = exerciseService.update(id, request);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }



    @DeleteMapping(path = "/api/v1/exercise/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        boolean successful = exerciseService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}