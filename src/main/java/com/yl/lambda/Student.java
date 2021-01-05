package com.yl.lambda;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class Student implements Serializable {

    private static final long serialVersionUID = -5346657893361738629L;

    private String name;

    private Integer age;

    private Integer score;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return getName().equals(student.getName()) &&
                getAge().equals(student.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }
}
