package disruptor.high.single;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class Handler2 implements EventHandler<Trade>,WorkHandler<Trade> {
    public void onEvent(Trade trade) throws Exception {
        trade.setName("h2");
        System.out.println("handler2");
    }

    public void onEvent(Trade trade, long l, boolean b) throws Exception {
        this.onEvent(trade);
    }
}
