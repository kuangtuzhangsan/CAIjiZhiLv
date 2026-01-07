package com.xyx.decoratorPattern;

public class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        System.out.println("执行cost");
        return 2.0;
    }

    @Override
    public String description() {
        System.out.println("执行description");
        return "Simple coffee";
    }

    public SimpleCoffee() {
        System.out.println("执行构造函数");
    }
}

