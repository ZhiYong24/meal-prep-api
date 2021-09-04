package com.example.mealprep.repository;

import com.example.mealprep.model.MealPrep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MealPrepRepo extends JpaRepository<MealPrep, Long> {
    List<MealPrep> findByDate(LocalDate date);
}
