package de.htwberlin.webtech.Fitnessplan.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Long> {

    List<ExerciseEntity> findAllBytid(Long tid);

}
