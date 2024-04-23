package com.sample.EmployeeSample.repository;

import com.sample.EmployeeSample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigInteger;
public interface EmployeeRepository extends JpaRepository<Employee, BigInteger> {

}