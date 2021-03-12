package HWLthree;

import java.util.concurrent.Semaphore;

public class PingPongPlayer extends Thread {

    private String turn;
    Semaphore semaphore;

    public PingPongPlayer(String turn, Semaphore semaphore){
        this.turn=turn;
        this.semaphore=semaphore;
    }


    @Override
    public void run() {
        while (true) {
            try {
                semaphore.acquire();
                System.out.println(turn);
                semaphore.release();
            } catch (InterruptedException e) {
                break;
            }

        }
    }
}
