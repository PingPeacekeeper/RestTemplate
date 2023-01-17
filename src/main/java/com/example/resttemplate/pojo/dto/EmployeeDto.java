package com.example.resttemplate.pojo.dto;

import com.example.resttemplate.pojo.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    Map<String, List<Employee>> map;
}
