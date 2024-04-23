package com.sample.EmployeeSample.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private BigInteger id;
    @Column(name = "USERNAME", nullable = false)
    private String username;
    @Column(name = "AGE", nullable = true)
    private Integer age;
    @Column(name = "EMAIL", unique = true)
    private String email;
    @Column(name = "PASSWORD", length = 950)
    private String password;
}
