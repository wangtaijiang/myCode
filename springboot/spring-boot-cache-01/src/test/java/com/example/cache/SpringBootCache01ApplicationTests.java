package com.example.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.cache.entities.Employee;
import com.example.cache.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCache01ApplicationTests {

    @Autowired
    EmployeeService employeeService;
    @Test
    public void contextLoads() {


    }

    @Test
    public void testCacheable(){
        System.out.println(employeeService.getEMP(1));

        System.out.println(employeeService.getEMP(1));
        System.out.println(employeeService.getEMP(1));
    }
    @Test
    public void testCachePut(){
        Employee employee = new Employee();
        employee.setLastName("zhangsan");
        employee.setGender(0);

    }

}
