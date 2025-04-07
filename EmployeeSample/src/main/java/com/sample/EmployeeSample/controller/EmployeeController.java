package com.sample.EmployeeSample.controller;

import com.sample.EmployeeSample.dto.EmployeeDto;
import com.sample.EmployeeSample.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"}, methods = RequestMethod.GET)
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public EmployeeDto addEmployee(@Validated @RequestBody EmployeeDto employeeDto){
       return  employeeService.saveNewEmployee(employeeDto);
    }

    @GetMapping("/list-of-employees")
    public List<EmployeeDto> employeeDtoList(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/search-employee/{id}")
    public EmployeeDto findEmployeeById(@PathVariable(value = "id") BigInteger id){
        return employeeService.findEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable BigInteger id){
        final Boolean deletedEmployeeById = employeeService.deleteEmployeeById(id);

        Map<String, Boolean> status = new HashMap<>();

        if (deletedEmployeeById){
            status.put("Successfully deleted", Boolean.TRUE);
        }else {
            status.put("Successfully deleted", Boolean.FALSE);
        }
        return status;
    }
    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable BigInteger id, @RequestBody EmployeeDto employeeDto){
        return employeeService.editEmployeeDetails(id, employeeDto);
    }


}
