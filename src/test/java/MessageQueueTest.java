import com.messagequeueapp.MessageQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MessageQueueTest {
    private MessageQueue queue;

    @BeforeEach
    public void setUp() {
        queue = new MessageQueue();
    }

    @Test
    public void testProduceAndConsume() throws InterruptedException {
        String message = "Test Message";
        queue.produce(message);
        String consumedMessage = queue.consume();
        assertEquals(message, consumedMessage);
    }

    @Test
    public void testIsEmpty() throws InterruptedException {
        assertTrue(queue.isEmpty());
        queue.produce("Test Message");
        assertTrue(!queue.isEmpty());
    }
}

