package com.example.resttemplate.controller;

import com.example.resttemplate.pojo.Employee;
import com.example.resttemplate.pojo.dto.EmployeeDto;
import com.example.resttemplate.pojo.dto.EmployeeGroupByAgeDto;
import com.example.resttemplate.service.EmployeeService;
import com.example.resttemplate.service.impl.EmployeeServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeServiceImpl service;

    @Autowired
    public EmployeeController(EmployeeServiceImpl s) {
        service = s;
    }

    @GetMapping("/")
    public ResponseEntity<EmployeeGroupByAgeDto> groupByAge() {
        EmployeeGroupByAgeDto res = new EmployeeGroupByAgeDto();
        res.setMap(new TreeMap<>(service.groupByAge()));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/xxx")
    public ResponseEntity<EmployeeDto> gtAge(@PathParam(value = "age") int age) {
        EmployeeDto res = new EmployeeDto();
        Map<String, List<Employee>> map=new HashMap<>();
        map.put("data",service.getAll());
        res.setMap(map);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
