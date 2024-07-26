package com.xyx.threadPractise;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 提交任务并获取Future对象
        Future<String> future = executorService.submit(() -> {
            return "Hello, ExecutorService!";
        });

        Future<String> future2 = executorService.submit(() -> {
            return "Hello, ExecutorService!";
        });

        // 获取任务执行结果（阻塞等待）
        try {
            String result = future.get();
            String result2 = future2.get();
            for (int i = 0; i < 10; i++) {
                System.out.println("Task result "+ i+ "==" + result);
                System.out.println( System.currentTimeMillis() );
            }
            System.out.println("Task result: " + result);
//            System.out.println("Task result2: " + result2);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 关闭线程池
        executorService.shutdown();

    }
}
