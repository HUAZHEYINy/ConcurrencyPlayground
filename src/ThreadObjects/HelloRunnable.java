package ThreadObjects;

public class HelloRunnable implements Runnable {

    public void run() {
        System.out.println("Hello from Runnable.");
    }

    public static void main(String[] args) {
        (new Thread(new HelloRunnable())).start();
    }
}
