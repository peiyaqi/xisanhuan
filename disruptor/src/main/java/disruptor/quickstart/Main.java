package disruptor.quickstart;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        OrderEventFactory orderEventFactory = new OrderEventFactory();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        // 实例化 disruptor 对象
        Disruptor<OrderEvent> disruptor = new Disruptor<OrderEvent>(orderEventFactory, 1024 * 1024, executor,
                ProducerType.SINGLE, new BlockingWaitStrategy());
        // 添加消费者监听
        disruptor.handleEventsWith(new OrderEventHandler());
        // 启动
        disruptor.start();
        // 获取容器
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();

        OrderEventProducer producer = new OrderEventProducer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);
        for (int i =0;i<100; i++){
            bb.putLong(0,i);
            producer.sendData(bb);
        }
        disruptor.shutdown();
        executor.shutdown();
    }
}
