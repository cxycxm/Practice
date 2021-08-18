package com.bwhome.basic.middle;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("action ... go again");
            }
        });
        for(int i = 0; i < 4; i++){
            Thread t = new Thread(new CyclicWorker(barrier));
            t.start();
        }
    }

}


class CyclicWorker implements Runnable{
   private CyclicBarrier barrier;
   public CyclicWorker(CyclicBarrier barrier){
       this.barrier = barrier;
   }
    @Override
    public void run() {
       for (int i = 0; i < 3; i++){
           System.out.println("Executed");
           try {
               // 每个线程都调用过await，才会继续执行
               barrier.await();
           } catch (InterruptedException e) {
               e.printStackTrace();
           } catch (BrokenBarrierException e) {
               e.printStackTrace();
           }
       }
    }
}
