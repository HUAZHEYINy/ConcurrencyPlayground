package Joins;

/**
 * Worker thread that used to sleep...
 */
public class WorkerThreads extends Thread {
    private int threadNum;

    public WorkerThreads(final int threadNum) {
        this.threadNum = threadNum;
    }

    public void run() {
        try {
            Thread.sleep(10000);
            System.out.println(String.format("I am thread %d", this.threadNum));
        } catch (final InterruptedException e) {
            System.out.println("Interrupted during sleeping...");
        }
    }
}
