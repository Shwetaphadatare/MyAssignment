class SharedResource {
    private boolean flag = false;

    synchronized void produce() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Producing...");
        flag = true;
        notify();
    }

    synchronized void consume() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consuming...");
        flag = false;
        notify();
    }
}

class Producer implements Runnable {
    private SharedResource sharedResource;

    Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void run() {
        while (true) {
            sharedResource.produce();
            try {
                Thread.sleep(500); // Reduced production time for simplicity
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {
    private SharedResource sharedResource;

    Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void run() {
        while (true) {
            sharedResource.consume();
            try {
                Thread.sleep(500); // Reduced consumption time for simplicity
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class interthread {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(new Producer(sharedResource));
        Thread consumerThread = new Thread(new Consumer(sharedResource));

        producerThread.start();
        consumerThread.start();
    }
}
