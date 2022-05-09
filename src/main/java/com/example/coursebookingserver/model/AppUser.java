package com.example.coursebookingserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser extends BaseEntity{

    @NotBlank
    private String password;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    private String firstName;

    private String lastName;

    private String role;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.PERSIST)
    private List<Booking> bookings=new ArrayList<>();

}
