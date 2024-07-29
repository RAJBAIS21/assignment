package com.messagequeueapp;
public class Consumer implements Runnable {
    private final MessageQueue queue;
    private final MessageProcessor processor;
    private volatile boolean running = true; // Add a running flag

    public Consumer(MessageQueue queue, MessageProcessor processor) {
        this.queue = queue;
        this.processor = processor;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                String message = queue.consume();
                processor.processMessage(message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break; // Exit the loop on interruption
            }
        }
    }
}


