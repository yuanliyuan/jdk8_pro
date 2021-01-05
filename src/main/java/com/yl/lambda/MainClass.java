package com.yl.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) {

        Student student = new Student("张三", 18);
        Student student1 = new Student("李四", 18);
        Student student2 = new Student("王五", 18);
        Student student3 = new Student("赵六", 18);

        List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student1);
        list.add(student2);
        list.add(student3);


        Student student4 = new Student("张三", 18);
        Student student5 = new Student("李四", 18);
        Student student6 = new Student("王八", 18);

        List<Student> list2 = new ArrayList<>();
        list2.add(student4);
        list2.add(student5);
        list2.add(student6);

        // list 参数传过来的
        // list2 老的

        // 参数中和老的都存在的部分
        List<Student> updates = list.stream().filter(list2::contains).collect(Collectors.toList());
        System.out.println("不变的部分");
        updates.forEach(System.out::println);

        System.out.println("新增部分");
        List<Student> inserts = list.stream().filter(x -> !list2.contains(x)).collect(Collectors.toList());
        inserts.forEach(System.out::println);

        List<Student> deletes = list2.stream().filter(x -> !list.contains(x)).collect(Collectors.toList());
        System.out.println("删除的部分");
        deletes.forEach(System.out::println);
    }
}
