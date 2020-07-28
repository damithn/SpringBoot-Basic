package com.damithtech.springbootbasic.controller;

import com.damithtech.springbootbasic.model.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @author DAMITH SAMARAKOON on 7/20/2020
 */
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = "/hello-world")
    public String helloController() {
        return "Hello World";
    }

    @GetMapping(value = "/hello-world-bean")
    public HelloWorldBean helloControllerBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(value = "/hello-world-bean/{name}")
    public HelloWorldBean helloControllerBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s",name));
    }

    @GetMapping(value = "/hello-world-internationalization")
    public String helloworldinternationalizationController(@RequestHeader(name = "Accept-Language",required = false) Locale locale) {
        return messageSource.getMessage("good.morning.message",null,locale);
    }
}
