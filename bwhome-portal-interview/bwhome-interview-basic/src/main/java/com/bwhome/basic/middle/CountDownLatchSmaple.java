package com.bwhome.basic.middle;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchSmaple {
    public static void main(String[] args) throws InterruptedException {
        // 初始化count为5
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++){
            Thread t = new Thread(new FirstBatchWroker(latch));
            t.start();
        }
        for (int i = 0; i < 5; i++){
            Thread t = new Thread(new SecondBatchWroker(latch));
            t.start();
        }
        latch.await();
        Thread.sleep(100L);
        System.out.println("wait for first batch finish");
    }
}

class FirstBatchWroker implements Runnable{
    private CountDownLatch latch;
    public FirstBatchWroker (CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("first batch executed");
        // 给count-1
        latch.countDown();
    }
}

class SecondBatchWroker implements Runnable{
    private CountDownLatch latch;
    public SecondBatchWroker(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // 阻塞当前线程，直到latch的count=0；
            latch.await();
            System.out.println("second batch executed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
