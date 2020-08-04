package com.damithtech.springbootbasic.controller;

import com.damithtech.springbootbasic.model.StaticFiletringBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DAMITH SAMARAKOON on 8/4/2020
 */
@RestController
public class StaticFilteringController {
    @GetMapping("/static-filtering")
    public StaticFiletringBean getStaticFilteringBean() {
        return new StaticFiletringBean("v1", "v2", "v3");
    }
}
