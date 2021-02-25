package disruptor.high.single;

import com.lmax.disruptor.EventHandler;

public class Handler1 implements EventHandler<Trade> {
    public void onEvent(Trade trade, long l, boolean b) throws Exception {
        System.out.println("handler1");
    }
}
