package com.xyx.threadPractise;

public class MyThread extends Thread {
    public void customMethod() {
        System.out.println("Custom method called by thread: " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        // 线程执行的任务逻辑
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        // 调用自定义方法
        myThread.customMethod();

        // 启动线程，会执行 run 方法中的逻辑
        myThread.start();
    }
}

