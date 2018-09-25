package com.springtest.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping(value ="/person/param",params = "version=1")
    public PersonV1 retrievePersonV1(){
        return new PersonV1("Jane Doe");
    }

    @GetMapping(value ="/person/param", params = "version=2")
    public PersonV2 retrivePersonV2(){
        return new PersonV2(new Name("Jane","Doe"));
    }

    @GetMapping(value ="/person/header",headers = "X_API_VERSION=1")
    public PersonV1 retrieveHeaderV1(){
        return new PersonV1("Jane Doe");
    }

    @GetMapping(value ="/person/header", headers = "X_API_VERSION=2")
    public PersonV2 retriveHeaderV2(){
        return new PersonV2(new Name("Jane","Doe"));
    }

    @GetMapping(value ="/person/produces",produces = "application/vnd.company.app-v1+json")
    public PersonV1 retrieveProducesV1(){
        return new PersonV1("Jane Doe");
    }

    @GetMapping(value ="/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 retrieveProducesV2(){
        return new PersonV2(new Name("Jane","Doe"));
    }
}
