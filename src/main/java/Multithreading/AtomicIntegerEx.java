package Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerEx {
  //  static int counter = 0;


    static AtomicInteger counter = new AtomicInteger(0);
    public  static void increment(){
     //   counter++;
//        counter.incrementAndGet();
        counter.addAndGet(5);//Прибавь пятерку и верни(можем увеличивать на N-е количество) или поставить -5 чтоб отнимало
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1= new Thread(new MyRunnableImpl());
        Thread thread2 = new Thread(new MyRunnableImpl());

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();


        System.out.println(counter);
    }
}

class MyRunnableImpl implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            AtomicIntegerEx.increment();
        }
    }
}
