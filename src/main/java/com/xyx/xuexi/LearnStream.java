package com.xyx.xuexi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LearnStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("周杰伦");
        list.add("王力宏");
        list.add("陶喆");
        list.add("林俊杰");
        Stream<Integer> stream = list.stream().map(s -> s.length());
        stream.forEach(System.out::println);
    }
}
