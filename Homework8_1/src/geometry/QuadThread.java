package geometry;

public class QuadThread extends Thread {
    private Quad q;

    public QuadThread(Quad quad) {
        q = quad;
    }

    @Override
    public void run() {
        try {
            while (q.isAlive()) {
                q.move();
                Thread.sleep(5);
            }
        } catch (InterruptedException ex) {

        }
    }
}
