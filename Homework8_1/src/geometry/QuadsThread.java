package geometry;

public class QuadsThread extends Thread{
        private QuadCanvas quads;

        public QuadsThread(QuadCanvas canvas) {
            quads = canvas;
        }

        @Override
        public void run() {
            try {
                while (quads.getQuads().size()!=0) {
                    for(Quad q : quads.getQuads()) {
                        q.move();
                    }
                    Thread.sleep(5);
                }
            } catch (InterruptedException ex) {

            }
        }
}
