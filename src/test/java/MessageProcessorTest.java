import com.messagequeueapp.MessageProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MessageProcessorTest {
    private MessageProcessor processor;

    @BeforeEach
    public void setUp() {
        processor = new MessageProcessor();
    }

    @Test
    public void testProcessMessageSuccess() {
        processor.processMessage("Test Message 1");
        assertEquals(1, processor.getSuccessfulMessages());
        assertEquals(0, processor.getErrorMessages());
    }

    @Test
    public void testProcessMessageFailure() {
        for (int i = 0; i < 100; i++) {
            processor.processMessage("Test Message " + i);
        }
        assertEquals(100, processor.getSuccessfulMessages() + processor.getErrorMessages());
        // Asserting that there are some errors and some successful messages
        assertTrue(processor.getSuccessfulMessages() > 0);
        assertTrue(processor.getErrorMessages() > 0);
    }

    @Test
    public void testLogResults() {
        for (int i = 0; i < 100; i++) {
            processor.processMessage("Test Message " + i);
        }
        processor.logResults();
        assertEquals(100, processor.getSuccessfulMessages() + processor.getErrorMessages());
    }
}
