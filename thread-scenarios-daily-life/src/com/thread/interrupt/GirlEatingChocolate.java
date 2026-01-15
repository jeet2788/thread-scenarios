package com.thread.interrupt;

public class GirlEatingChocolate extends  Thread{
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Girl: Eating chocolate..");
                Thread.sleep(1000); // eating takes time
            }
        } catch (InterruptedException e) {
            System.out.println("Girl: Mom interrupted me!");
        }

        System.out.println("Girl: Okay mom, I’ll stop eating chocolates");
    }
}
