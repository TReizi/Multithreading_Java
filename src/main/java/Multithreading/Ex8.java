package Multithreading;

public class Ex8 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Methods main begins");
        Thread thread = new Thread(new Worker());
        thread.start();
        thread.join(4000);
        System.out.println("Methods main ends");


    }
}


class Worker implements Runnable{
    public void run(){
        System.out.println("Work begins");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work ends");
    }
}
