package com.xyx.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

    private String name;

    Example(String name){
        this.name = name;
    }

    public static void main(String[] args) {
//        InterfaceExample com =  Example::new;
        InterfaceExample com = name -> new Example(name);
        Example bean = com.create("hello world");
        System.out.println(bean.name);

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        filtered.forEach(System.out::println);
    }
}
interface InterfaceExample{
    Example create(String name);
}

