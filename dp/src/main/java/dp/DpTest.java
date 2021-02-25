package dp;

import dp.decorator.IPacketCreator;
import dp.decorator.PacketBodyCreator;
import dp.decorator.PacketDecorator;
import dp.decorator.PacketHTMLHeaderCreator;
import dp.proxy.DBQueryProxy;
import dp.proxy.IDBQuery;
import dp.proxy.JdkDBQueryHandler;
import dp.singleton.Singleton;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DpTest {

    public static void main(String[] args)  {

//        IDBQuery d = JdkDBQueryHandler.createJdkProxy();
//        System.out.println(d.request());
//        testProxy();

//        IPacketCreator pc = new PacketHTMLHeaderCreator(new PacketBodyCreator());
//        System.out.println(pc.handlerContent());
         Map<String,Object> aa = new HashMap<>();
         aa.put("asd", 1);
         aa.put("as1", BigDecimal.ZERO);
         aa.put("as2", 1.1);
        BigDecimal asd = new BigDecimal(""+aa.get("asd"));
        BigDecimal as1 = new BigDecimal(""+aa.get("as1"));
        BigDecimal as2 = new BigDecimal(""+aa.get("as2"));
        System.out.println(asd);
    }

    private static void testProxy() {
        IDBQuery query = new DBQueryProxy();
        System.out.println(query.request());
    }

    private static void testSingleton() {
        for (int i = 0; i < 10000; i++) {
            Singleton instance1;
            Thread th = new Thread( i+"1"){
                @Override
                public void run(){
                    Singleton instance = Singleton.getInstance();
                    System.out.println(Thread.currentThread().getName()+"===="+instance.hashCode());
                }
            };

            th.start();
        }
    }
}
