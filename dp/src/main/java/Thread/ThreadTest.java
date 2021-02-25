package Thread;

import dp.proxy.IDBQuery;
import dp.proxy.JdkDBQueryHandler;

import java.lang.reflect.Array;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {

    public static AtomicInteger te = new AtomicInteger();
    public static void main(String[] args)  {
        MyTr task = new MyTr();
        task.start();
        synchronized (te){
            try {
                System.out.println("before waiting");
                te.wait();
                System.out.println("after waiting");
                System.out.println(te.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("before print");
        System.out.println(te.get());
    }
    static class MyTr extends  Thread{
        @Override
        public void run(){
            synchronized (te){
                System.out.println("before notify");
                te.notify();
                System.out.println("after notify");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                te.set(1);
//                System.out.println("after set");
            }

        }
    }
}
