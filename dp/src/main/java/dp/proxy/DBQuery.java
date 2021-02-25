package dp.proxy;

public class DBQuery implements IDBQuery {
    public DBQuery(){
        System.out.println("new DBQuery");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String request() {
        return "DBQuery request";
    }
}



