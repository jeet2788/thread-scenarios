package com.thread.join.petrolpump;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CustomerQueueManager {
    private static ConcurrentLinkedQueue<CustomerThread> tQueue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) throws InterruptedException {
        //added customer for taking Petrol
        for (int i = 0; i < 10; i++) tQueue.add(new CustomerThread());
        //Polling top customer from the Queue to finish payment and take Petrol
        for (int i = 0; i < 10; i++) {
            CustomerThread customer = tQueue.poll();
            if(customer==null) {
                do {
                    synchronized (tQueue) {tQueue.wait();}
                    customer = tQueue.poll();
                }while(customer==null); break;
            }
            //we have started the thread
            customer.start();
            //join method will not allow Thread 2 to start its work until Thread 1 finished its work and so on.
            customer.join();
        }

    }
}
