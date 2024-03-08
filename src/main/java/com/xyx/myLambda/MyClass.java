package com.xyx.myLambda;

interface MyInterface {
    void myMethod1();

    void myMethod2();

    // 默认方法
    default void defaultMethod() {
        System.out.println("Default implementation of defaultMethod");
    }
}

//在这个例子中，使用了匿名类来实现 MyInterface 接口。这是因为 MyInterface 中有两个抽象方法，所以无法使用 Lambda 表达式。如果你需要在接口中使用 Lambda 表达式，确保接口只有一个抽象方法。
public class MyClass {
    public static void main(String[] args) {
        // 使用匿名类实现接口
        MyInterface myInterface = new MyInterface() {
            @Override
            public void myMethod1() {
                System.out.println("Executing myMethod1");
            }

            @Override
            public void myMethod2() {
                System.out.println("Executing myMethod2");
            }
        };

        // 调用方法
        myInterface.myMethod1();
        myInterface.myMethod2();
        myInterface.defaultMethod(); // 调用默认方法
    }
}
