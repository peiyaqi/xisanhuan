package disruptor.high.single;

import com.lmax.disruptor.EventFactory;

public class TradeFactory implements EventFactory<Trade> {
    public Trade newInstance() {
        return new Trade();
    }
}
