package com.insignia.employeemanager.model;

import lombok.*;


import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Employee implements Serializable {
    private Long id;
    private String jobTitle;
    private String firstName;
    private String surName;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private String imageUrl;
    private Address address;
}
