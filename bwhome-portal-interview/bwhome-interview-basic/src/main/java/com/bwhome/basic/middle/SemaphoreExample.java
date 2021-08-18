package com.bwhome.basic.middle;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        System.out.println("Action go");
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 100; i++){
            Thread t = new Thread(new SemaphonreWorker(semaphore));
            t.start();
        }
    }
}

