package com.yl.optional.test3;

import org.junit.Test;

import java.util.Optional;

/**
 * @Author: 袁黎
 * @Date: 2020-10-28 09:46
 **/
public class TestClass {

    @Test
    public void test0(){
        System.out.println(test1());
    }

    public Person test1(){
        //常规判断
      /*  Person person = new Person();
        if(null == person){
            return new Person();
        }
        return person;*/

      // 使用Optional
        Person person = new Person("李四",4);
        return Optional.ofNullable(person).orElse(new Person("张三",1));

    }



}
