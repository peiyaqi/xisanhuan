package dp.proxy;

import java.util.Random;

public class Tank implements  Moveable {
    @Override
    public void move() {
        System.out.println("Tank move clalalalla.....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Tank().move();
    }
}


interface Moveable{

    void move();
}
