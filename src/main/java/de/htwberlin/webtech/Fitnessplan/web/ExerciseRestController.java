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

    private final ExerciseService exerciseService;


    public ExerciseRestController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping(path = "/api/v1/exercise")
    public ResponseEntity<List<Exercise>> fetchExercise() {
        return ResponseEntity.ok(exerciseService.findAll());
    }
    @GetMapping(path = "/api/v1/exercise/{id}")
    public ResponseEntity<Exercise> fetchExerciseById(@PathVariable Long id) {
        var person = exerciseService.findById(id);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/api/v1/exercise/Trainday{tid}")
    public ResponseEntity<List<Exercise>> fetchExerciseByTid(@PathVariable Long tid) {
        var exercise = exerciseService.findAllbytid(tid);
        return exercise != null? ResponseEntity.ok(exercise) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/exercise")
    public ResponseEntity<Void> createExercise(@RequestBody ExerciseManipulationRequest request) throws URISyntaxException {
        System.out.println("TEST");
        var person = exerciseService.create(request);
        URI uri = new URI("/api/v1/exercise/" + person.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/exercise/{id}")
    public ResponseEntity<Exercise> updateExercise(@PathVariable Long id, @RequestBody ExerciseManipulationRequest request) {
        var person = exerciseService.update(id, request);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/exercise/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        boolean successful = exerciseService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}