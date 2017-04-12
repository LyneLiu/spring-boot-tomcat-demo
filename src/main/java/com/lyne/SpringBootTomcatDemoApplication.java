package com.lyne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootTomcatDemoApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(SpringBootTomcatDemoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTomcatDemoApplication.class, args);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        return "spring boot demo with tomcat!";
    }
}
