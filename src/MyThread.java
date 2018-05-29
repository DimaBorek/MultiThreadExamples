import java.security.PublicKey;

public class MyThread extends Thread {
    public static void main(String[] args) {
       // threadsToSeeStack();
        joinUsage();
    }
     /* System.out.println("main thread started");
        MyThread mt = new MyThread("My Thread");
        mt.start();
        System.out.println("main Thread finished");
    }
   public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread);
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        System.out.println(thread.getThreadGroup().getName());
    } */
  public MyThread(String name){
      super(name);
  }
  @Override
    public void run(){
      System.out.println(String.format("Thread %s started",Thread.currentThread().getName()));
      try{
          Thread.sleep(10000);
      }catch (InterruptedException e){
          System.out.println("Thread interrupted");
      }
      System.out.println(String.format("Thread %s finished",Thread.currentThread().getName()));

  }
        public static void threadsToSeeStack(){
            System.out.println("main thread started");
            MyThread mt1 = new MyThread("MyThread 1 ");
            mt1.start();
            MyThread mt2 = new MyThread("MyThread 2 ");
            mt2.start();
            System.out.println("main thread finished");

        }
        public static void joinUsage(){
            System.out.println("main thread started");
            MyThread mt = new MyThread("My SampleThread");
            mt.start();
            try{
                mt.join();

            }catch (InterruptedException e){
                System.out.println("Thread interrupted");
            }
            System.out.println("main thread finished");
        }
}
