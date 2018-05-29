package com.company;



class CountThread implements Runnable {
    CommonResource cR;

    CountThread(CommonResource cR) {
        this.cR = cR;
    }

    public void run() {
        cR.increment();
    }
}

public class CommonResource {
    public int x;

    synchronized void increment() {
        x = 1;
        for (int i = 1; i < 5; i++) {
            System.out.println(String.format("%s %d", Thread.currentThread().getName(), x));
            x++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }


    public static class MainApp{

        public static void main(String[] args) {

            CommonResource cR = new CommonResource();
            for (int i=0 ;i<6;i++){
                Thread t = new Thread(new CountThread(cR));
                t.setName("thread" + i);
                t.start();
            }
        }
    }

}
