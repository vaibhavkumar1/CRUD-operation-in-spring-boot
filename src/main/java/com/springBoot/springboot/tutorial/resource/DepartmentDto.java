package com.springBoot.springboot.tutorial.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    @NotBlank(message = "Please Add Department Name")
//    @Length(min = 2,max = 6)
    private String departmentName;
    @NotBlank(message = "Please Enter Department Address")
    private String departmentAddress;
    @NotBlank(message = "Please Enter Department Code")
    private String departmentCode;
}
