package com.damithtech.springbootbasic.model;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author DAMITH SAMARAKOON on 7/24/2020
 */
public class User {
    private Integer id;

    //validate user name character
    @Size(min = 2 , message = "name should have @ least two characters")
    private String name;

    //validate user BD for past date
    @Past(message = "birtdate should have past date")
    private Date birthDate;

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
