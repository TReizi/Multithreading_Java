package Multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(5);

        new Person("Artem",callBox);
        new Person("Oleg",callBox);
        new Person("Zaur",callBox);
        new Person("Olga",callBox);
        new Person("Elena",callBox);

    }
}


class Person extends Thread{
    String name;
    private Semaphore callBox;
    public Person(String name, Semaphore callBox){
        this.name = name;
        this.callBox = callBox;
        this.start();
    }
    public void run(){

        try {
            System.out.println(name+" ждёт ...");
            callBox.acquire();
            System.out.println(name+" пользуется телефоном");
            sleep(2000);
            System.out.println("Поговорил "+name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}