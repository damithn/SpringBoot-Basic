package com.damithtech.springbootbasic.controller;

import com.damithtech.springbootbasic.model.TestBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DAMITH SAMARAKOON on 8/4/2020
 */
@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public TestBean gettestBean(){
        return new  TestBean ("v1","v2","v3");
    }
}
