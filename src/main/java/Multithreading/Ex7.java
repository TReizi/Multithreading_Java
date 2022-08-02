package Multithreading;

public class Ex7 extends Thread {

    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable1());
        Ex7 thread2 = new Ex7();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Конец!");

    }

}

class MyRunnable1 implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
