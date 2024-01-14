package de.htwberlin.webtech.Fitnessplan.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import de.htwberlin.webtech.Fitnessplan.persistence.ExerciseEntity;
import de.htwberlin.webtech.Fitnessplan.persistence.ExerciseRepository;
import de.htwberlin.webtech.Fitnessplan.web.api.Exercise;
import de.htwberlin.webtech.Fitnessplan.web.api.ExerciseManipulationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ExerciseServiceTest {

    @Mock
    private ExerciseRepository exerciseRepository;

    @InjectMocks
    private ExerciseService exerciseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("überürüft ob die übungen zurückgegeben werden")
    void findAll_ShouldReturnExercises() {
        LocalTime time = LocalTime.NOON;
        // Arrange
        var exercise1 = new ExerciseEntity("Exercise1", 10, 3, 15.0f, time, 1L);
        var exercise2 = new ExerciseEntity("Exercise2", 12, 4, 10.0f, time, 2L);
        exercise1.setId(1L); //set ID wird benötigt da die datenbank die id zuweisung übernimmt in diesem fall aber es gemockt wird also kein datenbankzugriff tatsächlcih stattfindet
        exercise2.setId(2L);
        when(exerciseRepository.findAll()).thenReturn(Arrays.asList(exercise1, exercise2));

        // Act
        List<Exercise> exercises = exerciseService.findAll();

        // Assert
        assertNotNull(exercises);
        assertEquals(2, exercises.size());
        verify(exerciseRepository).findAll();
    }

    @Test
    @DisplayName("überürüft ob eine übung mit dem richtigen namen zurückgegeben wird")
    void findById_ShouldReturnExercise() {
        LocalTime time = LocalTime.NOON;
        // Arrange
        Long id = 1L;
        var exercise = new ExerciseEntity("Exercise", 10, 3, 15.0f, time, 1L);
        exercise.setId(1L);
        when(exerciseRepository.findById(id)).thenReturn(Optional.of(exercise));
        // Act
        Exercise result = exerciseService.findById(id);

        // Assert
        assertNotNull(result);
        assertEquals("Exercise", result.getName());
        verify(exerciseRepository).findById(id);
    }

    @Test
    @DisplayName("überprüft ob beim erstellen einer exercise die richtige exercise zurückgebgen wird")
    void create_ShouldReturnNewExercise() {
        LocalTime time = LocalTime.NOON;
        // Arrange
        var request = new ExerciseManipulationRequest("New Exercise", 8, 2, 20.0f, time, 3L);
        var savedExercise = new ExerciseEntity("New Exercise", 8, 2, 20.0f, time, 3L);
        savedExercise.setId(1L);
        when(exerciseRepository.save(any(ExerciseEntity.class))).thenReturn(savedExercise);

        // Act
        Exercise result = exerciseService.create(request);

        // Assert
        assertNotNull(result);
        assertEquals("New Exercise", result.getName());
        verify(exerciseRepository).save(any(ExerciseEntity.class));
    }

    @Test
    @DisplayName("überprüft ob true zurückgegeben wird wenn eine übung erfolgreich deletet wurde")
    void deleteById_ShouldReturnTrueWhenSuccessful() {
        // Arrange
        Long id = 1L;
        when(exerciseRepository.existsById(id)).thenReturn(true);
        doNothing().when(exerciseRepository).deleteById(id);

        // Act
        boolean result = exerciseService.deleteById(id);

        // Assert
        assertTrue(result);
        verify(exerciseRepository).deleteById(id);
    }
}