package com.xyx.threadPractise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReportTimemeoutStatisticsPoolTask {

    // 创建一个固定大小的线程池
    private final ExecutorService executorService;

    // 构造方法，初始化线程池
    public ReportTimemeoutStatisticsPoolTask(int poolSize) {
        this.executorService = Executors.newFixedThreadPool(poolSize);
    }

    // 提交任务给线程池执行
    public void submitTask(Runnable task) {
        executorService.submit(task);
    }
    public void submitTask(int taskNumber) {
        executorService.submit(() -> run(taskNumber));
    }

    // 关闭线程池
    public void shutdown() {
        executorService.shutdown();
        try {
            // 等待现有任务完成
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                // 等待强制终止
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("线程池未能终止");
            }
        } catch (InterruptedException ie) {
            // 重新调用 shutdownNow
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        // 创建线程池示例对象，初始化线程池大小为 5
        ReportTimemeoutStatisticsPoolTask threadPool = new ReportTimemeoutStatisticsPoolTask(5);

        // 提交10个任务给线程池执行
        for (int i = 0; i < 10; i++) {
            final int taskNumber = i;
            threadPool.submitTask(() -> {
                System.out.println("正在执行任务 " + taskNumber + " 线程: " + Thread.currentThread().getName());
                try {
                    // 模拟任务执行时间
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("任务 " + taskNumber + " 被中断");
                }
            });
            threadPool.submitTask(i);
        }

        // 关闭线程池
        threadPool.shutdown();
    }

    // 线程池执行的任务逻辑
    private void run(int taskNumber) {
        System.out.println("正在执行任务 " + taskNumber + " 线程: " + Thread.currentThread().getName());
        try {
            // 模拟任务执行时间
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("任务 " + taskNumber + " 被中断");
        }
    }
}
