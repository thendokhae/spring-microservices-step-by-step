package com.springtest.rest.webservices.restfulwebservices.hellowolrd;

public class HelloBean {

    private String message;

    public HelloBean(String hello) {
        setMessage(hello);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
