package HWLthree;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore=new Semaphore(1, true);
        PingPongPlayer playerOne=new PingPongPlayer("ping", semaphore);
        PingPongPlayer playerTwo=new PingPongPlayer("pong", semaphore);
        playerOne.start();
        playerTwo.start();
        Counter counter=new Counter(0);
        Runnable counterTask=new Runnable() {
            @Override
            public void run() {
                while (counter.getCount()!=Integer.MAX_VALUE){
                    counter.incrementCount();
                }
            }
        };

        Thread.sleep(10000);
        playerOne.interrupt();
        playerTwo.interrupt();
        for (int i = 0; i < 100; i++) {
            new Thread(counterTask).start();
        }

    }
}
