package com.damithtech.springbootbasic.version;

/**
 * @author DAMITH SAMARAKOON on 8/5/2020
 */
public class PersonV1 {
    String name;

    public PersonV1() {
    }

    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
