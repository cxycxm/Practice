package com.bwhome.basic.middle;

import java.util.concurrent.Semaphore;

public class SemaphonreWorker implements Runnable {

    private String name;
    private Semaphore semaphore;

    public SemaphonreWorker(Semaphore semaphore){
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        try {
            log("is waiting for a permit");
            semaphore.acquire();
            log("acquired a permit");
            log("executed");
        } catch (InterruptedException e) {
           e.printStackTrace();
        }finally {
            log("released a permit");
            semaphore.release();
        }
    }

    private void log(String msg){
        if (name == null){
            name = Thread.currentThread().getName();
        }
        System.out.println(name + "_" + msg);
    }
}
