package com.springBoot.springboot.tutorial.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

//    System.nanoTime() use to generate unique key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please Add Department Name")
//    @Length(min = 2,max = 6)
    private String departmentName;
    @NotBlank(message = "Please Enter Department Address")
    private String departmentAddress;
    @NotBlank(message = "Please Enter Department Code")
    private String departmentCode;


}
