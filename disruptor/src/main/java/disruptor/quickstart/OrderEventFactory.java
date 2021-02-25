package disruptor.quickstart;

import com.lmax.disruptor.EventFactory;

public class OrderEventFactory implements EventFactory<OrderEvent> {

    public OrderEvent newInstance() {
        return new OrderEvent();
    }
}
