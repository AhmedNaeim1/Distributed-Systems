package com.AhmedNaeim.assignment3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.ahmedNaeim.assignent3ejb.beans")
public class Assignment3Application {

    public static void main(String[] args) {
        SpringApplication.run(Assignment3Application.class, args);
    }

}
