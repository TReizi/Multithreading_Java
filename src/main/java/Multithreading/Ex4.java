package Multithreading;

public class Ex4 {
    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5();
        //переопределили имя и приоритет потока  5
        myThread5.setName("moy_potok");
        //myThread5.setPriority(9);
        myThread5.setPriority(Thread.NORM_PRIORITY);
        System.out.println("Name of myThread5 = "+myThread5.getName()+
                " Priority of myThread5 = "+myThread5.getPriority());




        MyThread5 myThread6 = new MyThread5();
        System.out.println("Name of myThread6 = "+myThread6.getName()+
                " Priority of myThread6 = "+myThread6.getPriority());
    }
}

class MyThread5 extends Thread{
    public void run(){
        System.out.println("Privet");
    }
}
