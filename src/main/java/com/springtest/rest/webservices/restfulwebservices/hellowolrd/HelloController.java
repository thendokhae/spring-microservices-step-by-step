package com.springtest.rest.webservices.restfulwebservices.hellowolrd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String getHello(@RequestHeader(name="Accept-Language", required = false)Locale locale){
        return messageSource.getMessage("good.morning.message",null,locale);
    }

    @GetMapping(path = "/hello-internationalized")
    public String hellowInternationalized(){
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

    @GetMapping(path = "/hello-bean")
    public HelloBean getHelloBean(){
        return new HelloBean("Hello");
    }

    @GetMapping(path = "/hello-bean/{name}")
    public HelloBean getHelloBeanWithVariable(@PathVariable String name){
        return new HelloBean(String.format("Hello, %s", name));
    }
}
