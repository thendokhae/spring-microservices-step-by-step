package com.springtest.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean(){
        return new SomeBean("value1","value2","value3");
    }

    @GetMapping("/filrering-list")
    public List<SomeBean> retrieveListSomeBeans(){
        return Arrays.asList(new SomeBean("v1","v2","v3"), new SomeBean("value1","value2","value3"));
    }
}
