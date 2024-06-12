import java.util.LinkedList;

class SharedBuffer {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws InterruptedException {
        while (buffer.size() == capacity) {
            // Buffer is full, wait for consumer to consume
            wait();
        }

        buffer.add(value);
        System.out.println("Produced: " + value);
        notify(); // Notify consumer that a value is produced
    }

    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            // Buffer is empty, wait for producer to produce
            wait();
        }

        int value = buffer.removeFirst();
        System.out.println("Consumed: " + value);
        notify(); // Notify producer that a value is consumed
        return value;
    }
}

class Producer implements Runnable {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                buffer.produce(i);
                Thread.sleep(1000); // Simulate time to produce a value
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                int value = buffer.consume();
                Thread.sleep(1500); // Simulate time to consume a value
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Producer_consumer {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(2);

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }
}