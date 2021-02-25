package disruptor.high.single;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TradePublisher implements Runnable {
    private CountDownLatch latch;
    private Disruptor<Trade> disruptor;
    private static int PUBLISH_COUNT = 1;
    public TradePublisher(CountDownLatch latch, Disruptor<Trade> disruptor) {
        this.latch=latch;
        this.disruptor=disruptor;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0;i < PUBLISH_COUNT; i++){
            disruptor.publishEvent(new TradeEventTranslator());
        }
        latch.countDown();
    }

}


class TradeEventTranslator implements EventTranslator<Trade>{

    private Random random = new Random();
    public void translateTo(Trade trade, long l) {
        this.generateTrade(trade);
    }

    private void generateTrade(Trade trade) {
        trade.setPrice(random.nextDouble());
    }
}
