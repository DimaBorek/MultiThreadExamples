package com.company;

public class MyRunnable implements Runnable {

private boolean isActive;
void disable(){
isActive = false;
}
MyRunnable(){
isActive = true;

}

    @Override
    public void run() {
        System.out.println(String.format("Thread %s started", Thread.currentThread().getName()));
        int counter = 1;
        while (isActive) {
            System.out.println("loop number = " + counter++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("thread interrupted");
            }
            System.out.println(String.format("Thread %s finished", Thread.currentThread().getName()));
        }
    }

    public static void main(String[] args) {
      /*  System.out.println("main started");
        Thread thread = new Thread(new MyRunnable(),"MyRunnable");
        thread.start();
        System.out.println("main finished");*/
        System.out.println("main started");
        MyRunnable mR = new MyRunnable();
        new Thread(mR,"MyRunnable").start();
        try{
            Thread.sleep(1100);

            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("main finished");
        }

    }
}
