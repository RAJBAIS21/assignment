import com.messagequeueapp.Consumer;
import com.messagequeueapp.MessageProcessor;
import com.messagequeueapp.MessageQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ConsumerTest {
    private MessageQueue queue;
    private MessageProcessor processor;
    private Consumer consumer;

    @BeforeEach
    public void setUp() {
        queue = new MessageQueue();
        processor = new MessageProcessor();
        consumer = new Consumer(queue, processor);
    }

    @Test
    public void testRun() {
        Thread consumerThread = new Thread(consumer);
        assertDoesNotThrow(consumerThread::start);
        consumerThread.interrupt();
    }

    @Test
    public void testStop() {
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
        consumer.stop();
        assertDoesNotThrow(consumerThread::interrupt);
    }
}

