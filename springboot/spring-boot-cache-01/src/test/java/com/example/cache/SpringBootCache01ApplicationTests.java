package com.example.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.cache.mapper.EmployeeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCache01ApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;
    @Test
    public void contextLoads() {
        System.out.println(employeeMapper.getEmployee(1));
    }

}
