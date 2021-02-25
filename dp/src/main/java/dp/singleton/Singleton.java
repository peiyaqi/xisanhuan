package dp.singleton;

public class Singleton {
    private static volatile Singleton instance = null;

    private Singleton(){}

    public static Singleton getInstance() {
        if (null == instance){
            synchronized (Singleton.class){
                if(null == instance){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
