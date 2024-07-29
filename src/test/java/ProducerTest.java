import com.messagequeueapp.MessageQueue;
import com.messagequeueapp.Producer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ProducerTest {
    private MessageQueue queue;
    private Producer producer;

    @BeforeEach
    public void setUp() {
        queue = new MessageQueue();
        producer = new Producer(queue, 10);
    }

    @Test
    public void testRun() {
        Thread producerThread = new Thread(producer);
        assertDoesNotThrow(producerThread::start);
    }
}
