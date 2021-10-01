package com.example.mealprep.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Meal {
    @Id
    private String mealName;
    private String protein;
    private String carbs;
    private String veggies;
    private String remark;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime timestamp;
}
