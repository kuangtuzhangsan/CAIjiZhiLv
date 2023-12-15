package com.xyx.xuexi;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnsafeArrayListExample {

    public static void main(String[] args) throws InterruptedException {
        
        // 创建一个ArrayList
        List<Integer> unsafeList = new ArrayList<>();

        // 向ArrayList中添加元素的线程
        Thread addThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                unsafeList.add(i);
            }
        });

        // 从ArrayList中遍历并删除元素的线程
        Thread removeThread = new Thread(() -> {
            Iterator<Integer> iterator = unsafeList.iterator();
            while (iterator.hasNext()) {
                Integer number = iterator.next();
                if (number % 2 == 0) {
                    unsafeList.remove(number);
                }
            }
        });

        // 启动线程
        addThread.start();
        removeThread.start();

        // 等待两个线程执行完成
        addThread.join();
        removeThread.join();

        // 输出ArrayList的大小
        System.out.println("ArrayList size: " + unsafeList.size());

        Buffer buffer;
    }
}
