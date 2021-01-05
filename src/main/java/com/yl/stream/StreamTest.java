package com.yl.stream;

import com.yl.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: 袁黎
 * @create: 2020-06-24 15:32
 **/
public class StreamTest {

    @Test
    public void test0() {
        List<Employee> employeeList = new ArrayList<Employee>();
        Employee employee1 = new Employee("张三", 14);
        Employee employee2 = new Employee("张三", 15);
        Employee employee3 = new Employee("张三", 16);
        Employee employee4 = new Employee("张三", 17);
        Employee employee5 = new Employee("张三", 14);

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);


        //System.out.println(empList);

        employeeList = employeeList.stream().filter(a -> a.getAge() != 14).collect(Collectors.toList());

        employeeList.forEach(a -> System.out.print(a));
        System.out.println("");
        // empList.forEach(System.out::print);
    }

    public String test1() {
        System.out.println("");
        return "hello world";
    }


}
