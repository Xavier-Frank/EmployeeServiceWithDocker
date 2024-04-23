package com.sample.EmployeeSample.controller;

import com.sample.EmployeeSample.dto.EmployeeDto;
import com.sample.EmployeeSample.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Employee Controller", description = "A controller to manage all employee operations")
@CrossOrigin(origins = {"http://localhost:4200"}, methods = RequestMethod.GET)
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/addEmployee")
    @Operation(summary = "An endpoint to add an employee", responses = {
            @ApiResponse(responseCode = "200", description = "Employee Saved successfully")
    })
    public EmployeeDto addEmployee(@Validated @RequestBody EmployeeDto employeeDto){

       return  employeeService.saveNewEmployee(employeeDto);
    }

    @GetMapping("/list-of-employees")
    @Operation(summary = "An endpoint to view all employees")
    public List<EmployeeDto> employeeDtoList(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/search-employee/{id}")
    @Operation(summary = "An endpoint to finde an employee by id")
    public EmployeeDto findEmployeeById(@PathVariable(value = "id") BigInteger id){
        return employeeService.findEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "An endpoint to delete an employee")
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
    @Operation(summary = "An endpoint to edit employee details")
    public EmployeeDto updateEmployee(@PathVariable BigInteger id, @RequestBody EmployeeDto employeeDto){
        return employeeService.editEmployeeDetails(id, employeeDto);
    }


}
