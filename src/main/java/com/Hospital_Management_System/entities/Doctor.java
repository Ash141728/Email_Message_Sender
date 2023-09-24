package com.Hospital_Management_System.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    @Pattern(regexp = "^\\+[0-9]{1,3}[0-9]{10}$", message = "Phone number must start with a '+' and have 10 additional digits")
    private String phoneNumber;


    @Email(message = "Invalid email address")
    private String email;

    @Min(value = 0, message = "Consultation fee must be a non-negative value")
    private int consultationFee;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments = new ArrayList<>();


}
