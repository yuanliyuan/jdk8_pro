package com.yl.optional.test2;

import com.yl.optional.test1.Teacher;
import org.junit.Test;

import java.util.Optional;

/**
 * @author: 袁黎
 * @create: 2020-08-03 16:04
 **/
public class OptionalTest2 {


    /**
     * 条件为true就执行
     */
    @Test
    public void test1() {
        //优化前
        String person = "who are you";
        if (person != null) {
            System.out.println(person);
        }
        //优化后
        Optional<String> optional = Optional.of("who are you ");
        optional.ifPresent(System.out::println);
    }

    /**
     * 条件为true就返回,false返回默认值
     */
    @Test
    public void test2() {

        //优化前
        String person = null;
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("返回默认值");
        }

        //优化后
        Optional<String> optional = Optional.of(null);
        String str = optional.orElse("返回默认值");
        System.out.println(str);

    }

    /**
     * 连环null检查
     */
    @Test
    public void test3() {

        //优化前
        Teacher teacher = new Teacher("张三", "1");
        if (null != teacher) {
            String name = teacher.getName();
            if (null != name) {
                System.out.println("name = " + name);
            } else {
                System.out.println("name为null");
            }
        } else {
            System.out.println("teacher为null");
        }

        //优化后
        // Optional<Teacher> optional = Optional.ofNullable(new Teacher("zhangsan", "1"));
        Optional<Teacher> optional = Optional.ofNullable(null);

        String s = optional.map(p -> p.getName()).map(name -> name.toUpperCase()).orElse(null);
        System.out.println(s);

    }


}
