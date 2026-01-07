package com.xyx.permissionsPackage.package2;

import com.xyx.permissionsPackage.package1.MyInterface;
import com.xyx.permissionsPackage.package1.MyInterfaceImpl;
import com.xyx.permissionsPackage.package1.Myclass1;


/**
 * Java中，可以使用访问控制符来保护对类、变量、方法和构造方法的访问。Java 支持 4 种不同的访问权限。
 *
 * default (即默认，什么也不写）: 在同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法。
 * private : 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
 * public : 对所有类可见。使用对象：类、接口、变量、方法
 * protected : 对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
 */
public class Myclass2 {
    public static void main(String[] args) {
        Myclass1 obj = new Myclass1();
        // default 默认不在同一个包不能访问
        Myclass1.MyInterface myInterface = obj.createPhotoInstance();
        myInterface.myMethod();

        MyInterface myInterface1 = new MyInterface() {
            @Override
            public void myMethod() {
                System.out.println(" 999 ");
            }
        };
        myInterface1.myMethod();

        MyInterface myInterface2 = new MyInterfaceImpl();
        myInterface2.myMethod();

    }
}
