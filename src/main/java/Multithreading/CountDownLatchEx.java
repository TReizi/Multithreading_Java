package Multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    private static void marketStaffOnPlace() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Market staff came to work");
        countDownLatch.countDown();
        System.out.println("countDownLatch" +countDownLatch.getCount());
    }
    private static void everythingIsReade() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Everything is ready, so let's open market ");
        countDownLatch.countDown();
        System.out.println("countDownLatch" +countDownLatch.getCount());
    }
    private static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Market is Open");
        countDownLatch.countDown();
        System.out.println("countDownLatch" +countDownLatch.getCount());
    }
    public static void main(String[] args) throws InterruptedException {
        new Friend("Artem", countDownLatch);
        new Friend("Oleg", countDownLatch);
        new Friend("Elena", countDownLatch);
        new Friend("Marina", countDownLatch);


        marketStaffOnPlace();
        everythingIsReade();
        openMarket();

    }
}


class Friend extends Thread{
    String name;
    private CountDownLatch countDownLatch;
    public Friend(String name, CountDownLatch countDownLatch){
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();

    }
    public void run(){
        try {
            countDownLatch.await();
            System.out.println(name +" Приступил к закупке.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}