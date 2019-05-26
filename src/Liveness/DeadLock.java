package Liveness;

/**
 * Why deadlock here?
 *  alphonse 调用 synchronized bow 方法,
 *    那么也就是拥有了 alphonse 的锁, 在 bow 方法内部它想调用 gaston 的 bowBack 方法, 所以它需要请求 gaston 锁.
 *
 *  但是与此同时, gaston 调用 synchronized bow 方法，
 *    那么也就是拥有了 gaston 的锁， 在 bow 方法内部它想调用 alphonse 的 bowBack 方法，所以它需要请求 alphonse 锁。
 *
 *  由此我们可以看到，他俩相互请求对方的锁造成了死锁。
 *
 * NOTE: Synchronized method intrinsic lock 是对于对象唯一的。
 */
public class DeadLock {
    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                            + "  has bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        }).start();
        new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        }).start();
    }
}
