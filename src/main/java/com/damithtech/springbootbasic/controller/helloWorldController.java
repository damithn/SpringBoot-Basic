package com.damithtech.springbootbasic.controller;

import com.damithtech.springbootbasic.model.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DAMITH SAMARAKOON on 7/20/2020
 */
@RestController
public class helloWorldController {
    @GetMapping(value = "/hello-world")
    public String helloController() {
        return "Hello World";
    }

    @GetMapping(value = "/hello-world-bean")
    public HelloWorldBean helloControllerBean() {
        return new HelloWorldBean("Hello World");
    }
}
