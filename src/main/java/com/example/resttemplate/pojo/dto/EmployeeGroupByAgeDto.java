package com.example.resttemplate.pojo.dto;

import com.example.resttemplate.pojo.Employee;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class EmployeeGroupByAgeDto {
    private Map<Integer, List<Employee>> map;
}
