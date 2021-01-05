package com.yl.optional.test3;

import lombok.Data;

/**
 * @Author: 袁黎
 * @Date: 2020-10-28 09:45
 **/

@Data
public class Person {

    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
