package Synchronization;

public class ThreadInterference extends Thread {
    private Counter counter;
    private String func;

    public ThreadInterference(final Counter counter, final String func) {
        this.counter = counter;
        this.func = func;
    }

    public void run() {
        switch (this.func) {
            case "INCREMENT":
                counter.increment();
                break;
            case "DECREMENT":
                counter.decrement();
                break;
        }
    }

    public static void main(String[] args) {
        final Counter counter = new Counter();
        final Thread threadA = new ThreadInterference(counter, "INCREMENT");
        final Thread threadB = new ThreadInterference(counter, "DECREMENT");

        threadA.start();
        threadB.start();

        System.out.println(counter.value());
    }
}
