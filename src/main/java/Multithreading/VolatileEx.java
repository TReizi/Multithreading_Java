package Multithreading;

public class VolatileEx extends Thread{
   volatile boolean b = true;

    public void run(){
        long counter = 0;
        while(b){
            counter++;
        }
        System.out.println("Loop is finished. Counter = "+counter);
    }


    public static void main(String[] args) throws InterruptedException {
        VolatileEx thread  = new VolatileEx();
        thread.start();
        Thread.sleep(3000);
        System.out.println("Поток main поработал 3 секунды. ");
        thread.b = false;
        thread.join();
        System.out.println("Программа закончила свое выполнение.");
    }
}
