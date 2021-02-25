package disruptor.quickstart;

import com.lmax.disruptor.EventHandler;

public class OrderEventHandler implements EventHandler<OrderEvent> {
    public void onEvent(OrderEvent o, long l, boolean b) throws Exception {
        System.out.println("somethings"+o.getValue());
    }
}
