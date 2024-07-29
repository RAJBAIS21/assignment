package com.messagequeueapp;

import java.util.Random;

public class Producer implements Runnable {
    private final MessageQueue queue;
    private final int messageCount;

    public Producer(MessageQueue queue, int messageCount) {
        this.queue = queue;
        this.messageCount = messageCount;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < messageCount; i++) {
            String message = "Message " + i;
            try {
                queue.produce(message);
                System.out.println("Produced: " + message);
                Thread.sleep(random.nextInt(1000)); // Simulate time taken to produce message
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Producer interrupted");
            }
        }
    }
}
