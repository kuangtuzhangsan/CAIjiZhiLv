package com.xyx.permissionsPackage.package1;


/**
 * Java中，可以使用访问控制符来保护对类、变量、方法和构造方法的访问。Java 支持 4 种不同的访问权限。
 *
 * default (即默认，什么也不写）: 在同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法。
 * private : 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
 * public : 对所有类可见。使用对象：类、接口、变量、方法
 * protected : 对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
 */
public class Myclass1 {

    public interface MyInterface {
        void myMethod();
    }
    public class MyInterfaceImpl implements MyInterface {
        @Override
        public void myMethod() {
            System.out.println("Implementation of myMethod");
        }
    }
    // 提供一个公共方法返回 Photo 接口的实例
    public MyInterface createPhotoInstance() {
        return new MyInterfaceImpl();
    }

}
