package com.yl.optional.test1;

import lombok.Data;
import org.junit.Test;

import java.util.Optional;
import java.util.function.BiFunction;


/**
 * @author: 袁黎
 * @create: 2020-08-03 15:16
 **/
public class OptionalTest {

    @Test
    public void test1() {
        System.out.println(String.format("%s", "hello"));
        //1.创建
        try {
            Optional<Teacher> optional = Optional.of(null);
        } catch (Exception e) {
            System.out.println(String.format("optional报错:%s", e.toString()));
        }

        try {
            //允许存放为null,不会报空指针的错误
            Optional<Teacher> optional2 = Optional.ofNullable(null);
        } catch (Exception e) {
            System.out.println("optional2报错" + e.toString());
        }
    }

    //2.空指针判断
    @Test
    public void test2() {
        Optional<Teacher> optional3 = Optional.ofNullable(null);
        if (!optional3.isPresent()) { // null时返回false, 非null时返回true
            System.out.println("这个是null");
        }

        Optional<String> optional4 = Optional.ofNullable(new String(""));
        if (!optional4.isPresent()) { //optional.isPresent() null时返回false, 非null时返回true
            System.out.println("这个是null");
        } else {
            System.out.println("这个不是null");
        }
    }

    @Test
    public void test3() {
        Optional<Teacher> optional5 = Optional.ofNullable(null);
        try {
            Teacher t = optional5.get();// 确定有对象时返回对象,否则报空指针异常的错
            System.out.println(t);
        } catch (Exception e) {
            System.out.println("optional5中没有对象,为null");
        }

        Optional<Teacher> optional6 = Optional.ofNullable(new Teacher("张三", "1"));
        Teacher teacher = optional6.get();
        System.out.println(teacher);


        Teacher t2 = optional5.orElse(new Teacher("李四", "2"));//对象非空返回对象,否则返回默认值
        System.out.println(t2);

        Teacher t3 = optional6.orElse(null);
        System.out.println(t3);


        Teacher t4 = optional5.orElseGet(() -> {

            String id = "3";
            String name = "王五";
            BiFunction<String, String, Teacher> function = Teacher::new;
            return function.apply(name, id);
        });

        System.out.println("t4: " + t4);
    }

    @Test
    public void test4() {
        Optional<String> optional = Optional.of("hello");
        optional.ifPresent(name -> System.out.println(name.length()));

    }

    @Test
    public void test5() {

        User user = new User();
        user.setName("张三");

        String result = getName(user);
        System.out.println(result);


    }

    public String getName(User user) {
        // 1.7 写法
       /* if (null == user) {
            return "UnKnown";
        }
        return user.getName();*/


        // 1.8 Optional写法
        return Optional.ofNullable(user)
                .map(user1 -> user.getName())
                .orElse("UnKnown");

    }


    @Test
    public void test6() {

        String result = getName7(null);
        System.out.println(result);


        Competition cm = new Competition();
        cm.setResult(null);


        String str = getName8(null);
        System.out.println(str);

    }


    /**
     * 1.7 写法
     *
     * @param cm
     * @return
     */
    private String getName7(Competition cm) {
        if (null != cm) {
            Result result = cm.getResult();
            if (null != result) {
                Champion champion = result.getChampion();
                if (null != champion) {
                    User user = champion.getUser();
                    if (null != user) {
                        return user.getName();
                    }
                }

            }
        }
        System.out.println("1");
        System.out.println("2");
        return "UnKnown";
    }

    /**
     * 1.8 写法
     *
     * @return
     */
    private String getName8(Competition cm) {

        return Optional.ofNullable(cm)
                .map(Competition::getResult)
                .map(Result::getChampion)
                .map(u -> u.getUser().getName())
                .orElse("UnKnown");
    }


    @Data
    private static class Competition {
        private Result result;
    }

    @Data
    private static class Result {
        private Champion champion;
    }

    @Data
    private static class Champion {
        private User user;
    }

    @Data
    private static class User {

        private String name;
    }

}
