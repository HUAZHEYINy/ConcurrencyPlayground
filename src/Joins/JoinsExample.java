package Joins;

/**
 * Join will allow one thread to wait for another thread to be completed.
 *  Which means the thread  that invoked the t.join() will be blocked till
 *  the t thread to be finished.
 *
 * If the t thread finished before t.join() is invoked, t.join() will just finish right the way.
 *
 */
public class JoinsExample {

    public static void main(String[] args) {

        final Thread[] threads = new Thread[20];

        //1. Initialize
        for (int i = 0; i < 20; i++) {
            threads[i] = new WorkerThreads(i);
        }

        //2. Start
        for (Thread thread : threads) {
            thread.start();
        }

        //3. Join
        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (final InterruptedException e) {
                System.out.println("Interrupted during sleeping...");
            }
        }

        System.out.println("End of main thread!");

    }
}
