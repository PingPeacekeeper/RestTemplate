package com.example.resttemplate.Service;

import com.example.resttemplate.RestTemplateApplication;
import com.example.resttemplate.service.impl.EmployeeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestTemplateApplication.class)
public class serviceTest {
    @Autowired
    EmployeeServiceImpl service;
    @Test
    public void test(){
        System.out.println(service.groupByAge());

    }
}
