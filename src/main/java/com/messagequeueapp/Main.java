package com.messagequeueapp;

public class Main {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();
        MessageProcessor processor = new MessageProcessor();
        int messageCount = 10;

        Producer producer = new Producer(queue, messageCount);
        Consumer consumer = new Consumer(queue, processor);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            // Give some time for the consumer to process remaining messages
            Thread.sleep(5000);
            consumerThread.interrupt(); // Gracefully stop the consumer
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

        // Log the final results
        processor.logResults();
    }
}


