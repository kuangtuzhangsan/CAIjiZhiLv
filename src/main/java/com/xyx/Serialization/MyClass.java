package com.xyx.Serialization;
import java.io.*;

public class MyClass implements Serializable {
    private static final long serialVersionUID = 1L;

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    private int intValue;
    private String stringValue;

    public MyClass() {
    }

    // 构造方法、getter 和 setter 略...

    public static void main(String[] args) {
        // 序列化
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            MyClass obj = new MyClass();
            obj.setIntValue(42);
            obj.setStringValue("Hello, Serialization!");

            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 反序列化
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"))) {
            MyClass obj = (MyClass) ois.readObject();
            System.out.println(obj.getIntValue());
            System.out.println(obj.getStringValue());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

