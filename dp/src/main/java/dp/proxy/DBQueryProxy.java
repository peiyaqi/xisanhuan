package dp.proxy;

public class DBQueryProxy implements  IDBQuery {
    private DBQuery dbQuery = null;

    @Override
    public String request() {
        if(null == dbQuery){
            dbQuery = new DBQuery();
        }
        return dbQuery.request();
    }
}
