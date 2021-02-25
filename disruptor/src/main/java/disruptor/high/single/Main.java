package disruptor.high.single;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(1);

        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("i"+i);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Disruptor<Trade> disruptor = new Disruptor<Trade>(new TradeFactory(),1024*1024,executor
                                        , ProducerType.SINGLE,new BusySpinWaitStrategy());
        // 串行
        //disruptor.handleEventsWith(new TradeHandler()).handleEventsWith(new Handler2()).handleEventsWith(new Handler1());
        // 并行
//        disruptor.handleEventsWith(new TradeHandler(),new Handler2(),new Handler1());
//        disruptor.handleEventsWith(new Handler2());
//        disruptor.handleEventsWith(new Handler1());
        // 菱形 1
//        disruptor.handleEventsWith(new TradeHandler(),new Handler1()).handleEventsWith(new Handler2());
        // 菱形 2
//        EventHandlerGroup<Trade> ehGroup = disruptor.handleEventsWith(new TradeHandler(), new Handler1());
//        ehGroup.then(new Handler2());
        // 六边形
        TradeHandler h = new TradeHandler();
        Handler1 h1 = new Handler1();
        Handler2 h2 = new Handler2();
        Handler3 h3 = new Handler3();
        disruptor.handleEventsWith(h1,h);
        disruptor.after(h1).handleEventsWith(h2);
        disruptor.after(h).handleEventsWith(h3);
        disruptor.after(h2,h3).handleEventsWith(new Handler5());
        RingBuffer<Trade> ringBuffer = disruptor.start();
        CountDownLatch latch = new CountDownLatch(1);
        es.submit(new TradePublisher(latch,disruptor));

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        disruptor.shutdown();
        es.shutdown();
        executor.shutdown();
    }
}
