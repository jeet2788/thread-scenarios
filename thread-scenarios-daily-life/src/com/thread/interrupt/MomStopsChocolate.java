package com.thread.interrupt;

public class MomStopsChocolate {
    public static void main(String[] args) throws InterruptedException {

        GirlEatingChocolate girl = new GirlEatingChocolate();
        girl.start();

        Thread.sleep(4000); // mom waits for some time

        System.out.println("Mom: Stop eating chocolates now!");
        girl.interrupt(); // mom requests stop
    }
}
