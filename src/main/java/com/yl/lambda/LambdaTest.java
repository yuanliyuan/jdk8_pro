package com.yl.lambda;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author yuanli
 * @create 2020-06-21 16:07
 **/
public class LambdaTest {

    @Test
    public void test0() {

        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("jdk7以前的写法");
            }
        };
        run.run();

        System.out.println("----------------------------------------------------------");
        Runnable run2 = () -> System.out.println("jdk1.8 lambda表达式");
        run2.run();
    }

    @Test
    public void test1() {

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(1, 2);
        System.out.println("jdk8之前的写法:" + compare1);

        System.out.println("---------------------------------------------------------");

        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        int compare2 = com2.compare(1, 2);
        System.out.println("Lambda表达式:" + compare2);

        System.out.println("*****************************************8");

        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com3.compare(1, 2);
        System.out.println("方法引用:" + compare3);

    }


}