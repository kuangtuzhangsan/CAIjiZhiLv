package com.xyx.decoratorPattern;

public class CoffeeShop {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.description() + " $" + simpleCoffee.cost());

        Coffee milkCoffee = new MilkDecorator(new SimpleCoffee());
        System.out.println(milkCoffee.description() + " $" + milkCoffee.cost());

        Coffee sugarMilkCoffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println(sugarMilkCoffee.description() + " $" + sugarMilkCoffee.cost());
    }
}

