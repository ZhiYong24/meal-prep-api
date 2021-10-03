package com.example.mealprep.controller;

import com.example.mealprep.model.Meal;
import com.example.mealprep.model.MealPrep;
import com.example.mealprep.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<?> getMeal(

    ){
        try{
            return ResponseEntity.ok(mealService.getMeal());
        } catch(Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @PostMapping(value = "/replace")
    public ResponseEntity<String> editMeal(
            @RequestParam(value = "mealName") String mealName,
            @RequestBody() Meal meal
    ){
        try{
            mealService.editMeal(mealName, meal);
            return ResponseEntity.ok("Meal patched: " + meal);
        } catch(Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteMeal(
            @RequestParam(value = "mealName") String mealName
    ){
        try{
            mealService.deleteMeal(mealName);
            return ResponseEntity.ok("Meal deleted: " + mealName);
        } catch(Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
