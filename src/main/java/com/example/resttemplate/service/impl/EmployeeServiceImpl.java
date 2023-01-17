package com.example.resttemplate.service.impl;

import com.example.resttemplate.pojo.Employee;
import com.example.resttemplate.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final RestTemplate restTemplate;

    public EmployeeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class EmpResponseBean {
        String status;
        List<Employee> ls;
    }

    private List<Employee> rpcEmp() {
        String url = "https://dummy.restapiexample.com/api/v1/employees";
        EmpResponseBean res = restTemplate.getForObject(url, EmpResponseBean.class);
        return res.getLs();
    }

    public Map<Integer, List<Employee>> groupByAge() {
        Map<Integer, List<Employee>> map = new HashMap<>();


        for (Employee e : rpcEmp()) {
            List<Employee> t = map.computeIfAbsent(e.getAge(), k -> new ArrayList<>());
            t.add(e);
        }
        return map;
    }

    public List<Employee> getAll() {
        return rpcEmp();
    }

}
