package com.example.mealprep.controller;

import com.example.mealprep.model.Meal;
import com.example.mealprep.model.MealPrep;
import com.example.mealprep.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meal")
public class MealController {
    private final MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping
    public ResponseEntity<String> addMeal(
            @RequestBody() Meal meal
    ){
        try{
            mealService.addMeal(meal);
            return ResponseEntity.ok().body("New meal added: " + meal);
        }catch(Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
