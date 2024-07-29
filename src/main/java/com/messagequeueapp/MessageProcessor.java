package com.messagequeueapp;
public class MessageProcessor {
    private int successfulMessages = 0;
    private int errorMessages = 0;

    public synchronized void processMessage(String message) {
        try {
            // Simulate message processing
            if (Math.random() > 0.8) { // Simulate a 20% chance of error
                throw new RuntimeException("Error processing message: " + message);
            }
            successfulMessages++;
            System.out.println("Processed successfully: " + message);
        } catch (Exception e) {
            errorMessages++;
            System.err.println(e.getMessage());
        }
    }

    public synchronized int getSuccessfulMessages() {
        return successfulMessages;
    }

    public synchronized int getErrorMessages() {
        return errorMessages;
    }

    public synchronized void logResults() {
        System.out.println("Total messages processed successfully: " + successfulMessages);
        System.out.println("Total errors encountered: " + errorMessages);
    }
}
