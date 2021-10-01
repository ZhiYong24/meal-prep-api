package com.example.mealprep.repository;

import com.example.mealprep.model.Meal;
import com.example.mealprep.model.MealPrep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MealRepo extends JpaRepository<Meal, Long> {
}