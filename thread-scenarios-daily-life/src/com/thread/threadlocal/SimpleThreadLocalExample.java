package com.thread.threadlocal;

public class SimpleThreadLocalExample {
     static void main(){

         Runnable task1 = () -> {
             UserContextHolder.user.set(new UserContext("Alice"));
             printUser();
             UserContextHolder.user.remove();
         };

         Runnable task2 = () ->{
           UserContextHolder.user.set(new UserContext("Bob"));
           printUser();
           UserContextHolder.user.remove();
         };
         new Thread(task1,"Thread_1").start();
         new Thread(task2,"Thread_2").start();

    }
    static void printUser(){
        System.out.println(
              Thread.currentThread().getName() + " -> "+UserContextHolder.user.get().userName
        );
    }
}
