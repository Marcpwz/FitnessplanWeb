package de.htwberlin.webtech.Fitnessplan;

import de.htwberlin.webtech.Fitnessplan.persistence.ExerciseEntity;
import de.htwberlin.webtech.Fitnessplan.persistence.ExerciseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ExerciseRepositoryTest {

    @Autowired
    private ExerciseRepository exerciseRepository;

    private ExerciseEntity exercise;

    @BeforeEach
    public void setup() {
        exercise = new ExerciseEntity("Test Exercise", 10, 3, 15.0f, LocalTime.NOON, 1L);
        exerciseRepository.save(exercise);
    }

    @Test
    public void testFindAll() {
        List<ExerciseEntity> exercises = exerciseRepository.findAll();
        assertFalse(exercises.isEmpty());
    }

    @Test
    public void testFindById() {
        ExerciseEntity found = exerciseRepository.findById(exercise.getId()).orElse(null);
        assertNotNull(found);
        assertEquals("Test Exercise", found.getName());
    }

    @Test
    public void testFindAllByTid() {
        List<ExerciseEntity> exercises = exerciseRepository.findAllBytid(1L);
        assertFalse(exercises.isEmpty());
        assertEquals(1L, exercises.get(0).getTid());
    }

    @Test
    public void testSave() {
        ExerciseEntity newExercise = new ExerciseEntity("New Exercise", 12, 4, 20.0f, LocalTime.NOON, 2L);
        ExerciseEntity saved = exerciseRepository.save(newExercise);
        assertNotNull(saved);
        assertEquals("New Exercise", saved.getName());
    }

    @Test
    public void testUpdate() {
        exercise.setName("Updated Exercise");
        ExerciseEntity updated = exerciseRepository.save(exercise);
        assertNotNull(updated);
        assertEquals("Updated Exercise", updated.getName());
    }

    @Test
    public void testDeleteById() {
        exerciseRepository.deleteById(exercise.getId());
        assertFalse(exerciseRepository.existsById(exercise.getId()));
    }

}