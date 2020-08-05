package com.damithtech.springbootbasic.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DAMITH SAMARAKOON on 8/5/2020
 */
@RestController
public class VersioningController {

    //Basic Versioning - changed URI
    @GetMapping("/v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Bob charli");
    }

    @GetMapping("/v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Bob","Charli"));
    }

    //Adding content negotiations - Adding header param for API version
    @GetMapping(value = "/person/header",headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Bob charli");
    }

    @GetMapping(value = "/person/header",headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Bob","Charli"));
    }

    //Accept header versioning
    @GetMapping(value = "/person/producer",produces = "application/vnd.company.app-v1+json")
    public PersonV1 producerV1(){
        return new PersonV1("Bob charli");
    }

    @GetMapping(value = "/person/producer",produces = "application/vnd.company.app-v2+json")
    public PersonV2 producerV2(){
        return new PersonV2(new Name("Bob","Charli"));
    }
}
