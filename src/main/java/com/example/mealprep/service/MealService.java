package com.example.mealprep.service;

import com.example.mealprep.model.Meal;
import com.example.mealprep.repository.MealRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MealService {
    private final MealRepo mealRepo;
    private static final Logger LOG = LoggerFactory.getLogger(MealService.class);

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

    @Transactional
    public void editMeal(String mealName, Meal meal) throws Exception {
        if (!StringUtils.hasText(mealName)){
            throw new Exception("A meal must contain meal name");
        }

        if (!StringUtils.hasText(meal.getCarbs()) && !StringUtils.hasText(meal.getProtein()) && !StringUtils.hasText(meal.getVeggies())){
            throw new Exception("A meal must contain at least one protein, carbs or veggies");
        }

        Meal mealEdit = mealRepo.findByMealName(mealName);
        // User changed meal name
        if (mealEdit != null){
            deleteMeal(mealName); //delete previous record
            LOG.info("Deleting meal name: {}", mealName);
        }
        mealRepo.save(meal); //save new record
        LOG.info("Saving meal: {}", meal);
    }

    @Transactional
    public void deleteMeal(String mealName) throws Exception {
        if (!StringUtils.hasText(mealName)){
            throw new Exception("A meal must contain meal name");
        }

        Optional<Meal> mealEdit = Optional.of(mealRepo.findById(mealName).orElse(null));
        if (mealEdit.isPresent()){
            mealRepo.delete(mealEdit.get());
        } else{
            throw new Exception("Failed to find this meal with meal name: " + mealName);
        }
    }
}
