package com.example.mealprep.service;

import com.example.mealprep.model.Meal;
import com.example.mealprep.repository.MealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MealService {
    private final MealRepo mealRepo;

    @Autowired
    public MealService(MealRepo mealRepo) {
        this.mealRepo = mealRepo;
    }

    @Transactional
    public void addMeal(Meal meal) throws Exception {
        if (!StringUtils.hasText(meal.getMealName())){
            throw new Exception("A meal must contain meal name");
        }

        if (!StringUtils.hasText(meal.getCarbs()) && !StringUtils.hasText(meal.getProtein()) && !StringUtils.hasText(meal.getVeggies())){
            throw new Exception("A meal must contain at least one protein, carbs or veggies");
        }

        meal.setTimestamp(LocalDateTime.now());
        mealRepo.save(meal);
    }

    @Transactional
    public List<Meal> getMeal() throws Exception {
        return mealRepo.findAll();
    }
}
