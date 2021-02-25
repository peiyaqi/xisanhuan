package dp.observer;

public class Child {
}

class Dad implements Observer{
    @Override
    public void actionOnWakeUp() {
        System.out.println("dad feeding");
    }
}

class Mam implements Observer{
    @Override
    public void actionOnWakeUp() {
        System.out.println("mom feeding");
    }
}

interface Observer{
    void  actionOnWakeUp();
}
