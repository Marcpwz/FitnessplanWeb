package de.htwberlin.webtech.Fitnessplan.Service;

import de.htwberlin.webtech.Fitnessplan.persistence.ExerciseEntity;
import de.htwberlin.webtech.Fitnessplan.persistence.ExerciseRepository;
import de.htwberlin.webtech.Fitnessplan.web.api.Exercise;
import de.htwberlin.webtech.Fitnessplan.web.api.ExerciseManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository personRepository) {
        this.exerciseRepository = personRepository;
    }

    public List<Exercise> findAll() {
        List<ExerciseEntity> exercises = exerciseRepository.findAll();
        return exercises.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Exercise findById(Long id) {
        var personEntity = exerciseRepository.findById(id);
        return personEntity.map(this::transformEntity).orElse(null);
    }

    public Exercise create(ExerciseManipulationRequest request) {
        var exerciseEntity = new ExerciseEntity(request.getName(), request.getReps(), request.getSets(), request.getWeight(), request.getDuration());
        exerciseEntity = exerciseRepository.save(exerciseEntity);
        return transformEntity(exerciseEntity);
    }


    public Exercise update(Long id, ExerciseManipulationRequest request) {
        var exerciseEntityOptional = exerciseRepository.findById(id);
        if (exerciseEntityOptional.isEmpty()) {
            return null;
        }

        var exerciseEntity = exerciseEntityOptional.get();
        exerciseEntity.setName(request.getName());
        exerciseEntity.setReps(request.getReps());
        exerciseEntity.setSets(request.getSets());
        exerciseEntity.setDuration(request.getDuration());
        exerciseEntity = exerciseRepository.save(exerciseEntity);

        return transformEntity(exerciseEntity);
    }



    public boolean deleteById(Long id) {
        if (!exerciseRepository.existsById(id)) {
            return false;
        }

        exerciseRepository.deleteById(id);
        return true;
    }

    private Exercise transformEntity(ExerciseEntity exerciseEntity) {
        return new Exercise(exerciseEntity.getId(),exerciseEntity.getName(),exerciseEntity.getReps(),exerciseEntity.getSets(), exerciseEntity.getWeight(), exerciseEntity.getDuration());
    }

}
