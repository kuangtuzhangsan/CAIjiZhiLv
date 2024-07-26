package com.xyx.threadPractise;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class practiseCompletableFuture {
    public static void main(String[] args) {
        // 创建两个异步任务
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");

        // 组合两个任务的结果
        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (result1, result2) -> result1 + " " + result2);

        // 异步获取组合结果
        combinedFuture.thenAcceptAsync(result -> System.out.println(result));

        // 关闭线程池
        Executors.newFixedThreadPool(2).shutdown();
    }
}

