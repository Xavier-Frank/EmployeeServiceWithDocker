package com.sample.EmployeeSample.dto;


import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    private BigInteger id;
    private String username;
    private Integer age;
    private String email;
    private String password;

}
