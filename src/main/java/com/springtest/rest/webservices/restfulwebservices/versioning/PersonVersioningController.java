package com.springtest.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("/v1/person")
    public PersonV1 retrievePersonV1(){
        return new PersonV1("Jane Doe");
    }

    @GetMapping("v2/person")
    public PersonV2 retrivePersonV2(){
        return new PersonV2(new Name("Jane","Doe"));
    }
}
