package com.yl.map;

import lombok.Data;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: 袁黎
 * @Date: 2020-08-18 16:45
 * <p>
 * map的作用就是把input stream 的每一个元素映射成output stream的另一个元素
 **/
public class StreamMapTest {


    /**
     * 转大写
     */
    @Test
    public void test1() {

        List<String> list = Arrays.asList("a", "b", "c", "d");
        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     * 求平方
     */
    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> collect = list.stream().map(n -> n * n).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


    /**
     * 对象列表 -> 字符串列表
     */
    @Test
    public void test3() {

        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        // Before Java8
        List<String> result = new ArrayList<>();
        staff.forEach(x -> result.add(x.getName()));
        System.out.println(result);

        List<String> collect = staff.stream().map(Staff::getName).collect(Collectors.toList());
        System.out.println(collect);

    }

    /**
     * list转map
     */
    @Test
    public void listToMap() {
        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        Map<String, Integer> collect = staff.stream().collect(Collectors.toMap(Staff::getName, Staff::getAge));
        System.out.println(collect);

    }

    /**
     * 对象列表 -> 其他对象列表
     * 此例说明如何将staff对象列表转换为StaffPublic对象列表
     */
    @Test
    public void test4() {
        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        // jdk8之前
        List<StaffPublic> staffPublics = converToStaffPublic(staff);
        System.out.println(staffPublics);

        // jdk8之后
      /*  List<StaffPublic> collect = staff.stream().map(x -> {
            StaffPublic staffPublic = new StaffPublic();
            staffPublic.setAge(x.getAge());
            staffPublic.setName(x.getName());
            if ("mkyong".equals(x.getName())) {
                staffPublic.setExtra("this field is for mkyong only!");
            }
            return staffPublic;
        }).collect(Collectors.toList());*/

        List<StaffPublic> collect = staff.stream().map(StaffPublic::new).collect(Collectors.toList());

        System.out.println(collect);

    }

    private List<StaffPublic> converToStaffPublic(List<Staff> staff) {

        List<StaffPublic> result = new ArrayList<>();

        staff.forEach(x -> {
            StaffPublic staffPublic = new StaffPublic(x);
            if ("mkyong".equals(x.getName())) {
                staffPublic.setExtra("this field is for mkyong only!");
            }
            result.add(staffPublic);
        });

        return result;
    }

    @Data
    class Staff {
        private String name;
        private int age;
        private BigDecimal salary;

        public Staff(String name, int age, BigDecimal salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }
    }

    @Data
    class StaffPublic {
        private String name;
        private int age;
        private String extra;

        StaffPublic(Staff staff) {
            this.name = staff.getName();
            this.age = staff.getAge();
        }
    }
}
