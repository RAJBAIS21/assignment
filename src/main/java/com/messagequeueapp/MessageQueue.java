package com.messagequeueapp;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public void produce(String message) throws InterruptedException {
        queue.put(message);
    }

    public String consume() throws InterruptedException {
        return queue.take();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

