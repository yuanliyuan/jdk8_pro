package com.yl.map;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: 袁黎
 * @Date: 2020-08-18 17:10
 **/
public class StreanFlatMapTest {

    // map 对应的是一对一的场景,还有一些场景是一对多的场景,这是需要flatMap

    @Test
    public void test1() {

        Stream<List<Integer>> listStream = Stream.of(
                Collections.singletonList(1),
                Collections.singletonList(2),
                Arrays.asList(3, 4, 5)
        );
        Stream<Integer> integerStream = listStream.flatMap(Collection::stream);
        List<Integer> collect = integerStream.collect(Collectors.toList());
        collect.forEach(System.out::println);

        //flatMap把input Stream中的层级结构扁平化,就是将最底层元素抽出来放到一起,
        // 最终output的新Stream里面没有List了,都是直接的数字


    }
}
