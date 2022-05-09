package com.example.coursebookingserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course extends BaseEntity{

    @NotBlank(message = "Name of the course is mandatory!")
    private String name;

    private String description;

    @NotBlank(message = "Tutor of the course is mandatory!")
    private String tutor;

    @NotBlank(message = "Cost is mandatory!")
    private BigDecimal cost;

    @OneToMany(mappedBy = "course", cascade = CascadeType.PERSIST)
    private List<Booking> bookings=new ArrayList<>();


}
