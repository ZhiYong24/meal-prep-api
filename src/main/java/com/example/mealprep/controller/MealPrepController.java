package com.example.mealprep.controller;

import com.example.mealprep.model.MealPrep;
import com.example.mealprep.repository.MealPrepRepo;
import com.example.mealprep.service.MealPrepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/meal-prep")
public class MealPrepController {

    private final MealPrepService mealPrepService;

    @Autowired
    public MealPrepController(MealPrepService mealPrepService){
        this.mealPrepService = mealPrepService;
    }

    @GetMapping
    public ResponseEntity<List<MealPrep>> getMealPrep(
        @RequestParam(value = "date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date
        ){
        return ResponseEntity.ok(mealPrepService.getMealPrepByDate(date));
    }

    @PostMapping
    public ResponseEntity<String> addMealPrep(
            @RequestBody() MealPrep mealPrep
    ){
        try{
            mealPrepService.addMealPrep(mealPrep);
            return ResponseEntity.ok().body("New meal prep entry added: " + mealPrep);
        }catch(Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
