package com.xyx.thread;

public class ABCPrinter {
    private static final int MAX_COUNT = 10; // 打印次数
    private static Object lock = new Object();
    private static volatile int currentThread = 1;

    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintTask("A", 1));
        Thread threadB = new Thread(new PrintTask("B", 2));
        Thread threadC = new Thread(new PrintTask("C", 3));

        threadA.start();
        threadB.start();
        threadC.start();
    }

    static class PrintTask implements Runnable {
        private String text;
        private int threadId;

        public PrintTask(String text, int threadId) {
            this.text = text;
            this.threadId = threadId;
        }

        @Override
        public void run() {
            for (int i = 0; i < MAX_COUNT; i++) {
                synchronized (lock) {
                    while (currentThread != threadId) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.print(text);
                    if (threadId == 3) {
                        System.out.println(); // 在 C 线程打印完 "c" 后换行
                    }
                    currentThread = (currentThread % 3) + 1;
                    lock.notifyAll();
                }
            }
        }
    }
}

