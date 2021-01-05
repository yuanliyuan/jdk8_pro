package com.yl.optional.test1;

import lombok.Data;

/**
 * @author: 袁黎
 * @create: 2020-08-03 15:10
 **/
@Data
public class Teacher {

    private String name;
    private String id;

    public Teacher() {
    }

    public Teacher(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
