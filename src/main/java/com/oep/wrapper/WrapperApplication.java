package com.oep.wrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.oep.*"})
public class WrapperApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WrapperApplication.class, args);
    }
}