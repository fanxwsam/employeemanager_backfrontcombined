package com.insignia.employeemanager.model;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Address  implements Serializable {
    private Long id;
    private Long employeeId;
    private String street;
    private String city;
    private String state;
    private String postcode;
}