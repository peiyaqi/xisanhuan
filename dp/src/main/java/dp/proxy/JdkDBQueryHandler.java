package dp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDBQueryHandler implements InvocationHandler {
    public static IDBQuery real = null;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        if(null == real){
            real = new DBQuery();
        }
        return real.request();
    }

    public static IDBQuery createJdkProxy(){
        IDBQuery jdkquery = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{IDBQuery.class},new JdkDBQueryHandler());
        return jdkquery;
    }

}
