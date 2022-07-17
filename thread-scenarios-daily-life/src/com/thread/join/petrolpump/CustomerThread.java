package com.thread.join.petrolpump;

public class CustomerThread extends Thread{
    private static int customerCount = 0;

    public static synchronized int takePetrolAndPay() {
        return customerCount++;
    }
    @Override
    public void run() {
        System.out.println("Customer "+takePetrolAndPay()+" take Petrol & leaves  the Pump");
    }
}
