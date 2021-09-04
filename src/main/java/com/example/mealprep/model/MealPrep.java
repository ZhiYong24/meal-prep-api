package com.example.mealprep.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MealPrep {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    int meal;
    String containerType;
    String protein;
    double proteinQuantity;
    String veggies;
    double veggiesQuantity;
    String carb;
    double carbQuantity;
    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDate date;
}
