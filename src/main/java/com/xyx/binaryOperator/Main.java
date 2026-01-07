package com.xyx.binaryOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 *
 在使用 Collectors.toMap() 方法进行转换为 Map 时，确实需要传递一个合适的合并函数（BinaryOperator）作为第三个参数，
 以处理相同 key 的情况。如果相同的 key 出现在原始数据中，而没有提供合并函数，会导致 IllegalStateException 异常。

 以下是一个示例，演示了如何使用 toMap() 方法，并提供一个简单的合并函数来处理相同 key 的情况：
 */
public class Main {
    public static void main(String[] args) {
        // 示例数据
        List<Person> persons = Arrays.asList(
                new Person(1, "Alice"),
                new Person(2, "Bob"),
                new Person(1, "Charlie")
        );

        // 转为 Map，提供合并函数处理相同 key 的情况
        Map<Integer, String> idToNameMap = persons.stream()
                .collect(Collectors.toMap(
                        Person::getId,         // key 映射
                        Person::getName,       // value 映射
                        // 合并函数，如果有相同的 key，选择一个值
                        (existing, replacement) -> existing
                ));

        // 输出结果
        idToNameMap.forEach((id, name) -> System.out.println("ID: " + id + ", Name: " + name));

        /**
         * 确实，ArrayList 的 subList 返回的是 java.util.RandomAccessSubList，而不是 ArrayList 的实例，因此尝试将其强制转换为 ArrayList 会导致 ClassCastException 异常。
         *
         * 如果确实需要将 subList 的结果转换为 ArrayList，可以通过以下方式：
         */
        // 创建一个 ArrayList
        ArrayList<Integer> originalList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // 使用 subList 获取一个范围
        List<Integer> subList = originalList.subList(1, 4);

        // 将 subList 转换为新的 ArrayList
        ArrayList<Integer> newList = new ArrayList<>(subList);

        // 输出结果
        System.out.println("Original List: " + originalList);
        System.out.println("SubList: " + subList);
        System.out.println("New List: " + newList);

        List<String> params = new ArrayList<>();
        System.out.println(params.toArray());
    }

    static class Person {
        private final int id;
        private final String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

}


