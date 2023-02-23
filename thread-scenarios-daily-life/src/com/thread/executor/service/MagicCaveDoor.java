package com.thread.executor.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MagicCaveDoor {
    public static void main(String[] args){

        Runnable[] methods = new Runnable[]{
                new Runnable(){  // Object wrapper for Person a
                    @Override
                    public void run(){  // Person a
                        System.out.println("Cave Door opens & Person A pull the treasure");
                    }
                },
                new Runnable(){  // Object wrapper for waiting
                    @Override
                    public void run(){   // method to wait for 10s
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                },
                new Runnable(){  // Object wrapper for Person b
                    @Override
                    public void run(){  // method b
                        System.out.println("Cave Door opens & Person B pull the treasure");
                    }
                }
        };

        ExecutorService service = Executors.newSingleThreadExecutor();
        for(Runnable r : methods)
            service.submit(r);
        service.shutdown();

        // Wait until all threads are finish
        while (!service.isTerminated()) {}
        System.out.println("\nEveryone pulled sufficient treasure");
    }
}
