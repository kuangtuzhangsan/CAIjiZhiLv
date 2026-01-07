package com.xyx.permissionsPackage.package1.package3;

import com.xyx.permissionsPackage.package1.MyInterface;
import com.xyx.permissionsPackage.package1.MyInterfaceImpl;
import com.xyx.permissionsPackage.package1.Myclass1;

public class MyClass3 {
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
