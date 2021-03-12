package HWLthree;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private int count;

    private Lock lock;

    public Counter(int startCount) {
        this.count = startCount;
        this.lock = new ReentrantLock();
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        boolean flag = true;
        while (flag) {
            try {
                lock.tryLock(5000, TimeUnit.MILLISECONDS);

                try {
                    flag=false;
                    if (count < Integer.MAX_VALUE) count++;
                    System.out.println("Counter was incremented by: " + Thread.currentThread());
                    System.out.println(count);
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().isInterrupted();
            }
        }
    }

}
