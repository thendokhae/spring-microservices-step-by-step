package com.springtest.rest.webservices.restfulwebservices.versioning;

public class PersonV2 {

    public PersonV2(Name fullName) {
        this.fullName = fullName;
    }

    public PersonV2() {
    }

    private Name fullName;

    public Name getFullName() {
        return fullName;
    }

    public void setFullName(Name fullName) {
        this.fullName = fullName;
    }
}
