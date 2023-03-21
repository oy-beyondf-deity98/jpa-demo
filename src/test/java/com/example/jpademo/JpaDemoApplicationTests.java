package com.example.jpademo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootTest
class JpaDemoApplicationTests {


    @Autowired
    ApplicationContext ac;


    @Test
    void contextLoads() {
        Arrays.stream(ac.getBeanDefinitionNames()).forEach(beanName -> System.out.println("bean = " + beanName));
    }

}
