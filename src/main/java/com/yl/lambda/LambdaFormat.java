package com.yl.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author yuanli
 * @create 2020-06-21 16:15
 **/
public class LambdaFormat {

    //语法格式一:无参,无返回值,Lambda体只需执行一条语句
    @Test
    public void test1() {
        //1.8之前的写法
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("不用Lambda表达式的写法");
            }
        };
        run.run();
        //1.8之后,Lambda写法
        Runnable run2 = () -> System.out.println("Lambda表达式语法一:无参,无返回值,Lambda体只需执行一条语句");
        run2.run();
    }

    //语法格式二:有一个参数,并且没有返回值
    @Test
    public void teest2() {
        //1.8之前的写法
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("不用Lambda表达式的写法");
        //1.8之后,Lambda写法
        Consumer<String> con2 = (args) -> System.out.println(args);
        con2.accept("Lambda表达式语法二:有一个参数,并且没有返回值");
    }

    //语法三:只有一个参数时,参数的小括号可以省略
    @Test
    public void test3() {
        //1.8之前的写法
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("不用Lambda表达式的写法");
        //1.8之后,Lambda表达式的写法
        Consumer<String> con2 = System.out::println;
        con2.accept("Lambda语法表达式三:只有一个参数时,参数的小括号可以省略");
    }

    //语法四:Lambda需要两个参数,多条执行语句,并且有返回值
    @Test
    public void test4() {
        //1.8之前的写法
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("不用Lambda表达式的写法");
                return o1.compareTo(o2);
            }
        };
        Integer resutlt = com.compare(1, 2);
        //1.8之后的写法
        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println("Lambda表达式语法四:Lambda需要两个参数,多条执行语句,并且有返回值");
            return o1.compareTo(o2);
        };
        Integer resutlt2 = com2.compare(1, 2);
    }

    //语法五:Lambda需要两个参数,一条执行语句,并且有返回值
    @Test
    public void test5() {
        //1.8之前的写法
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        int compare = com.compare(1, 2);
        System.out.println("不用Lambda表达式的写法" + compare);
        //1.8之后的写法
        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        int compare1 = com2.compare(1, 2);
        System.out.println("Lambda语法五:Lambda需要两个参数,一条执行语句,并且有返回值");
    }

}
