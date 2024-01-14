package de.htwberlin.webtech.Fitnessplan.Service;

import de.htwberlin.webtech.Fitnessplan.persistence.TraindayEntity;
import de.htwberlin.webtech.Fitnessplan.persistence.TraindayRepository;
import de.htwberlin.webtech.Fitnessplan.web.api.Trainday;
import de.htwberlin.webtech.Fitnessplan.web.api.TraindayManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TraindayService {
    private final TraindayRepository traindayRepository;
    private final ExerciseService exerciseService;
    public TraindayService(TraindayRepository traindayRepository, ExerciseService exerciseService) { this.traindayRepository = traindayRepository;
        this.exerciseService = exerciseService;
    }

    public List<Trainday> findAll() {
        List<TraindayEntity> traindays = traindayRepository.findAll();
        return traindays.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Trainday findById(Long id) {
        var traindayEntity = traindayRepository.findById(id);
        return traindayEntity.map(this::transformEntity).orElse(null);
    }


    public Trainday create(TraindayManipulationRequest request) {
        var traindayEntity = new TraindayEntity(request.getName(), request.getDate());
        traindayEntity = traindayRepository.save(traindayEntity);
        return transformEntity(traindayEntity);
    }

    public Trainday update(Long id, TraindayManipulationRequest request) {
        var traindayEntityOptional = traindayRepository.findById(id);
        if (traindayEntityOptional.isEmpty()) {
            return null;
        }
        var traindayEntity = traindayEntityOptional.get();
        traindayEntity.setName(request.getName());
        traindayEntity.setDate(request.getDate());
        traindayEntity = traindayRepository.save(traindayEntity);
        return transformEntity(traindayEntity);
    }

    public boolean deleteById(Long id) {
        if (!traindayRepository.existsById(id)) {
            return false;
        }
        traindayRepository.deleteById(id);
        exerciseService.deleteByTid(id);
        return true;
    }

    private Trainday transformEntity(TraindayEntity traindayEntity) {
        return new Trainday(traindayEntity.getId(),traindayEntity.getName(),traindayEntity.getDate());
    }

}
