package com.example.mealprep.service;

import com.example.mealprep.model.MealPrep;
import com.example.mealprep.repository.MealPrepRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class MealPrepService {
    private final MealPrepRepo mealPrepRepo;

    @Autowired
    public MealPrepService(MealPrepRepo mealPrepRepo) {
        this.mealPrepRepo = mealPrepRepo;
    }

    public List<MealPrep> getMealPrepByDate(LocalDate date){
        return mealPrepRepo.findByDate(date);
    }

    @Transactional
    public void addMealPrep(MealPrep mealPrep){
        mealPrepRepo.save(mealPrep);
    }
}
