package com.damithtech.springbootbasic.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DAMITH SAMARAKOON on 8/5/2020
 */
@RestController
public class VersioningController {
    @GetMapping("/v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Bob charli");
    }

    @GetMapping("/v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Bob","Charli"));
    }
}
