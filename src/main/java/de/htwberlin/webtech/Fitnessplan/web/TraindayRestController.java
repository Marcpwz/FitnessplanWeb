package de.htwberlin.webtech.Fitnessplan.web;


import de.htwberlin.webtech.Fitnessplan.Service.TraindayService;
import de.htwberlin.webtech.Fitnessplan.web.api.Exercise;
import de.htwberlin.webtech.Fitnessplan.web.api.ExerciseManipulationRequest;
import de.htwberlin.webtech.Fitnessplan.web.api.Trainday;
import de.htwberlin.webtech.Fitnessplan.web.api.TraindayManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class TraindayRestController {
    private final TraindayService traindayService;

    public TraindayRestController(TraindayService traindayService) {
        this.traindayService = traindayService;
    }

    @GetMapping(path = "/api/v1/trainday")
    public ResponseEntity<List<Trainday>> fetchTrainday() {
        return ResponseEntity.ok(traindayService.findAll());
    }
    @GetMapping(path = "/api/v1/trainday/{id}")
    public ResponseEntity<Trainday> fetchTraindayById(@PathVariable Long id) {
        var trainday = traindayService.findById(id);
        return trainday != null? ResponseEntity.ok(trainday) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/trainday")
    public ResponseEntity<Void> createTrainday(@RequestBody TraindayManipulationRequest request) throws URISyntaxException {
        System.out.println("TEST");
        var trainday = traindayService.create(request);
        URI uri = new URI("/api/v1/trainday/" + trainday.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/trainday/{id}")
    public ResponseEntity<Trainday> updateTrainday(@PathVariable Long id, @RequestBody TraindayManipulationRequest request) {
        var trainday = traindayService.update(id, request);
        return trainday != null? ResponseEntity.ok(trainday) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/trainday/{id}")
    public ResponseEntity<Void> deleteTrainday(@PathVariable Long id) {
        boolean successful = traindayService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
