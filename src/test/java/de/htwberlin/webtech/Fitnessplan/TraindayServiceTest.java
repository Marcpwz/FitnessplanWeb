package de.htwberlin.webtech.Fitnessplan;


import de.htwberlin.webtech.Fitnessplan.Service.ExerciseService;
import de.htwberlin.webtech.Fitnessplan.Service.TraindayService;
import de.htwberlin.webtech.Fitnessplan.persistence.TraindayRepository;
import de.htwberlin.webtech.Fitnessplan.persistence.TraindayEntity;
import de.htwberlin.webtech.Fitnessplan.web.api.Trainday;
import de.htwberlin.webtech.Fitnessplan.web.api.TraindayManipulationRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
public class TraindayServiceTest {
    //diese Test überprüfen nicht nur den Service sondern die zusammenarbeit von service und datenbank

    @Mock
    private TraindayRepository traindayRepository;

    @Mock
    private ExerciseService exerciseService;

    @Autowired
    TraindayService traindayService;

    @Test
    @DisplayName("fügt über den Service einen trainday zur datenbank hinzu")
    void addTraindaytoDB() {
        LocalDate date = LocalDate.now();
        TraindayManipulationRequest newtrainday = new TraindayManipulationRequest("TESTNAME",LocalDate.now());

        Trainday trainday = traindayService.create(newtrainday);

        assertEquals(trainday.getName(),newtrainday.getName());
        assertEquals(trainday.getDate(),newtrainday.getDate());
    }

    @Test
    @DisplayName("fügt über den Service einen trainday zur datenbank hinzu und überprüft dann ob er über die id auch wieder zurückgeben wird")
    void addTraindaytoDBandgetoverid() {
        LocalDate date = LocalDate.now();
        TraindayManipulationRequest newtrainday = new TraindayManipulationRequest("TESTNAME",LocalDate.now());

        Trainday createdtrainday = traindayService.create(newtrainday);

        Trainday trainday = traindayService.findById(createdtrainday.getId());

        assertEquals(trainday.getName(),newtrainday.getName());
        assertEquals(trainday.getDate(),newtrainday.getDate());
    }



}
