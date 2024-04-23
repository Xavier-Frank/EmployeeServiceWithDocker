package com.sample.EmployeeSample.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "EmployeeDto", description = "Employee dto details")
public class EmployeeDto {

    @Schema(example = "10", description = "Employee id", accessMode = Schema.AccessMode.AUTO)
    private BigInteger id;
    @Schema(example = "onyangootoyo", description = "employee user name", accessMode = Schema.AccessMode.READ_WRITE)
    private String username;
    @Schema(example = "19", description = "Employee's age", nullable = true)
    private Integer age;

    @Schema(example = "oduorfrancis134@gmail.com", description = "Employee email address", nullable = false)
    private String email;

    @Schema(example = "oduor1234*", description = "Employee encrypted password", nullable = false)
    private String password;

}
